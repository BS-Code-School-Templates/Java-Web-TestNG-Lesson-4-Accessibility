package org.browserstack.training.pageobjects;

import org.openqa.selenium.WebDriver;

public class Base {
    WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }
}
