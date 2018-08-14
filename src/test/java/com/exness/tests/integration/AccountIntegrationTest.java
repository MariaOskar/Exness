package com.exness.tests.integration;

import java.util.*;
import com.exness.api.API;
import com.exness.tests.ui.BaseTest;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.exness.ExnessSite.calculatorPage;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountIntegrationTest extends BaseTest{

    DocumentContext json;

    @BeforeMethod
    public void before(){
        json = JsonPath.parse(API.getAccountsResponse().then().extract().body().asString());
        calculatorPage.enter();
    }

    @Test
    public void accountDataIntegrationTest(){

        Set<String> keySet = ((Map<String,Object>)json.read("$")).keySet();

        List<String> accounts = new ArrayList<>();
        calculatorPage.getAccountsList().forEach((object) -> accounts.add(object.toLowerCase()));

        assertThat(accounts).containsExactlyInAnyOrderElementsOf(keySet);

        for(String account: calculatorPage.getAccountsList()){
            calculatorPage.selectAccount(account);
            String key = account.toLowerCase();
            assertThat(calculatorPage.getCurrenciesList()).containsExactlyInAnyOrderElementsOf(json.read("$."+key+".currencies[*][1]"));
            assertThat(calculatorPage.getSymbolsList()).containsExactlyInAnyOrderElementsOf(json.read("$."+key+".instruments.Forex.symbols[*][1]"));
            List<Integer> leverages = new ArrayList<>();
            calculatorPage.getLeverageList().forEach((obj) -> leverages.add(Integer.valueOf(obj.substring(2))));
            assertThat(leverages).containsExactlyInAnyOrderElementsOf(json.read("$."+key+".available_leverages"));
            assertThat(calculatorPage.getLotValue()).isEqualTo(json.read("$."+key+".default_lot"));
        }
    }
}