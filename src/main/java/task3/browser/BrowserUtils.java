package task3.browser;

import task3.driver.DriverSingleton;
import task3.driver.DriverUtils;

public class BrowserUtils {

    public static void openPage(String url) {
        DriverSingleton.getDriver().get(url);
    }

    public static void maximizeWindow() {
        DriverUtils.getMaximizedWindow(DriverSingleton.getDriver());
    }
}
