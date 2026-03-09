package com.archana.stepdefinitions;

import com.archana.pages.LoginPage;
import com.archana.utils.LoginDataManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("User is on login page")
    public void user_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
       //
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUsername(LoginDataManager.getValidUsername());
        loginPage.enterPassword(LoginDataManager.getValidPassword());
        loginPage.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String actual = loginPage.getSuccessMessage();
        String expected = LoginDataManager.getExpectedSuccessTitle();
        Assert.assertEquals(actual,expected);
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.enterUsername(LoginDataManager.getInvalidUsername());
        loginPage.enterPassword(LoginDataManager.getInvalidPassword());
        loginPage.clickLoginButton();
    }

    @Then("User should see error message")
    public void user_should_see_error_message() {
        String actual = loginPage.getErrorMessage();
        String expected = LoginDataManager.getExpectedErrorMessage();
        Assert.assertEquals(actual,expected);
    }
}
