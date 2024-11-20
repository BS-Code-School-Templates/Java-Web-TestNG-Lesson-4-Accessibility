package org.browserstack.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends Base{
    By loginButton = By.id("loginButton");
    By contactButton = By.id("contactButton");
    By productsButton = By.id("productsButton");
    By a11yButton = By.id("accessibilityButton");

    public Home(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() { driver.findElement(loginButton).click(); }

    public void goToContactPage() { driver.findElement(contactButton).click(); }

    public void goToProductsPage() { driver.findElement(productsButton).click(); }

    public void goToAccessibilityPage() { driver.findElement(a11yButton).click(); }
}
