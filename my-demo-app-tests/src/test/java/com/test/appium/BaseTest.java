package com.test.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.time.Duration;

/*
 * NOTE: Replace app package/activity or set MobileCapabilityType.APP to your local APK path.
 * Update DEVICE_NAME to your emulator (eg. emulator-5554) or AVD name.
 */
public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // caps.setCapability(MobileCapabilityType.APP, "/path/to/MyDemoApp.apk");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.saucelabs.mydemoapp.rn"); // <-- replace if different
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.saucelabs.mydemoapp.rn.MainActivity"); // <-- replace if different
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);

        URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(appiumServer, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}