package com.techtorial.Intro.appium;

import com.techtorial.utils.AndroidDriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.List;

public class SwipeAction {

    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = AndroidDriverUtils.setupDesiredCapabilities("ApiDemos-debug");
        driver = AndroidDriverUtils.getAndroidDriver(caps);
    }


    @Test
    public void swipe() {
        AndroidElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();

        AndroidElement dateWidgets = driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(dateWidgets))).perform();

        AndroidElement inlineText = driver.findElement(By.xpath("\t//android.widget.TextView[@content-desc=\"2. Inline\"]"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(inlineText))).perform();

        AndroidElement num5 = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"5\"]"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(num5))).perform();

        AndroidElement num15 = driver.findElement(By.xpath("\t//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"15\"]"));
        AndroidElement num40 = driver.findElement(By.xpath("\t//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"40\"]"));

        // touchAction.longPress(ElementOption.element(num15)).moveTo(ElementOption.element(num40)).release().perform();
        // both ways work
        touchAction.press(ElementOption.element(num15)).moveTo(ElementOption.element(num40)).release().perform();

        List<AndroidElement> time= driver.findElements(By.xpath("//android.widget.TextView"));

        AndroidElement hours = driver.findElementById("android:id/hours");
        AndroidElement minutes = driver.findElementById("android:id/minutes");
        AndroidElement column = driver.findElementById("android:id/separator");

        Assert.assertEquals("5:40", hours.getText()+column.getText() + minutes.getText());


        String finalTime = "";
        for (AndroidElement element:time){
            finalTime+=element.getText();
        }

        Assert.assertTrue(finalTime.contains("5:40"));

    }


}
