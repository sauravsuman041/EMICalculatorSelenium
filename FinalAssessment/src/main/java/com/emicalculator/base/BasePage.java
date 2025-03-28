package com.emicalculator.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    protected void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void onClick(WebElement element) {
        waitForElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void enterText(WebElement element, String text) {
        waitForElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        //element.clear();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE); 
        wait.withTimeout(Duration.ofSeconds(2));
        element.sendKeys(text);
    }

    protected void dragAndDropByOffset(WebElement element, int xOffset, int yOffset) {
        waitForElement(element);
        actions.dragAndDropBy(element, xOffset, yOffset).perform();
    }
    
    protected void dragAndDropToDestinationElement(WebElement element, WebElement destination) {
        waitForElement(element);
        actions.dragAndDrop(element, destination).perform();
    }
}

