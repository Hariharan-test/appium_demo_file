package com.test.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/*
 * IMPORTANT: Replace RESOURCE_ID_* placeholders with actual IDs from the app.
 */
public class ProductPage {
    private AndroidDriver driver;

    private final String firstProductId = "RESOURCE_ID_FIRST_PRODUCT";
    private final String addToCartButtonId = "RESOURCE_ID_ADD_TO_CART";
    private final String cartButtonId = "RESOURCE_ID_CART_BUTTON";
    private final String checkoutButtonId = "RESOURCE_ID_CHECKOUT_BUTTON";
    private final String placeOrderButtonId = "RESOURCE_ID_PLACE_ORDER";

    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectFirstProductAndAddToCart() {
        WebElement product = driver.findElement(AppiumBy.id(firstProductId));
        product.click();
        driver.findElement(AppiumBy.id(addToCartButtonId)).click();
    }

    public void goToCartAndCheckout() {
        driver.findElement(AppiumBy.id(cartButtonId)).click();
        driver.findElement(AppiumBy.id(checkoutButtonId)).click();
        driver.findElement(AppiumBy.id(placeOrderButtonId)).click();
    }
}