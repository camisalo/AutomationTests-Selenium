import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kgebczyn/Studia/Praca Dyplomowa/selenium/AutomationTests-Selenium/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Web app
        driver.navigate().to("https://amazon.de");
        driver.manage().window().maximize();
        String title = driver.getTitle();

        if (title.equalsIgnoreCase("Amazon.de")){
            System.out.println("Title Matches");
        } else {
            System.out.println(title);
        }

        // local web element

        WebElement element = driver.findElement(By.xpath("//*[@id=\"nav-link-shopall\"]/span[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(1000);

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[11]/span"));
        action.moveToElement(element1).perform();
        Thread.sleep(1000);

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[3]/div[11]/div/a[4]/span"));
        action.click(element2).perform();
        Thread.sleep(2000);

        WebElement element4 = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        element4.sendKeys("Phantastische Tierwesen");
        WebElement element5 = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
        action.click(element5).perform();
        Thread.sleep(2000);

        driver.close();
    }
}
