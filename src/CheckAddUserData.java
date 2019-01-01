import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CheckAddUserData {

    public static WebDriver driver = null;

    String user = "TestAutomationUser";
    String password = "password";
    String email = "AutomationTest@gmail.com";

    public CheckAddUserData() {
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

        WebElement u_nip = driver.findElement(By.xpath("//*[@id=\"nip\"]"));
        WebElement u_nazwa = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement u_adres = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        WebElement u_miasto = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        WebElement u_kodpocztowy = driver.findElement(By.xpath("//*[@id=\"zip-code\"]"));
        WebElement u_wojewodztwo = driver.findElement(By.xpath("//*[@id=\"voivodeship\"]"));
        WebElement u_telefon = driver.findElement(By.xpath("//*[@id=\"phone\"]"));

        u_nip.clear();
        u_nazwa.clear();
        u_adres.clear();
        u_miasto.clear();
        u_kodpocztowy.clear();
        u_wojewodztwo.clear();
        u_telefon.clear();

        u_nip.sendKeys("123-456-32-18");
        u_nazwa.sendKeys("Ramirent");
        u_adres.sendKeys("nad serafą 41");
        u_miasto.sendKeys("Kraków");
        u_kodpocztowy.sendKeys("32020");
        u_wojewodztwo.sendKeys("Małopolskie");
        u_telefon.sendKeys("+48827345982");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(500);


        WebElement save = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button[2]"));
        action.click(save).perform();
        Thread.sleep(500);

        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(500);

        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(500);

        WebElement logout = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button[1]"));
        action.click(logout).perform();
        Thread.sleep(500);

        // Login again
        l_user = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        l_password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        l_user.sendKeys(user);
        l_password.sendKeys(password);

        l_button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button"));
        action.click(l_button).perform();
        Thread.sleep(500);

        u_nip = driver.findElement(By.xpath("//*[@id=\"nip\"]"));
        Thread.sleep(1000);
        String res = u_nip.getAttribute("value");

        System.out.println("aaaaa" + res);
        driver.close();

        return res;
    }


}
