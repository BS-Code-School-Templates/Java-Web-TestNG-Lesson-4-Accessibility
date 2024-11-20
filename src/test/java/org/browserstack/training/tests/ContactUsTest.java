package org.browserstack.training.tests;

import org.browserstack.training.pageobjects.Contact;
import org.browserstack.training.pageobjects.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest {
    String name = "Automation Tester";
    String email = "automation@testing.com";
    String subject = "The Subject";
    String message = "This is a message";

    WebDriver driver;
    Home homePage;
    Contact contactPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://browserstacktraining.site");
        driver.manage().window().maximize();
        homePage = new Home(driver);
        contactPage = new Contact(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void contactUsFormTest() {
        try {
            homePage.goToContactPage();

            contactPage.submitContactForm(name, email, subject, message);

            Assert.assertTrue(contactPage.getSuccessField().isDisplayed());
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }
}
