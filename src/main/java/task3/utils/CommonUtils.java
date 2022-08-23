package task3.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import task3.driver.DriverSingleton;

import java.util.ArrayList;

public class CommonUtils {

    public static void executeScriptToClick(WebElement webElement){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverSingleton.getDriver();
        javascriptExecutor.executeScript("arguments[0].click()", webElement);
    }

    public static void scrollUntilWebElementIsVisible(WebElement webElement){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverSingleton.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static ArrayList<String> createTabHandles(){
        return new ArrayList<>(DriverSingleton.getDriver().getWindowHandles());
    }

    public static void switchTab(ArrayList<String> tabs, int tabIndex){
        DriverSingleton.getDriver().switchTo().window(tabs.get(tabIndex));
    }

    public static String getRandomlyGeneratedText(int lengthOfRandomText){
        return RandomStringUtils.random(lengthOfRandomText);
    }
}
