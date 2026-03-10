package com.archana.hooks;

import com.archana.driver.DriverFactory;
import com.archana.utils.ConfigManager;
import com.archana.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class hooks {

    @Before
    public void setUp(){
        WebDriver driver;
        String browser = System.getProperty("browser");
        if(browser == null || browser.isEmpty()){
            browser = ConfigManager.getBrowser();
        }
        DriverFactory.initializeDriver(browser);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigManager.getUrl());
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            ScreenshotUtil.captureScreenshot(scenario.getName());
        }
        DriverFactory.quitDriver();
    }
}