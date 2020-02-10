package com.beampro.test;

import com.beampro.test.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CalculationTest {
    public static WebDriver driver;
    private Helper helper;

    public CalculationTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kgebczyn/Studia/Praca Dyplomowa/selenium/AutomationTests-Selenium/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        helper = new Helper(driver);
        driver.navigate().to("localhost:3000");


        helper.clickButton("//*[@id=\"root\"]/div/div[1]/div[2]/div/a[2]");
        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/button");

        helper.scrollToElement("//*[@id=\"idForCharts\"]/div/div[1]");
        helper.checkElementExist("//*[@id=\"idForCharts\"]/div/div[1]");

        helper.scrollToElement("//*[@id=\"idForCharts\"]/div/div[2]");
        helper.checkElementExist("//*[@id=\"idForCharts\"]/div/div[2]");

        helper.scrollToElement("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]");
    }

    public void close() {
        driver.close();
    }

    public void changeSteel() throws InterruptedException {
        helper.selectDropDown("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select", "RB500W");
        Thread.sleep(1000);

        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]", "RB500W");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]", "A-IIIN");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[3]/td[2]", "500 MPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]", "420 MPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[5]/td[2]", "550 MPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[6]/td[2]", "200 GPa");
    }

    public void changeConcrete() {
        helper.selectDropDown("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/select", "C20/25");

        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[2]", "C20/25");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[2]/td[2]", "20 MPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[3]/td[2]","28 MPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[4]/td[2]","2.21 MPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[5]/td[2]","29.96 GPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[6]/td[2]","13.33 MPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[7]/td[2]","11.33 MPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[8]/td[2]","1.03 MPa");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[9]/td[2]","0.13");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/table/tbody/tr[10]/td[2]","0.072");
    }

    public void takeMaxMoment() throws InterruptedException {
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/input","100");
        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[4]/button[1]");
        Thread.sleep(1000);
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/input","50");
    }

    public void checkBendingCalculations() throws InterruptedException {
        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[4]/button[2]");
        Thread.sleep(1000);
        helper.scrollToElement("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div");

        helper.checkElementExist("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[1]/td[2]","1 cm");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[2]/td[2]","1 cm");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[3]/td[2]","2 cm");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[4]/td[2]","0.03");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[5]/td[2]","57.5 cm");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[6]/td[2]","0.2");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[7]/td[2]","11.24 cm");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[8]/td[2]","10.15 cm2");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[9]/td[2]","12.57 cm2");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[10]/td[2]","238.76 kN");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[11]/td[2]","238.76 kN");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[12]/td[2]","13.93 cm");
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div/table/tbody/tr[13]/td[2]","120.66 kN");
    }

    public void checkDecreasingBarNumber() throws InterruptedException {
        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[4]/button[2]");
        Thread.sleep(1000);
        helper.scrollToElement("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div");

        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[3]/div/table[1]/tbody/tr/td[3]/img","http://localhost:3000/img/check.png");
        helper.clearAndInsert("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[5]/input","3");
        Thread.sleep(1000);

        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div/div[3]/div/table[1]/tbody/tr/td[3]/img","http://localhost:3000/img/cross.png");
    }

    public void takeMaxVerticalForce() throws InterruptedException {
        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[4]/button[2]");
        Thread.sleep(1000);
        helper.scrollToElement("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[4]");

        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[4]/div[1]/div[4]/input","0");
        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[4]/div[2]/button[1]");
        Thread.sleep(1000);
        helper.checkValue("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[4]/div[1]/div[4]/input","10");
    }

    public void checkVertivalCalc() throws InterruptedException {
        this.takeMaxMoment();

        helper.clickButton("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[4]/div[2]/button[2]");
        Thread.sleep(1000);

        helper.scrollToElement("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[4]/div[3]/div/div[1]/div");






    }
}
