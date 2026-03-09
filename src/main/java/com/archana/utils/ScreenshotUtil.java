package com.archana.utils;

import com.archana.driver.DriverFactory;
//import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtil {
    public static void captureScreenshot(String name){
        try{
            File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("screenshots/" + name + ".png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
