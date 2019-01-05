import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Prepare {

    public static WebDriver driver = null;

    String user = "TestAutomationUser_API";
    String password = "password";
    String email = "AutomationTest_API@gmail.com";


    public Prepare() {
        System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to("localhost:3006");
    }

    public void startPrepare() throws InterruptedException{
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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(500);

        WebElement api = driver.findElement(By.xpath("//*[@id=\"api\"]"));
        api.clear();
        api.sendKeys("https://localhost:5001/api/equipments");

        WebElement save = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button[2]"));
        action.click(save).perform();
        Thread.sleep(500);

        alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(500);

        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(500);

        WebElement logout = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button[1]"));
        action.click(logout).perform();
        Thread.sleep(500);

        driver.close();
    }
}
