package task3.utils;

import com.jayway.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task3.browser.BrowserUtils;
import task3.driver.DriverSingleton;
import task3.elements.BaseElement;
import task3.pages.UploadAndDownloadForm;
import task3.service.TestDataReaderFromConfigFile;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

    public static void waitUntilWebElementIsInvisible(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), WaitUtils.WAIT_TIMEOUT_SECONDS);
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e) {
            throw new RuntimeException("Element " + webElement +
                    "is visible within the time of " +
                    WaitUtils.WAIT_TIMEOUT_SECONDS + " seconds");
        }
    }

    public static void waitUntilFileIsDownloaded(String path, long timeout) {
        Awaitility.await().atMost(timeout, TimeUnit.SECONDS).until(() -> UploadAndDownloadForm.fileIsDownload(path));
    }

    public static void waitForProgressBarValue(BaseElement progressBar, String ageOfTester) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), WaitUtils.WAIT_TIMEOUT_SECONDS);
            wait.until(ExpectedConditions.attributeContains(BrowserUtils.findElementOnThePage(progressBar.getLocator()), "aria-valuenow", ageOfTester));
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e) {
            throw new RuntimeException("Element " + progressBar +
                    "didn't stop after achieving  value of tester's age" +
                    ageOfTester + " year");
        }
    }
}
