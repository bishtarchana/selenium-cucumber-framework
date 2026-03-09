package com.archana.hooks;

import com.archana.driver.DriverFactory;
import com.archana.utils.ConfigManager;
import com.archana.utils.JsonUtil;
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
        String browser = ConfigManager.getBrowser();
        WebDriver driver;
        if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        DriverFactory.setDriver(driver);
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