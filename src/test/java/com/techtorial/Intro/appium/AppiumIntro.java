package com.techtorial.Intro.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumIntro {
    DesiredCapabilities desiredCapabilities;
    URL appiumServerUrl;
    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        desiredCapabilities = new DesiredCapabilities();

        //device name to connect
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nastia");

        // platform to use
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");

        // automation name
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        //Android application to test
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        //setting the server URL to connect to
        appiumServerUrl = new URL(" http://localhost:4723/wd/hub");

        //instantiating driver
        driver = new AndroidDriver<AndroidElement>(appiumServerUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void firstCall() throws MalformedURLException {

        AndroidElement preference = driver.findElementByAccessibilityId("Preference");
        preference.click();
        AndroidElement defaultValues = driver.findElementByAccessibilityId("4. Default values");
        defaultValues.click();
        AndroidElement checkBox = driver.findElementById("android:id/checkbox");
        checkBox.click();
    }

    @Test
    public void secondCall() {
        AndroidElement media = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Media\"]"));
        media.click();

    }


}
