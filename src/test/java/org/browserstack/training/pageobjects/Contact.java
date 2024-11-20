package org.browserstack.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact extends Base {
    By nameField = By.id("name");
    By emailField = By.id("email");
    By subjectField = By.id("subject");
    By messageField = By.id("message");
    By submitButton = By.id("submit");
    By successMessageElement = By.id("successMessage");

    public Contact(WebDriver driver) {
        super(driver);
    }

    public void submitContactForm(String name, String email, String subject, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);

        driver.findElement(submitButton).click();
    }

    public WebElement getNameField() { return driver.findElement(nameField); }
    public WebElement getEmailField() { return driver.findElement(emailField); }
    public WebElement getSubjectField() { return driver.findElement(subjectField); }
    public WebElement getMessageField() { return driver.findElement(messageField); }
    public WebElement getSuccessField() { return driver.findElement(successMessageElement); }
}
