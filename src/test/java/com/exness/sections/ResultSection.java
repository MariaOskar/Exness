package com.exness.sections;

import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.By;


public class ResultSection extends Section {

    public static final By MARGIN = By.id("margin");
    public static final By PROFIT = By.id("profit");
    public static final By SWAP_LONG = By.id("swap_long");
    public static final By SWAP_SHORT = By.id("swap_short");
    public static final By VOLUME = By.id("volumemlnusd");
    public static final By RESULT_BLOCK = By.cssSelector(".calc-colResult--result");

    public boolean isResultBlockDisplayed(){
        return get(RESULT_BLOCK).isDisplayed();
    }

    public String getMargin(){
        return get(MARGIN).getText();
    }

    public String getProfit(){
        return get(PROFIT).getText();
    }

    public String getSwapLong(){
        return get(SWAP_LONG).getText();
    }

    public String getSwapShort(){
        return get(SWAP_SHORT).getText();
    }

    public String getVolume(){
        return get(VOLUME).getText();
    }

}