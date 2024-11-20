package org.browserstack.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends Base {
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By submitButton = By.id("submit");
    By messageElement = By.id("message");

    public Login(WebDriver driver) {
        super(driver);
    }

    public void performLogin(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(submitButton).click();
    }

    public WebElement getUsernameField() { return driver.findElement(usernameField); }
    public WebElement getPasswordField() { return driver.findElement(passwordField); }
    public WebElement getSubmitButton() { return driver.findElement(submitButton); }
    public WebElement getMessageElement() { return driver.findElement(messageElement); }
}
