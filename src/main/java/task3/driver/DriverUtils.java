package task3.driver;

import task3.exceptions.JsonParsingException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverUtils {
    public static void getMaximizedWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static WebDriver setDriver(String browserName) {
        switch (browserName) {
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("incognito");
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            }
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("−−lang=ru");
                chromeOptions.addArguments("--incognito");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            }
            default: {
                throw new JsonParsingException("Browser in JSON isn't set correctly.");
            }
        }
    }
}