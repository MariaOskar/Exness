package com.exness.tests.api;

import com.exness.models.CalculateResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


public class TestService extends BaseTest {

    @Test(dataProvider = "CalculationQuery")
    public void test(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency){

        Call<CalculateResult> call = service.calculate(form_type, instrument, symbol, lot, leverage, user_currency);
        try {
            Response<CalculateResult> response = call.execute();
            CalculateResult result = response.body();
            System.out.println(result);
            assertThat(result.getMargin_formula2()).contains("/ "+leverage+" = ");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @DataProvider(name = "CalculationQuery")
    public Object[][] calculationQuery(){
        return new Object[][]{
                {"cent", "Forex", "AUDCADc", "0.1", "800", "USC"}
        };
    }


}
