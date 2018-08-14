package com.exness.tests.integration;

import com.exness.api.API;
import com.exness.tests.ui.BaseTest;
import com.exness.utils.TestUtils;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.exness.ExnessSite.calculatorPage;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorIntegrationTest extends BaseTest{
    DocumentContext json;

    @BeforeMethod
    public void before( Object[] args ){
        json = JsonPath.parse(API.getResponse(((String)args[0]).toLowerCase(), "Forex", (String)args[1], (String)args[2], (String)args[3], ((String)args[4]).split(" - ")[0]).then().extract().body().asString());
        calculatorPage.enter();
    }

    @Test(dataProvider = "calculatorIntegrationTest")
    public void calculatorIntegrationTest(String form_type, String symbol, String lot, String leverage, String user_currency){
        String currency = json.read("$.user_currency");

        calculatorPage
                .selectAccount(form_type)
                .selectForex(symbol)
                .selectCurrency(user_currency)
                .selectLeverage("1:"+leverage)
                .enterLot(lot)
                .submit();

        assertThat(calculatorPage.formulasSection.getMarginFormulaStr()).isEqualTo(json.read("$.margin_formula1"));
        assertThat(calculatorPage.formulasSection.getMarginFormulaNum()).isEqualTo(json.read("$.margin_formula2"));
        assertThat(calculatorPage.formulasSection.getProfitFormulaStr()).isEqualTo(json.read("$.profit_formula1"));
        assertThat(calculatorPage.formulasSection.getProfitFormulaNum()).isEqualTo(json.read("$.profit_formula2"));
        if(TestUtils.getCryptoList().contains(symbol)){
            assertThat(calculatorPage.formulasSection.ifSwapBlockDisplayed()).isEqualTo(false);
        }else{
            assertThat(calculatorPage.formulasSection.getSwapFormulaStr()).isEqualTo(json.read("$.swap_formula1"));
            assertThat(calculatorPage.formulasSection.getSwapFormulaLong()).isEqualTo(json.read("$.swap_formula2"));
            assertThat(calculatorPage.formulasSection.getSwapFormulaShort()).isEqualTo(json.read("$.swap_formula3"));
        }
        assertThat(calculatorPage.formulasSection.getVolumeFormulaStr()).isEqualTo(json.read("$.volume_formula1"));
        assertThat(calculatorPage.formulasSection.getVolumeFormulaNum()).isEqualTo(json.read("$.volume_formula2"));
        assertThat(calculatorPage.formulasSection.getConversionPairs()).containsAllEntriesOf(json.read("$.conversion_pairs"));

        assertThat(calculatorPage.resultSection.getMargin()).isEqualTo(json.read("$.margin")+" "+currency);
        assertThat(calculatorPage.resultSection.getProfit()).isEqualTo(json.read("$.profit")+" "+currency);
        if(TestUtils.getCryptoList().contains(symbol)){
            assertThat(calculatorPage.resultSection.getSwapLong()).isEqualTo(json.read("$.swap_long"));
            assertThat(calculatorPage.resultSection.getSwapShort()).isEqualTo(json.read("$.swap_short"));
        }else{
            assertThat(calculatorPage.resultSection.getSwapLong()).isEqualTo(json.read("$.swap_long")+" pt. = "+json.read("$.long")+" "+currency);
            assertThat(calculatorPage.resultSection.getSwapShort()).isEqualTo(json.read("$.swap_short")+" pt. = "+json.read("$.short")+" "+currency);
        }
        assertThat(calculatorPage.resultSection.getVolume()).isEqualTo(json.read("$.volume_mln_usd"));
    }

    @DataProvider(name = "calculatorIntegrationTest")
    public Object[][] calculationQuery(){
        return new Object[][]{
                {"Classic", "AUDCAD", "10000", "800", "USD - Американский доллар"},
                {"Classic", "AUDDKK", "10000", "800", "USD - Американский доллар"},
                {"Classic", "BCHUSD", "1000", "800", "USD - Американский доллар"}
        };
    }
}