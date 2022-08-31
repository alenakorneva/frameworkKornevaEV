package task3.utils;

import org.apache.commons.lang3.RandomStringUtils;
import task3.driver.DriverSingleton;

import java.util.ArrayList;

public class StringUtils {

    public static ArrayList<String> createTabHandles() {
        return new ArrayList<>(DriverSingleton.getDriver().getWindowHandles());
    }

    public static String getRandomlyGeneratedText(int lengthOfRandomText) {
        return RandomStringUtils.random(lengthOfRandomText);
    }
}
