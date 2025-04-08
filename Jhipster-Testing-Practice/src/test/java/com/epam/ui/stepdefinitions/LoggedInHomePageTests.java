package com.epam.ui.stepdefinitions;

import com.epam.hooks.WebDriverHook;
import com.epam.ui.pages.HomePage;
import com.epam.ui.pages.Jhipster_Logged_In_HomePage;
import com.epam.ui.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class LoggedInHomePageTests {
    WebDriver driver= WebDriverHook.getDriver();
    private LoginPage loginPage;
    private Jhipster_Logged_In_HomePage loggedInHomePage;
    @Given("User is on HomePage and presses sign in")
    public void userIsOnHomePageAndPressesSignIn() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }

    @And("User enters valid username , valid password and rememberMe:")
    public void userEntersValidUsernameValidPasswordAndRememberMe(DataTable dataTable) {
        Map<String,String> credentials=dataTable.asMap(String.class, String.class);
        String username=credentials.get("username");
        String password=credentials.get("password");
        String rememberMe= credentials.get("rememberMe");
        loginPage=new LoginPage(driver);
        loginPage.login(username,password, Boolean.valueOf(rememberMe));
    }

    @And("User is now Logged in to the page with Title {string}")
    public void userIsNowLoggedInToThePageWithTitle(String title) {
        String actual=loginPage.verifyTitle();
        Assert.assertEquals(actual,title);
    }
    @When("User navigates to Bank Account Page")
    public void userNavigatesToBankAccountPage() {
        loggedInHomePage=new Jhipster_Logged_In_HomePage(driver);
        loggedInHomePage.goToBankAccountPage();
    }

    @Then("User gets Page Title as {string}")
    public void userGetsPageTitleAs(String title) {
        String actualTitle=loggedInHomePage.verifyTitle();
        Assert.assertEquals(actualTitle,title);
    }

}
