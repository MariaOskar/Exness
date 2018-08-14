package com.exness.sections;

import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.LinkedHashMap;
import java.util.List;

public class FormulasSection extends Section {

    public static final By FORMULAS_BLOCK = By.cssSelector("div.col-lg-7.col-md4-4.col-sm-7");
    public static final By MARGIN_FORMULA_STR = By.id("margin_formula1");
    public static final By MARGIN_FORMULA_NUM = By.id("margin_formula2");
    public static final By SWAP_BLOCK = By.xpath("//h3[contains(@class,'swap')]/parent::div");
    public static final By SWAP_FORMULA_STR = By.id("swap_formula1");
    public static final By SWAP_FORMULA_LONG = By.id("swap_formula2");
    public static final By SWAP_FORMULA_SHORT = By.id("swap_formula3");
    public static final By PROFIT_VOLUME_BLOCK = By.xpath("//p[contains(@id,'profit_formula1')]/parent::div");
    public static final By PROFIT_FORMULA_NUM = By.id("profit_formula2");
    public static final By PROFIT_FORMULA_STR = By.id("profit_formula1");
    public static final By VOLUME_FORMULA_STR = By.id("volume_formula1");
    public static final By VOLUME_FORMULA_NUM = By.id("volume_formula2");
    public static final By CONVERSION_PAIRS_BLOCK = By.id("conversion_pairs");
    public static final By PAIR_NAME = By.cssSelector(".calc-pairName");
    public static final By PAIR_VALUE = By.cssSelector(".calc-pairValue");

    private void waitForVisibilityOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(),15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitFormulasBlock(){
        waitForVisibilityOfElement(get(FORMULAS_BLOCK));
    }

    public boolean isFormulasBlockDisplayed(){
        return get(FORMULAS_BLOCK).isDisplayed();
    }

    public boolean ifSwapBlockDisplayed(){
        return get(SWAP_BLOCK).isDisplayed();
    }

    public boolean isProfitVolumeBlockDisplayed(){
        return get(PROFIT_VOLUME_BLOCK).isDisplayed();
    }

    public boolean isConversionPairsBlockDisplayed(){
        return get(CONVERSION_PAIRS_BLOCK).isDisplayed();
    }

    public boolean isMarginFormulaStrDispalyed(){
        return get(MARGIN_FORMULA_STR).isDisplayed();
    }

    public boolean isMarginFormulaNumDisplayed(){
        return get(MARGIN_FORMULA_NUM).isDisplayed();
    }

    public String getVolumeFormulaStr(){
        return waitElementAndGetText(VOLUME_FORMULA_STR);
    }

    public String getMarginFormulaStr(){
        return waitElementAndGetText(MARGIN_FORMULA_STR);
    }

    public String getMarginFormulaNum(){
        return waitElementAndGetText(MARGIN_FORMULA_NUM);
    }

    public String getSwapFormulaStr(){
        return waitElementAndGetText(SWAP_FORMULA_STR);
    }

    public String getSwapFormulaLong(){
        return waitElementAndGetText(SWAP_FORMULA_LONG);
    }

    public String getSwapFormulaShort(){
        return waitElementAndGetText(SWAP_FORMULA_SHORT);
    }

    public String getProfitFormulaNum(){
        return waitElementAndGetText(PROFIT_FORMULA_NUM);
    }

    public String getProfitFormulaStr(){
        return waitElementAndGetText(PROFIT_FORMULA_STR);
    }

    public String getVolumeFormulaNum(){
        return waitElementAndGetText(VOLUME_FORMULA_NUM);
    }

    private String waitElementAndGetText(By locator){
        waitForVisibilityOfElement(get(locator));
        return get(locator).getText();
    }

    public LinkedHashMap<String,Double> getConversionPairs(){
        LinkedHashMap<String,Double> pairs = new LinkedHashMap<String, Double>();
        waitForVisibilityOfElement(get(CONVERSION_PAIRS_BLOCK));
        List<WebElement> paragraphs = get(CONVERSION_PAIRS_BLOCK).findElements(By.tagName("p"));
        for(WebElement p: paragraphs){
            String pairName = p.findElement(PAIR_NAME).getText();
            Double pairValue = Double.valueOf(p.findElement(PAIR_VALUE).getText());
            pairs.put(pairName,pairValue);
        }
        return pairs;
    }
}
