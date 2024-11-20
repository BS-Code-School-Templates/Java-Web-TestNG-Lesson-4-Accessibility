package org.browserstack.training.tests;

import org.browserstack.training.pageobjects.Home;
import org.browserstack.training.pageobjects.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
    String correctUsername = "student";
    String correctPassword = "Password123";
    String wrongUsername = "wrongstudent";
    String wrongPassword = "Password456";

    String successMessage = "Login successful!";
    String incorrectUsernameMessage = "Incorrect username!";
    String incorrectPasswordMessage = "Incorrect password!";
    String incorrectUserAndPassMessage = "Incorrect username and password!";

    WebDriver driver;
    Home homePage;
    Login loginPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://browserstacktraining.site");
        driver.manage().window().maximize();
        homePage = new Home(driver);
        loginPage = new Login(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void successfulLoginTest() {
        try {
            homePage.goToLoginPage();

            loginPage.performLogin(correctUsername, correctPassword);

            Assert.assertEquals(loginPage.getMessageElement().getText(), successMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }


    }

    @Test
    public void failedLoginTestUsername() {
        try {
            homePage.goToLoginPage();

            loginPage.performLogin(wrongUsername, correctPassword);

            Assert.assertEquals(loginPage.getMessageElement().getText(), incorrectUsernameMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedLoginTestPassword() {
        try {
            homePage.goToLoginPage();

            loginPage.performLogin(correctUsername, wrongPassword);

            Assert.assertEquals(loginPage.getMessageElement().getText(), incorrectPasswordMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedLoginTestUsernameAndPassword() {
        try {
            homePage.goToLoginPage();

            loginPage.performLogin(wrongUsername, wrongPassword);

            Assert.assertEquals(loginPage.getMessageElement().getText(), incorrectUserAndPassMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }
}
