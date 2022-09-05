package in.amazon.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.MalformedURLException;



public class Browser {
    public static WebDriver driver;

    public void selectBrowser(WebBrowsers browser) throws MalformedURLException {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get("https://www.amazon.in");
                driver.manage().window().maximize();
    }
}
