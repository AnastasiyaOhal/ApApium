package com.techtorial.Intro.appium.eccomerceApp;

import com.techtorial.pages.CartPage;
import com.techtorial.pages.LoginPage;
import com.techtorial.pages.ProductPage;
import com.techtorial.utils.AndroidDriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class EcommerceIntro {

    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = AndroidDriverUtils.setupDesiredCapabilities("ecommerceApp");
        driver = AndroidDriverUtils.getAndroidDriver(caps);
    }

    @Test
    public void loginTestPositive() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.country.click();
        loginPage.bolivia.click();
        loginPage.username.sendKeys("Anastasiya");
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
        loginPage.genderF.click();
        loginPage.loginButton.click();

    }

    @Test
    public void loginTestNegative() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginButton.click();

        String message = loginPage.toastMessage.getAttribute("name");
        Assert.assertEquals("Please enter your name", message);

    }

    @Test
    public void addShoesToCart() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.country.click();
//        loginPage.bolivia.click();
        loginPage.username.sendKeys("Anastasiya");
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
        loginPage.genderF.click();
        loginPage.loginButton.click();
        AndroidElement jordan9shoes = productPage.jordan9shoes;
        productPage.addToCart.click();
        productPage.cartView.click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withDuration(Duration.ofSeconds(2)).withElement(ElementOption.element(cartPage.generalTerms))).perform();

        Assert.assertTrue(cartPage.terms.isDisplayed());

        cartPage.closeButton.click();
        cartPage.visitWebsiteButton.click();

        Thread.sleep(3000);
        Set<String> contextHandles = driver.getContextHandles();
        System.out.println(contextHandles);

        cartPage.visitWebsiteButton.click();
        Thread.sleep(3000);
        Set<String> contextHandles1 = driver.getContextHandles();
        System.out.println(contextHandles1);

        driver.context("WEBVIEW_com.androidsample.deneralstore");
        

    }

}
