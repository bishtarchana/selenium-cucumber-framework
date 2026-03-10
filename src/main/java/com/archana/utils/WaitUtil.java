package com.archana.utils;

import com.archana.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtil {
    public static void waitForElement(By locator){
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10)).
        until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}