package com.techtorial.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public AndroidElement username;

    @AndroidFindBy(id = "android:id/text1")
    public AndroidElement country;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']")
    public AndroidElement genderF;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement loginButton;

    @AndroidFindBy(uiAutomator = "text(\"Algeria\")")
    public AndroidElement algeria;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bolivia\"));")
    public AndroidElement bolivia;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public AndroidElement toastMessage;




}
