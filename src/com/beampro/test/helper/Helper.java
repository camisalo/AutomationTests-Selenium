package com.beampro.test.helper;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Helper {
    public WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void clearAndInsert(String xpath, String value) {
        WebElement length = driver.findElement(By.xpath(xpath));
        length.clear();
        length.sendKeys(value);
    }

    public void clickButton(String xpath) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions action = new Actions(driver);
        action.click(element).perform();
        Thread.sleep(500);
    }

    public void checkElementExist(String xpath) {
        boolean element = driver.findElements(By.xpath(xpath)).size() > 0;
        Assertions.assertTrue(element);
    }

    public void checkElementDontExist(String xpath) {
        boolean element = driver.findElements(By.xpath(xpath)).size() > 0;
        Assertions.assertFalse(element);
    }

    public void checkValue(String xpath, String value) {
        WebElement element = driver.findElement(By.xpath(xpath));
        if (element.getTagName().equals("input")){
            Assertions.assertEquals(value, element.getAttribute("value"));
        } else if (element.getTagName().equals("img")) {
            Assertions.assertEquals(value, element.getAttribute("src"));
        } else {
            Assertions.assertEquals(value, element.getText());
        }
    }

    public void selectDropDown(String xpath,String visibleText) {
        Select select = new Select(driver.findElement(By.xpath(xpath)));
        select.selectByVisibleText(visibleText);
    }

    public void scrollToElement(String xpath) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }
}
