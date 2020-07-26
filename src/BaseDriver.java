import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {
    public static WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", "/Users/bulut/Selenium/chromedriver");
        driver = new ChromeDriver();
    }
}
