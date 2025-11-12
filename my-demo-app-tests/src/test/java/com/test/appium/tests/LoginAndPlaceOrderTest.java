package com.test.appium.tests;

import com.test.appium.BaseTest;
import com.test.appium.pages.LoginPage;
import com.test.appium.pages.ProductPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

/*
 * This test uses placeholder IDs and credentials. Replace placeholders with
 * real values found in your app using Appium Inspector / UIAutomatorViewer.
 */
public class LoginAndPlaceOrderTest extends BaseTest {

    @Test
    public void loginSelectAddPlaceOrder() throws InterruptedException {
        AndroidDriver driverLocal = (AndroidDriver) driver;
        LoginPage login = new LoginPage(driverLocal);
        ProductPage products = new ProductPage(driverLocal);

        // Replace with valid demo credentials for the app
        login.login("testuser", "testpassword");

        Thread.sleep(2000);

        products.selectFirstProductAndAddToCart();

        Thread.sleep(1000);
        products.goToCartAndCheckout();
    }
}