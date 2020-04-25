package com.techtorial.Intro.appium;

import com.techtorial.utils.AndroidDriverUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;


public class LocatorTypes {


    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = AndroidDriverUtils.setupDesiredCapabilities("ApiDemos-debug");
        driver = AndroidDriverUtils.getAndroidDriver(caps);
    }

    @Test
    public void locators() {

        AndroidElement accessibility = driver.findElementByAccessibilityId("Accessibility");
        accessibility.click();

        AndroidElement customView = driver.findElementByAndroidUIAutomator("text(\"Custom View\")");
        customView.click();


    }


}
