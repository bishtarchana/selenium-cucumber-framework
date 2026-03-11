package com.archana.utils;

import com.archana.driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotUtil {
    private static final String SCREENSHOT_FOLDER = "target/screenshots/";

    public static String captureScreenshot(String screenshotName) {
        File folder = new File(SCREENSHOT_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            String path = SCREENSHOT_FOLDER + screenshotName + ".png";
            FileUtils.copyFile(src, new File(path));
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
