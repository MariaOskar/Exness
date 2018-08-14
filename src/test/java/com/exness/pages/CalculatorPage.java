package com.exness.pages;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Input;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.exness.sections.FormulasSection;
import com.exness.sections.ResultSection;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


@JPage(url = "/intl/ru/tools/calculator/")
public class CalculatorPage extends WebPage {

    public FormulasSection formulasSection;
    public ResultSection resultSection;
    public static final int TIMEOUT = 10;

    @JDropdown(
            jroot = @JFindBy(xpath = "//*[@id=\"calculator-mount-node\"]//input[@name=\"account\"]/parent::div"),
            jexpand = @JFindBy(css = ".ui-selectBtnChoose.icon-arrow-down"),
            jlist = @JFindBy(css = ".ui-selectItem")
    )
    public IDropDown account;

    @JDropdown(
            jroot = @JFindBy(xpath = "//*[@id=\"calculator-mount-node\"]//input[@name=\"SymbolsForex\"]/parent::div"),
            jexpand = @JFindBy(css = ".ui-selectBtnChoose.icon-arrow-down"),
            jlist = @JFindBy(css = ".ui-selectItem")
    )
    public IDropDown symbolsForex;

    @JDropdown(
            jroot = @JFindBy(xpath = "//*[@id=\"calculator-mount-node\"]//input[@name=\"Currency\"]/parent::div"),
            jexpand = @JFindBy(css = ".ui-selectBtnChoose.icon-arrow-down"),
            jlist = @JFindBy(css = ".ui-selectItem")
    )
    public IDropDown currency;

    @JDropdown(
            jroot = @JFindBy(xpath = "//*[@id=\"calculator-mount-node\"]//input[@name=\"Leverage\"]/parent::div"),
            jexpand = @JFindBy(css = ".ui-selectBtnChoose.icon-arrow-down"),
            jlist = @JFindBy(css = ".ui-selectItem")
    )
    public IDropDown leverage;

    @JFindBy (css = "#id_Lot")
    private Input lot;

    @JFindBy (css = ".calc-colFormBtn button")
    private Button submit_button;

    @FindBy(css = "div.row.ui-formRow.cent-selector>div.col.calc-colFormLabel.txt-h4")
    public Label text;

    public Double getLotValue(){
        return Double.valueOf(lot.getValue());
    }

    public void clickText(){
        text.click();
    }

    public CalculatorPage selectAccount(String str){
        account.close();
        account.select(str);
        return this;
    }

    public CalculatorPage selectCurrency(String str){
        currency.select(str);
        return this;
    }

    public CalculatorPage selectLeverage(String str){
        leverage.select(str);
        return this;
    }

    public CalculatorPage selectForex(String str){
        symbolsForex.select(str);
        return this;
    }

    public CalculatorPage enterLot(String str){
        lot.clear();
        lot.sendKeys(str);
        return this;
    }

    public CalculatorPage submit(){
        WebDriverWait wait = new WebDriverWait(getDriver(),TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(submit_button.getWebElement()));
        submit_button.click();

        formulasSection.waitFormulasBlock();
        return this;
    }

    public CalculatorPage enter(){
        this.open();
        return this;
    }

    public List<String> getAccountsList(){
        return selectValues(account);
    }

    public List<String> getSymbolsList(){
        return selectValues(symbolsForex);
    }

    public List<String> getLeverageList(){
        return selectValues(leverage);
    }

    public List<String> getCurrenciesList(){
        return selectValues(currency);
    }

    public List<String> selectValues(IDropDown select){
        select.expand();
        List<String> values = select.getOptions();
        clickText();
        return values;
    }

    public CalculatorPage checkVisibilityOfFormulaBlock(){
        assertTrue(formulasSection.isFormulasBlockDisplayed());
        return this;
    }

    public CalculatorPage checkVisibilityOfSwapBlock(boolean isCrypto){
        if(!isCrypto) {
            assertTrue(formulasSection.ifSwapBlockDisplayed());
            assertTrue(formulasSection.getSwapFormulaStr().length()>0);
            assertTrue(formulasSection.getSwapFormulaShort().length()>0);
            assertTrue(formulasSection.getSwapFormulaLong().length()>0);
        }
        else assertFalse(formulasSection.ifSwapBlockDisplayed());
        return this;
    }

    public CalculatorPage checkVisibilityOfMarginFormulas(){
        assertTrue(formulasSection.isMarginFormulaStrDispalyed());
        assertTrue(formulasSection.isMarginFormulaNumDisplayed());
        assertTrue(formulasSection.getMarginFormulaStr().length()>0);
        assertTrue(formulasSection.getMarginFormulaNum().length()>0);
        return this;
    }

    public CalculatorPage checkVisibilityOfProfitVolumeBlock(){
        assertTrue(formulasSection.isProfitVolumeBlockDisplayed());
        assertTrue(formulasSection.getProfitFormulaNum().length()>0);
        assertTrue(formulasSection.getProfitFormulaStr().length()>0);
        assertTrue(formulasSection.getVolumeFormulaStr().length()>0);
        assertTrue(formulasSection.getVolumeFormulaNum().length()>0);
        return this;
    }

    public CalculatorPage checkVisibilityOfConversationPairsBlock(){
        assertTrue(formulasSection.isConversionPairsBlockDisplayed());
        assertTrue(formulasSection.getConversionPairs().size()>0);
        return this;
    }

    public CalculatorPage checkVisibilityOfResultBlock(){
        assertTrue(resultSection.isResultBlockDisplayed());
        assertTrue(resultSection.getMargin().length()>0);
        assertTrue(resultSection.getProfit().length()>0);
        assertTrue(resultSection.getSwapLong().length()>0);
        assertTrue(resultSection.getSwapShort().length()>0);
        assertTrue(resultSection.getVolume().length()>0);
        return this;
    }

}
