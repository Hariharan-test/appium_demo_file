package com.test.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/*
 * IMPORTANT: Replace the RESOURCE_ID_* placeholders with actual resource-id or accessibility-id values
 * discovered via Appium Inspector or UIAutomatorViewer.
 */
public class LoginPage {
    private AndroidDriver driver;

    // Placeholder IDs - replace with actual IDs from the app.
    private final String usernameFieldId = "RESOURCE_ID_USERNAME"; // e.g. "com.example.app:id/username"
    private final String passwordFieldId = "RESOURCE_ID_PASSWORD";
    private final String loginButtonId   = "RESOURCE_ID_LOGIN_BUTTON";

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebElement user = driver.findElement(AppiumBy.id(usernameFieldId));
        user.clear();
        user.sendKeys(username);

        WebElement pass = driver.findElement(AppiumBy.id(passwordFieldId));
        pass.clear();
        pass.sendKeys(password);

        driver.findElement(AppiumBy.id(loginButtonId)).click();
    }
}