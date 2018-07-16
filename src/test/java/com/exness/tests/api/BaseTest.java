package com.exness.tests.api;

import com.exness.services.CalculateService;
import org.testng.annotations.BeforeTest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseTest {

    public Retrofit retrofit;
    public CalculateService service;

    @BeforeTest
    public void beforeTest(){

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.exness.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(CalculateService.class);

    }




}
