package com.exness.tests.ui;


import com.exness.utils.TestUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static com.exness.ExnessSite.calculatorPage;

public class CalculatorTest extends BaseTest {

    @Test(dataProvider = "CalculationData")
    public void test(String account, String symbol, String lot, String leverage, String user_currency){
        calculatorPage
                .enter()
                .selectAccount(account)
                .selectForex(symbol)
                .selectCurrency(user_currency)
                .selectLeverage("1:"+leverage)
                .enterLot(lot)
                .submit()
                .checkVisibilityOfFormulaBlock()
                .checkVisibilityOfMarginFormulas()
                .checkVisibilityOfProfitVolumeBlock()
                .checkVisibilityOfConversationPairsBlock()
                .checkVisibilityOfSwapBlock(TestUtils.getCryptoList().contains(symbol))
                .checkVisibilityOfResultBlock();

    }

    @DataProvider(name = "CalculationData")
    public Object[][] calculationQuery(){
        return new Object[][]{
               {"Mini", "USDDKKm", "10000", "800", "MBBUSD - 4 металла: Золото + Серебро + Платина + Палладий"},
                {"Classic", "BCHUSD", "1000", "800", "USD - Американский доллар"},
                {"Cent", "AUDCADc", "10000", "800", "USC - Американский цент"}
        };
    }
}
