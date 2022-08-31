package task3.utils;

import org.openqa.selenium.By;

public class LocatorUtils {

    public static By getDynamicLocatorByXpath(String baseLocator, String testDataToInsert) {
        return By.xpath(String.format(baseLocator, testDataToInsert));
    }

    public static By getDynamicLocatorByXpath(String baseLocator, String... testDataToInsert) {
        return By.xpath(String.format(baseLocator, testDataToInsert));
    }

    public static By getDynamicLocatorByXpath(String baseLocator, int... testDataToInsert) {
        return By.xpath(String.format(baseLocator, testDataToInsert));
    }

    public static By getDynamicLocatorById(String baseLocator, int... testDataToInsert) {
        return By.id(String.format(baseLocator, testDataToInsert));
    }
}
