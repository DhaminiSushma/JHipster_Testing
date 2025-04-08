package com.epam.hooks;

import com.epam.runners.UiRunner;
import com.epam.ui.factories.BrowserType;
import com.epam.ui.factories.DriverFactory;
import com.epam.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverHook {
    private static WebDriver driver;
    ConfigReader configReader=ConfigReader.getInstance();
    DriverFactory driverFactory;
    @Before
    public void before(){
        BrowserType browserType=BrowserType.valueOf(configReader.getProperty("browser").toUpperCase());
        driverFactory=DriverFactory.getInstance(browserType);
        driver= driverFactory.getDriver();
        driver.get("http://localhost:9000/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    }
    @After
    public void teardown(){
        driverFactory.quitDriver();
        driver.quit();
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Make sure setUp() is executed before calling getDriver().");
        }
        return driver;
    }
}
