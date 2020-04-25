package com.techtorial.Intro.appium;

import com.techtorial.utils.AndroidDriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;


public class Gestures {
    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = AndroidDriverUtils.setupDesiredCapabilities("ApiDemos-debug");
        driver = AndroidDriverUtils.getAndroidDriver(caps);
    }


    @Test
    public void tapGesture() {

        AndroidElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();

        AndroidElement expendableList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expendableList))).perform();

        AndroidElement customAdapter = driver.findElementByAccessibilityId("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();

        AndroidElement catNames = driver.findElement(By.xpath("//android.widget.TextView[@text='Cat Names']"));
        Assert.assertEquals("Cat Names", catNames.getText());

    }


    @Test
    public void longPress() {

        AndroidElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();

        AndroidElement expendableList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expendableList))).perform();

        AndroidElement customAdapter = driver.findElementByAccessibilityId("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();

        AndroidElement peopleNames = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2)).withElement(ElementOption.element(peopleNames))).perform();

        AndroidElement sampleMenu = driver.findElementByAndroidUIAutomator("text(\"Sample menu\")");
        Assert.assertEquals("Failed to verify Sample Menu text", "Sample menu", sampleMenu.getText());
        Assert.assertTrue("Failed to verify Sample Menu is nit displayed", sampleMenu.isDisplayed());

    }


    @Test
    public void longPress2() {

        AndroidElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();

        AndroidElement expendableList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expendableList))).perform();

        AndroidElement customAdapter = driver.findElementByAccessibilityId("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();

        AndroidElement fishNames = driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(fishNames))).perform();

        List<AndroidElement> fishNameList = driver.findElements("//+[@text='Goldy']", "//+[@text='Bubbles']");

        Assert.assertEquals(2, fishNameList.size());

        for (AndroidElement element : fishNameList) {
            Assert.assertTrue(element.isDisplayed());
        }
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withDuration(Duration.ofSeconds(2)).withElement(ElementOption.element(fishNames))).perform();

        AndroidElement sampleMenu = driver.findElementByAndroidUIAutomator("text(\"Sample menu\")");
        Assert.assertTrue(sampleMenu.isDisplayed());

    }


}
