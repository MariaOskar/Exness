package com.exness.api;

import static io.restassured.RestAssured.given;

public class API {

    public static final String API_FORMS = "https://www.exness.com/api/calculator/forms/";
    public static final String API_CALCULATE = "https://www.exness.com/api/calculator/calculate/";

    public static io.restassured.response.Response getResponse(String form_type, String instrument, String symbol, String lot, String leverage, String user_currency){
        return given()
                .queryParam("form_type", form_type)
                .queryParam("instrument", instrument)
                .queryParam("symbol", symbol)
                .queryParam("lot", lot)
                .queryParam("leverage", leverage)
                .queryParam("user_currency", user_currency)
                .get(API_CALCULATE);
    }

    public static io.restassured.response.Response getAccountsResponse(){
        return given()
                .get(API_FORMS);
    }


}
