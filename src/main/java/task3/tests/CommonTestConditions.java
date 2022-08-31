package task3.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import task3.browser.BrowserUtils;
import task3.driver.DriverSingleton;
import task3.service.TestDataReaderFromConfigFile;
import task3.service.TestDataReaderFromTestFile;
import task3.utils.CommonUtils;
import task3.utils.LogUtils;

public class CommonTestConditions {

    @BeforeTest
    public void setUp() {
        BrowserUtils.maximizeWindow();
        BrowserUtils.openPage(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("url"));
        CommonUtils.deleteFile(TestDataReaderFromTestFile.getStringValueFromJsonByKey("absolutePathForFile"));
        LogUtils.cleanUpLogFile(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("logFilePath"));
    }

    @AfterTest
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
