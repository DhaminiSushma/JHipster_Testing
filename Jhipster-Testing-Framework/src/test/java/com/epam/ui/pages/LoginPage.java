package com.epam.ui.pages;
import com.epam.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import static com.epam.utils.WebDriverUtils.*;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){super(driver);}
    private final By userName=By.id("username");
    private final By passWord=By.id("password");
    private final By rememberMe=By.id("rememberMe");
    private final By submitButton= By.cssSelector("button[type='submit']");
    private final By failed=By.tagName("strong");
    public void login(String username, String password, Boolean rememberMe){
        WebElement user=findWebElement(getDriver(),userName);
        WebElement pass=findWebElement(getDriver(),passWord);
        WebElement submit=findWebElement(getDriver(),submitButton);
        WebElement rememberMeCheckbox=findWebElement(getDriver(),this.rememberMe);
        sendKeys(user,username);
        sendKeys(pass,password);
        if(rememberMe){
            click(rememberMeCheckbox);
        }
        click(submit);
    }
    public String invalidMessage(){
        return findWebElement(getDriver(),failed).getText();
    }
    @Override
    public String verifyTitle(){
        Wait<WebDriver> wait=getWait(120);
        wait.until(ExpectedConditions.titleIs("Welcome, Java Hipster!"));
        return getTitle(getDriver());
    }
}