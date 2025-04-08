package com.epam.ui.stepdefinitions;

import com.epam.hooks.WebDriverHook;
import com.epam.ui.pages.HomePage;
import com.epam.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ValidCredentialsLoginTest {
    private final WebDriver driver=WebDriverHook.getDriver();
    private LoginPage loginPage;
    @Given("User with valid Credentials navigates to Login Page")
    public void userNavigatesToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }


    @When("User enters valid Username {string}, valid Password {string} and RememberMe {string}")
    public void userEntersUsernamePasswordAndRememberMe(String username, String password, String rememberMe) {
        loginPage=new LoginPage(driver);
        loginPage.login(username,password, Boolean.valueOf(rememberMe));
    }

    @Then("Page Title After Successfully Login In will be {string}")
    public void pageTitleAfterSuccessfullyLoginInWillBe(String title) {
        String actual=loginPage.verifyTitle();
        Assert.assertEquals(actual,title);
    }

}
