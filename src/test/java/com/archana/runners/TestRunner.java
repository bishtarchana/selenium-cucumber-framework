package com.archana.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features="src/test/resources/features",
        glue={"com.archana"},
        plugin={
                "pretty",
                "html:reports/cucumber-report.html"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}