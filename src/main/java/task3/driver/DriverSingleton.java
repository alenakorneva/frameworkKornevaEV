package task3.driver;

import org.openqa.selenium.WebDriver;
import task3.service.TestDataReaderFromConfigFile;

import java.time.Duration;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            driver = DriverUtils.setDriver(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("browser"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestDataReaderFromConfigFile.getLongValueFromJsonByKey("implicitTimeout")));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
