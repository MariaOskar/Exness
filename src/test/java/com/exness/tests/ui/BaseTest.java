package com.exness.tests.ui;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.exness.ExnessSite;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends TestNGBase {

    @BeforeSuite
    public void setup(){
        WebSite.init(ExnessSite.class);
    }

}
