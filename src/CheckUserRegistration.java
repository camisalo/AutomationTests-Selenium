import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class CheckUserRegistration {

    public static WebDriver driver = null;

    String user = "TestAutomationUser";
    String password = "password";
    String email = "AutomationTest@gmail.com";

    public CheckUserRegistration() {
        System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Web app
        driver.navigate().to("localhost:3006");
//        driver.manage().window().maximize();
        String title = driver.getTitle();

        if (title.equalsIgnoreCase("Construction Equipment Finder")){
            System.out.println("Title Matches");
        } else {
            System.out.println(title);
        }
    }

    public Boolean startTest() throws InterruptedException{
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[1]/a"));
        Actions action = new Actions(driver);
        action.click(element).perform();
        Thread.sleep(500);

        WebElement r_user = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement r_password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement r_reppassword = driver.findElement(By.xpath("//*[@id=\"repassword\"]"));
        WebElement r_email = driver.findElement(By.xpath("//*[@id=\"email\"]"));

        r_user.sendKeys(user);
        r_password.sendKeys(password);
        r_reppassword.sendKeys(password);
        r_email.sendKeys(email);
        Thread.sleep(500);

        WebElement r_button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button"));
        action.click(r_button).perform();
        Thread.sleep(2000);

        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(500);

//        driver.switchTo().window(parentWindowHandler);

        WebElement login = driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[2]/a"));
        action.click(login).perform();
        Thread.sleep(500);

        WebElement l_user = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement l_password = driver.findElement(By.xpath("//*[@id=\"password\"]"));

        l_user.sendKeys(user);
        l_password.sendKeys(password);

        WebElement l_button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button"));
        action.click(l_button).perform();
        Thread.sleep(500);

        Boolean res = isElementPresent(By.xpath("//*[@id=\"root\"]/div/div/div/button[1]"));

        driver.close();

        return res;
    }

    private boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
