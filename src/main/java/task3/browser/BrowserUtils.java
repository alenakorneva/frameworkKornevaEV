package task3.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import task3.driver.DriverSingleton;

import java.util.List;

public class BrowserUtils {

    public static void openPage(String url) {
        DriverSingleton.getDriver().get(url);
    }

    public static void maximizeWindow() {
        DriverSingleton.getDriver().manage().window().maximize();
    }

    public static void openFrame(WebElement webElement) {
        DriverSingleton.getDriver().switchTo().frame(webElement);
    }

    public static void goOutOfFrames() {
        DriverSingleton.getDriver().switchTo().defaultContent();
    }

    public static WebElement findElementOnThePage(By locator) {
        return DriverSingleton.getDriver().findElement(locator);
    }

    public static List<WebElement> getListOfElements(By locator) {
        return DriverSingleton.getDriver().findElements(locator);
    }

}
