package com.exness;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.exness.pages.CalculatorPage;

@JSite(value = "https://www.exness.com")
public class ExnessSite extends WebSite {

    public static CalculatorPage calculatorPage;
}
