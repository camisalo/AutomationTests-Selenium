import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CheckAddJSONFile {

    public static WebDriver driver = null;

    String user = "TestAutomationUser";
    String password = "password";
    String email = "AutomationTest@gmail.com";

    public CheckAddJSONFile() {
        System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Web app
        driver.navigate().to("localhost:3006");
//        driver.manage().window().maximize();
        String title = driver.getTitle();
    }

    public String startTest() throws InterruptedException {
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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        WebElement uploadElement = driver.findElement(By.xpath("//*[@id=\"equipment-json\"]"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("D:\\JAVA Projekty\\AutomationTests-Selenium\\testResources\\equipment.json");

        // check the "I accept the terms of service" check box
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button[2]")).click();
        Thread.sleep(500);

        alert = driver.switchTo().alert();
        String res = (alert.getText());
        alert.accept();

        js.executeScript("window.scrollBy(0,-1000)");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button[1]")).click();
        Thread.sleep(500);

        driver.close();

        return res;
    }
}
