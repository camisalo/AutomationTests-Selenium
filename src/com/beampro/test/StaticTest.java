package com.beampro.test;

import com.beampro.test.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StaticTest {
    public static WebDriver driver;
    private Helper helper;

    public StaticTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kgebczyn/Studia/Praca Dyplomowa/selenium/AutomationTests-Selenium/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        helper = new Helper(driver);
        driver.navigate().to("localhost:3000");
        driver.manage().window().maximize();


        helper.clickButton("//*[@id=\"root\"]/div/div[1]/div[2]/div/a[3]");
    }

    public void close() {
        driver.close();
    }

    public void changeLenghtTest() throws InterruptedException {
        helper.clearAndInsert("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div/div/div[3]/input","5");

        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/button");

        helper.scrollToElement("//*[@id=\"idForCharts\"]/div/div[1]");
        helper.checkElementExist("//*[@id=\"idForCharts\"]/div/div[1]");

        helper.scrollToElement("//*[@id=\"idForCharts\"]/div/div[2]");
        helper.checkElementExist("//*[@id=\"idForCharts\"]/div/div[2]");

        Thread.sleep(2000);
    }

    public void addLoadConstTest() throws InterruptedException {
        helper.selectDropDown(
                "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/div[1]/select",
                "Punktowe"
                );

        helper.scrollToElement("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div");

        helper.clearAndInsert("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/div[2]/input","5");
        helper.clearAndInsert("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/div[3]/input","5");

        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/div[2]/img");

        helper.checkElementExist("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/table/tbody/tr[3]");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/table/tbody/tr[3]/th[2]","5");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/table/tbody/tr[3]/th[3]","5");
    }

    public void removeLoadConstTest() throws InterruptedException {
        this.addLoadConstTest();
        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/table/tbody/tr[3]/th[5]/img");
        helper.checkElementDontExist("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/table/tbody/tr[3]");
    }

    public void addLoadVarTest() throws InterruptedException {
        helper.selectDropDown(
                "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div[1]/select",
                "Punktowe"
        );

        helper.scrollToElement("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div");

        helper.clearAndInsert("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div[2]/input","5");
        helper.clearAndInsert("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div[3]/input","5");

        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[2]/img");

        helper.checkElementExist("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[3]");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[3]/th[2]","5");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[3]/th[3]","5");
    }

    public void removeLoadVarTest() throws InterruptedException {
        this.addLoadVarTest();

        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[3]/th[5]/img");
        helper.checkElementDontExist("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[3]");
    }


}
