package task3.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import task3.driver.DriverSingleton;

public class JavaScriptUtils {

    public static void executeScriptToClick(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverSingleton.getDriver();
        javascriptExecutor.executeScript("arguments[0].click()", webElement);
    }

    public static void scrollUntilWebElementIsVisible(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverSingleton.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
