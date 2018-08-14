package com.exness.tests.api;

import com.exness.api.API;
import com.exness.utils.TestUtils;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static com.exness.utils.matchers.RegExpMatcher.regExp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;


public class TestService {
    private static final String DATAPROVIDER_FILENAME = "dataprovider.yaml";

    @Test(dataProvider= "yaml")
    public void generalStructureTest(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency) {

        DocumentContext json = JsonPath.parse(API.getResponse(form_type, instrument, symbol, lot, leverage, user_currency).then().extract().body().asString());

        Set<String> keySet = ((Map<String,Object>)json.read("$")).keySet();
        assertThat(keySet).containsAll(Arrays.asList("commission", "conversion_pairs", "long", "lots_mln_usd", "margin",
                "margin_formula1", "margin_formula2", "no_quotes", "profit", "profit_formula1", "profit_formula2", "short",
                "swap_char", "swap_enable", "swap_formula1", "swap_formula2", "swap_formula3", "swap_long", "swap_short",
                "tick_size", "user_currency", "volume_formula1", "volume_formula2", "volume_mln_usd", "form_type"));

    }

    @Test(dataProvider= "yaml")
    public void generalContentTest(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency){

        String firstPart = symbol.substring(0,3);
        String secPart = symbol.substring(3,6);

        String profitFormula = "([\\d\\.]+) x ([\\d\\.]+) x "+lot+"(\\.00)? = ([\\d\\.]+) "+secPart;
        String volumeFormula = lot+"(\\.00)? x ([\\d\\.]+) = ([\\d\\.]+) "+firstPart;
        String swapFormula = lot+"(\\.00)? x ([\\d\\.]+) x ([\\d\\.\\-]+) x ([\\d\\.]+) = ([\\d\\.\\-]+) "+secPart;

      API.getResponse(form_type, instrument, symbol, lot, leverage, user_currency)
                .then()
                .body("swap_enable",equalTo(true))
                .body("form_type", equalTo(form_type))
                .body("user_currency", equalTo(user_currency))
                .body("profit_formula2", is(regExp(profitFormula)))
                .body("volume_formula2", is(regExp(volumeFormula)))
                .body("swap_formula2", is(regExp(swapFormula)))
                .body("swap_formula3", is(regExp(swapFormula)))
      ;
    }

    @Test(dataProvider= "yaml")
    public void shortMarginFormulaTest(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency) {
        String firstPart = symbol.substring(0,3);
        String marginFormula = lot+"(.00)? x ([\\d\\.]+) / "+leverage+" = ([\\d\\.]+) "+firstPart;

        API.getResponse(form_type, instrument, symbol, lot, leverage, user_currency)
                .then()
                .body("margin_formula2", is(regExp(marginFormula)));
    }

    @Test(dataProvider= "yaml")
    public void longMarginFormulaTest(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency) {

        String firstPart = symbol.substring(0,3);
        String marginFormula = lot+"(.00)? x ([\\d\\.]+) x ([\\d\\.]+)% = ([\\d\\.]+) "+firstPart;

        API.getResponse(form_type, instrument, symbol, lot, leverage, user_currency)
                .then()
                .body("margin_formula2", is(regExp(marginFormula)));
    }

    @Test(dataProvider= "yaml")
    public void cryptoTest(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency) {

        API.getResponse(form_type, instrument, symbol, lot, leverage, user_currency)
                .then()
                .body("swap_formula1", equalTo(null))
                .body("swap_formula2", equalTo(null))
                .body("swap_formula3", equalTo(null))
                .body("long", equalTo(null))
                .body("short", equalTo(null))
                .body("swap_char", equalTo(null))
                .body("swap_enable", equalTo(false))
                .body("swap_long", equalTo("0.00"))
                .body("swap_short",equalTo("0.00"))
                .body("conversion_pairs", hasKey(symbol));
    }

    @Test(dataProvider= "yaml")
    public void accountDataTest(String account){
        API.getAccountsResponse()
                .then()
                .body("$", hasKey(account))
                .body(account, hasKey("instruments"))
                .body(account+".instruments", hasEntry(anything(),hasKey("symbols")))
                .body(account+".instruments", hasEntry(anything(),hasKey("label")))
                .body(account, hasKey("currencies"))
                .body(account+".currencies", instanceOf(ArrayList.class ))
                .body(account, hasKey("default_lot"))
                .body(account+".default_lot", equalTo(Float.valueOf("0.1")))
                .body(account, hasKey("default_leverage"))
                .body(account, hasKey("available_leverages"))
                .body(account+".available_leverages", instanceOf(ArrayList.class ))
        ;

    }

    @Test(dataProvider= "yaml")
    public void negativeValuesTest(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency){
        API.getResponse(form_type, instrument, symbol, lot, leverage, user_currency)
                .then()
                .body("user_currency[0]",equalTo("\""+user_currency+"\" не является корректным значением."))
                .body("leverage[0]",equalTo("\""+leverage+"\" не является корректным значением."))
                .body("instrument[0]",equalTo("\""+instrument+"\" не является корректным значением."))
                .body("lot[0]",equalTo("Требуется численное значение."))
                .body("symbol[0]",equalTo("\""+symbol+"\" не является корректным значением."));
    }

    @Test(dataProvider= "yaml")
    public void badFormTypeTest(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency){
        API.getResponse(form_type, instrument, symbol, lot, leverage, user_currency)
                .then()
                .body("form_type[0]",equalTo("Поле обязательно для заполнения."));
    }

    @Test(dataProvider= "yaml")
    public void badLotTest(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency){
        API.getResponse(form_type, instrument, symbol, lot, leverage, user_currency)
                .then()
                .body("lot[0]",equalTo("Убедитесь что значение больше или равно 0.01."));
    }


    @DataProvider(name= "yaml")
    public Object[][] yaml(Method method){
        return TestUtils.getDataProviderFromYaml(DATAPROVIDER_FILENAME, method.getName());
    }
}
