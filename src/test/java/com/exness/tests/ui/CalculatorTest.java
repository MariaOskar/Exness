package com.exness.tests.ui;


import org.testng.annotations.Test;


import static com.exness.ExnessSite.calculatorPage;

public class CalculatorTest extends BaseTest {

    @Test
    public void test(){

        calculatorPage
                .enter()
                .selectAccount("Mini")
                .selectForex("USDDKKm")
                .selectCurrency("CHC - Швейцарский рап")
                .selectLeverage("1:888")
                .enterLot("1")
                .submit();


    }





}
