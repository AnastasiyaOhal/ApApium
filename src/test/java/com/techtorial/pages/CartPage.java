package com.techtorial.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    public AndroidElement generalTerms;

    @AndroidFindBy(uiAutomator = "text(\"Terms Of Conditions\")" )
    public AndroidElement terms;

    @AndroidFindBy(uiAutomator = "text(\"CLOSE\")" )
    public AndroidElement closeButton;

    @AndroidFindBy(uiAutomator = "text(\"Visit to the website to complete purchase\")" )
    public AndroidElement visitWebsiteButton;

}
