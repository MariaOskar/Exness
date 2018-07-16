package com.exness.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.exness.pages.CalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

import static com.exness.ExnessSite.calculatorPage;

public class FormulasSection extends Section {

    public static final By FORMULAS_BLOCK = By.cssSelector("div.col-lg-7.col-md4-4.col-sm-7");
    public static final By MARGIN_FORMULA_STR = By.id("margin_formula1");
    public static final By MARGIN_FORMULA_NUM = By.id("margin_formula2");
    public static final By SWAP_BLOCK = By.xpath("//h3[contains(@class,'swap')]/parent::div");
    public static final By SWAP_FORMULA_STR = By.id("swap_formula1");
    public static final By SWAP_FORMULA_LONG = By.id("swap_formula2");
    public static final By SWAP_FORMULA_SHORT = By.id("swap_formula3");
    public static final By COMMISSION_BLOCK = By.xpath("//h3[contains(@class,'commission')]/parent::div");
    public static final By COMMISSION_FORMULA_STR = By.id("commission_formula1");
    public static final By COMMISSION_FORMULA_NUM = By.id("commission_formula2");
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

    public boolean isFormulasBlockDisplayed(){
        return getFormulasBlockElement().isDisplayed();
    }

    public boolean ifSwapBlockDisplayed(){
        return getSwapBlockElement().isDisplayed();
    }

    public boolean isComissionBlockDisplayed(){
        return getComissionBlockElement().isDisplayed();
    }

    public boolean isProfitVolumeBlockDisplayed(){
        return getProfiVolumeBlockElement().isDisplayed();
    }

    public boolean isConversionPairsBlockDisplayed(){
        return getConversionPairsBlockElement().isDisplayed();
    }


    public WebElement getFormulasBlockElement(){
        return getDriver().findElement(FORMULAS_BLOCK);
    }

    public WebElement getVolumeFormulaStrElement(){
        return calculatorPage.getDriver().findElement(VOLUME_FORMULA_STR);
    }

    public String getVolumeFormulaStr(){
        waitForVisibilityOfElement(getVolumeFormulaStrElement());
        return getVolumeFormulaStrElement().getText();
    }

    public WebElement getMarginFormulaStrElement(){
        return calculatorPage.getDriver().findElement(MARGIN_FORMULA_STR);
    }

    public String getMarginFormulaStr(){
        waitForVisibilityOfElement(getMarginFormulaStrElement());
        return getMarginFormulaStrElement().getText();
    }

    public WebElement getMarginFormulaNumElement(){
        return calculatorPage.getDriver().findElement(MARGIN_FORMULA_NUM);
    }

    public String getMarginFormulaNum(){
        waitForVisibilityOfElement(getMarginFormulaNumElement());
        return getMarginFormulaNumElement().getText();
    }

    public WebElement getSwapBlockElement(){
        return getDriver().findElement(SWAP_BLOCK);
    }

    public WebElement getSwapFormulaStrElement(){
        return calculatorPage.getDriver().findElement(SWAP_FORMULA_STR);
    }

    public String getSwapFormulaStr(){
        waitForVisibilityOfElement(getSwapFormulaStrElement());
        return getSwapFormulaStrElement().getText();
    }

    public WebElement getSwapFormulaLongElement(){
        return calculatorPage.getDriver().findElement(SWAP_FORMULA_LONG);
    }

    public String getSwapFormulaLong(){
        waitForVisibilityOfElement(getSwapFormulaLongElement());
        return getSwapFormulaLongElement().getText();
    }

    public WebElement getSwapFormulaShortElement(){
        return calculatorPage.getDriver().findElement(SWAP_FORMULA_SHORT);
    }

    public String getSwapFormulaShort(){
        waitForVisibilityOfElement(getSwapFormulaShortElement());
        return getSwapFormulaShortElement().getText();
    }

    public WebElement getComissionBlockElement(){
        return getDriver().findElement(COMMISSION_BLOCK);
    }

    public WebElement getCommissionFormulaStrElement(){
        return calculatorPage.getDriver().findElement(COMMISSION_FORMULA_STR);
    }

    public String getCommissionFormulaStr(){
        waitForVisibilityOfElement(getCommissionFormulaStrElement());
        return getCommissionFormulaStrElement().getText();
    }

    public WebElement getCommissionFormulaNumElement(){
        return calculatorPage.getDriver().findElement(COMMISSION_FORMULA_NUM);
    }

    public String getCommissionFormulaNum(){
        waitForVisibilityOfElement(getCommissionFormulaNumElement());
        return getCommissionFormulaNumElement().getText();
    }

    public WebElement getProfiVolumeBlockElement(){
        return getDriver().findElement(PROFIT_VOLUME_BLOCK);
    }

    public WebElement getProfitFormulaNumElement(){
        return calculatorPage.getDriver().findElement(PROFIT_FORMULA_NUM);
    }

    public String getProfitFormulaNum(){
        waitForVisibilityOfElement(getProfitFormulaNumElement());
        return getProfitFormulaNumElement().getText();
    }

    public WebElement getProfitFormulaStrElement(){
        return calculatorPage.getDriver().findElement(PROFIT_FORMULA_STR);
    }

    public String getProfitFormulaStr(){
        waitForVisibilityOfElement(getProfitFormulaStrElement());
        return getProfitFormulaStrElement().getText();
    }

    public WebElement getVolumeFormulaNumElement(){
        return calculatorPage.getDriver().findElement(VOLUME_FORMULA_NUM);
    }

    public String getVolumeFormulaNum(){
        waitForVisibilityOfElement(getVolumeFormulaNumElement());
        return getVolumeFormulaNumElement().getText();
    }

    public WebElement getConversionPairsBlockElement(){
        return getDriver().findElement(CONVERSION_PAIRS_BLOCK);
    }

    public HashMap<String,String> getConversionPairs(){
        HashMap<String,String> pairs = new HashMap<String, String>();
        waitForVisibilityOfElement(getConversionPairsBlockElement());
        List<WebElement> paragraphs = getConversionPairsBlockElement().findElements(By.tagName("p"));
        for(WebElement p: paragraphs){
            String pairName = p.findElement(PAIR_NAME).getText();
            String pairValue = p.findElement(PAIR_VALUE).getText();
            pairs.put(pairName,pairValue);
        }
        return pairs;
    }



}
