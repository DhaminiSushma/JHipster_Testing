package com.epam.ui.pages;

import com.epam.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import static com.epam.utils.WebDriverUtils.click;
import static com.epam.utils.WebDriverUtils.findWebElement;
public class Jhipster_Logged_In_HomePage extends BasePage {
    private final Wait<WebDriver> wait=getWait(120);
    public Jhipster_Logged_In_HomePage(WebDriver driver){
        super(driver);
    }
    private final By entities=By.id("entity-menu");
    private final By bankAccountLink=By.cssSelector("a.dropdown-item[routerlink='/bank-account']");
    public WebDriver goToBankAccountPage(){
        WebElement entityMenu=findWebElement(getDriver(),entities);
        wait.until(ExpectedConditions.visibilityOf(entityMenu));
        click(entityMenu);
        WebElement bankAccount=findWebElement(getDriver(),bankAccountLink);
        wait.until(ExpectedConditions.visibilityOf(bankAccount));
        click(bankAccount);
        wait.until(ExpectedConditions.titleIs("JhipsterSampleApplication"));
        return getDriver();
    }
}