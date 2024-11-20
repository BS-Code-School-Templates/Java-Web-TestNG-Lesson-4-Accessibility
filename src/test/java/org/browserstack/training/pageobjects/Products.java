package org.browserstack.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Products extends Base {
    By product1Image = By.id("product1Image");
    By product2Image = By.id("product2Image");
    By product3Image = By.id("product3Image");
    By addToCartButtonProduct1 = By.id("addToCartButtonProduct1");
    By addToCartButtonProduct2 = By.id("addToCartButtonProduct2");
    By addToCartButtonProduct3 = By.id("addToCartButtonProduct3");
    By cartCount = By.id("cart-count");
    By cartIcon = By.id("cartIcon");
    By totalItems = By.id("item-total");

    public Products(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(String productType) throws Exception {
        if (productType.toLowerCase().equals("desktop")) {
            driver.findElement(addToCartButtonProduct1).click();
        } else if (productType.toLowerCase().equals("tablet")) {
            driver.findElement(addToCartButtonProduct2).click();
        } else if (productType.toLowerCase().equals("mobile")) {
            driver.findElement(addToCartButtonProduct3).click();
        } else {
            throw new java.lang.Exception("Invalid option was passed to function");
        }
    }

    public WebElement getProduct1Image() { return driver.findElement(product1Image); }
    public WebElement getProduct2Image() { return driver.findElement(product2Image); }
    public WebElement getProduct3Image() { return driver.findElement(product3Image); }
    public WebElement getProduct1Button() { return driver.findElement(addToCartButtonProduct1); }
    public WebElement getProduct2Button() { return driver.findElement(addToCartButtonProduct2); }
    public WebElement getProduct3Button() { return driver.findElement(addToCartButtonProduct3); }
    public WebElement getCartCount() { return driver.findElement(cartCount); }
    public WebElement getCartIcon() { return driver.findElement(cartIcon); }
    public WebElement getItemTotal() { return driver.findElement(totalItems); }
}
