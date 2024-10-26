package com.enuygundemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage() {
        if (wait == null && driver != null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

	public WebElement waitAndFind(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

	public void click(By locator) {
		find(locator).click();

	}
	public void set(By locator, String mail) {
		find(locator).clear();
        find(locator).sendKeys(mail);
        find(locator).sendKeys(Keys.ENTER);
		
	}
}
