package com.techtorial.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class apiDemosMainPage {

    public apiDemosMainPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "Accessibility")
    public AndroidElement accessibility;

    @AndroidFindBy(xpath = "\t//android.widget.TextView[@content-desc=\"Animation\"]")
    public AndroidElement animation;

    @AndroidFindBy(accessibility = "App")
    public AndroidElement app;

    @AndroidFindBy(uiAutomator = "text(\"Content\")")
    public AndroidElement content;

}
