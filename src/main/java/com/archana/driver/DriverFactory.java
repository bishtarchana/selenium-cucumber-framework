package com.archana.driver;

import com.archana.utils.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory
{
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance){
        driver.set(driverInstance);
    }

    public static void initializeDriver() {
        String browser = System.getProperty("browser");
        if (browser == null || browser.isEmpty()) {
            browser = ConfigManager.getBrowser();
        }
        switch (browser.toLowerCase()) {
            case "edge":
                setDriver(new EdgeDriver());
                break;
            case "chrome":
                setDriver(new ChromeDriver());
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    public static void quitDriver(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}