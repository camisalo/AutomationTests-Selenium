import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\konrad.gebczynski\\IdeaProjects\\AutomationTests\\driver\\chromedriver.exe");
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
        Actions action = new Actions(driver);

    }
}
