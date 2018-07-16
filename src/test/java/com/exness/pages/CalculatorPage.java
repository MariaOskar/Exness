package com.exness.pages;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Input;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.exness.enumerable.AccountEnum;
import com.exness.sections.FormulasSection;
import org.openqa.selenium.support.FindBy;


@JPage(url = "/intl/ru/tools/calculator/")
public class CalculatorPage extends WebPage {

    public FormulasSection formulasSection;

    @JDropdown(
            jroot = @JFindBy(xpath = "//*[@id=\"calculator-mount-node\"]//input[@name=\"account\"]/parent::div"),
            jexpand = @JFindBy(css = ".ui-selectBtnChoose.icon-arrow-down"),
            jlist = @JFindBy(css = ".ui-selectItem")
           //jvalue = @JFindBy(xpath = "./span[2]")
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
        lot.sendKeys(str);
        return this;
    }

    public CalculatorPage submit(){
        submit_button.click();
        return this;
    }

    public CalculatorPage enter(){
        this.open();
        return this;
    }


}
