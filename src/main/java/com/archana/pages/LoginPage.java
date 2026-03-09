package com.archana.pages;

import com.archana.driver.DriverFactory;
import com.archana.utils.JsonUtil;
import com.archana.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By successMessage = By.id("flash");
    By errorMessage = By.cssSelector(".flash.error");

    public LoginPage(){
        this.driver = DriverFactory.getDriver();
    }

    public void enterUsername(String user){
        WaitUtil.waitForElement(username);
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }


    public String getSuccessMessage(){
        return driver.findElement(successMessage).getText().split("\n")[0].trim();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText().split("\n")[0].trim();
    }

    public boolean isLoginSuccessful(){
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isErrorDisplayed(){
        return driver.findElement(errorMessage).isDisplayed();
    }

}