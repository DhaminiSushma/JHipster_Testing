package com.epam.ui.stepdefinitions;

import com.epam.hooks.WebDriverHook;
import com.epam.ui.pages.HomePage;
import com.epam.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InvalidCredentialsTest {
    private final WebDriver driver= WebDriverHook.getDriver();
    private LoginPage loginPage;
    @Given("User with invalid Credentials navigates to Login Page")
    public void userNavigatesToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }
    @When("User enters invalid Username {string}, invalid Password {string} and RememberMe {string}")
    public void userEntersInvalidUsernameInvalidPasswordAndRememberMe(String username, String password, String rememberMe) {
        loginPage=new LoginPage(driver);
        loginPage.login(username,password, Boolean.valueOf(rememberMe));
    }
    @Then("Page will display message {string}")
    public void pageWillDisplayMessage(String message) {
        String actual=loginPage.invalidMessage();
        Assert.assertEquals(actual,message);
    }
}
