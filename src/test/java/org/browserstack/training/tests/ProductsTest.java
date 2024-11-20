package org.browserstack.training.tests;

import org.browserstack.training.pageobjects.Contact;
import org.browserstack.training.pageobjects.Home;
import org.browserstack.training.pageobjects.Products;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class ProductsTest {
    String name = "Automation Tester";
    String email = "automation@testing.com";
    String subject = "The Subject";
    String message = "This is a message";

    WebDriver driver;
    Home homePage;
    Products productsPage;

    Random rand = new Random();
    String[] productList = {"Desktop", "Tablet", " Mobile"};

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://browserstacktraining.site");
        driver.manage().window().maximize();
        homePage = new Home(driver);
        productsPage = new Products(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void singleProductTest() {
        try {
            homePage.goToProductsPage();

            int randomNumber = rand.nextInt(3) + 1;
            productsPage.addProductToCart(productList[randomNumber]);

            Assert.assertEquals(productsPage.getCartCount().getText(), "1");
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void multipleProductsTest() {
        try {
            homePage.goToProductsPage();

            for (int i = 0; i < productList.length; i++) {
                int randomNumber = rand.nextInt(3) + 1;
                productsPage.addProductToCart(productList[randomNumber]);
            }

            Assert.assertEquals(productsPage.getCartCount().getText(), String.valueOf(productList.length));
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }
}
