package task3.driver;

import task3.exceptions.JsonParsingException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import task3.service.TestDataReaderFromConfigFile;

import java.util.HashMap;
import java.util.Map;

public class DriverUtils {

    public static WebDriver setDriver(String browserName) {
        switch (browserName) {
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("wayOfLaunchingFirefox"));
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            }
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("languageOfBrowser"));
                chromeOptions.addArguments(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("wayOfLaunchingChrome"));
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", TestDataReaderFromConfigFile.getStringValueFromJsonByKey("directoryForDownloads"));
                chromeOptions.setExperimentalOption("prefs", prefs);
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            }
            default: {
                throw new JsonParsingException("Browser in JSON isn't set correctly.");
            }
        }
    }
}