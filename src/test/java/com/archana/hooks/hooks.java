package com.archana.hooks;

import com.archana.driver.DriverFactory;
import com.archana.utils.ConfigManager;
import com.archana.utils.ExtentManager;
import com.archana.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class hooks {

    private static final ExtentReports extent = ExtentManager.getExtentReports();
    private ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        WebDriver driver;
        String browser = System.getProperty("browser");
        if(browser == null || browser.isEmpty()){
            browser = ConfigManager.getBrowser();
        }
        DriverFactory.initializeDriver(browser);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigManager.getUrl());
        //extent test
        test = extent.createTest(scenario.getName());
        test.info("Scenario started: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        try{
            if(scenario.isFailed()){
                String screenshotPath = ScreenshotUtil.captureScreenshot(scenario.getName());
                assert screenshotPath != null;
                test.fail("Scenario FAILED", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }else{
                test.pass("Scenario Passed");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DriverFactory.quitDriver();
            extent.flush();
        }
    }
}