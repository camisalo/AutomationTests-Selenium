import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CheckSearchEngine {

    public static WebDriver driver = null;

    String user = "TestAutomationUser";
    String password = "password";
    String email = "AutomationTest@gmail.com";

    public CheckSearchEngine() {
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

    public String startTest1() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/input"));
        search.sendKeys("Kraków, krowoderska 17");

        WebElement category = driver.findElement(By.xpath("//*[@id=\"dropdown-basic-button\"]"));
        Actions action = new Actions(driver);
        action.click(category).perform();

        WebElement category_drop = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/a[3]"));
        action.click(category_drop).perform();

        WebElement search_button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button"));
        action.click(search_button).perform();
        Thread.sleep(1000);

        String res = "";
        if (isElementPresent(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div[2]/span"))) {
            WebElement first_result = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div[2]/span"));
            Thread.sleep(1500);
            res = first_result.getText();
        }

        driver.close();

        return res;
    }

    public String startTest2() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/input"));
        search.sendKeys("Kraków, zwierzyniecka 34");

        WebElement category = driver.findElement(By.xpath("//*[@id=\"dropdown-basic-button\"]"));
        Actions action = new Actions(driver);
        action.click(category).perform();

        WebElement category_drop = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/a[8]"));
        action.click(category_drop).perform();

        WebElement search_button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button"));
        action.click(search_button).perform();
        Thread.sleep(1000);

        String res = "";

        if (isElementPresent(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[2]/div[2]/span"))) {
            WebElement first_result = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[2]/div[2]/span"));
            Thread.sleep(1500);
            res = first_result.getText();
        }

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
