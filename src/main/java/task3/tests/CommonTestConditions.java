package task3.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import task3.browser.BrowserUtils;
import task3.driver.DriverSingleton;
import task3.service.TestDataReaderFromConfigFile;

public class CommonTestConditions {

    @BeforeTest
    public void setUp() {
        BrowserUtils.maximizeWindow();
        BrowserUtils.openPage(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("url"));
    }

    @AfterTest
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
