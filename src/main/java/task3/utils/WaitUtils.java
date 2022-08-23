package task3.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task3.service.TestDataReaderFromConfigFile;
import task3.service.TestDataReaderFromTestFile;
import task3.driver.DriverSingleton;

import java.time.Duration;

public class WaitUtils {

    public static final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(TestDataReaderFromConfigFile.getLongValueFromJsonByKey("explicitTimeout"));

    public static void waitUntilWebElementIsClickable(By webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), WaitUtils.WAIT_TIMEOUT_SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e) {
            throw new RuntimeException("Element " + webElement +
                    "is not clickable within the time of " +
                    WaitUtils.WAIT_TIMEOUT_SECONDS + " seconds");
        }
    }

    public static void waitUntilWebElementIsInvisible(WebElement webElement){
        try {
            WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), WaitUtils.WAIT_TIMEOUT_SECONDS);
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e){
            throw new RuntimeException("Element " + webElement +
                    "is visible within the time of " +
                    WaitUtils.WAIT_TIMEOUT_SECONDS + " seconds");
        }
    }
}
