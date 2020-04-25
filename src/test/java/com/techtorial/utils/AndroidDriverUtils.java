package com.techtorial.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverUtils {

    public static AndroidDriver getAndroidDriver(DesiredCapabilities cap) throws MalformedURLException {
        //setting the server URL to connect to
        URL appiumServerUrl = new URL(" http://localhost:4723/wd/hub");
        //instantiating driver
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerUrl, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static DesiredCapabilities setupDesiredCapabilities(String appName) {
        File apkFile = new File("src/test/resources/" + appName + ".apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //device name to connect
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nastia");
        // platform to use
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        // automation name
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //Android application to test
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        return desiredCapabilities;

    }
}
