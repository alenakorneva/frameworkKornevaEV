package task3.utils;

import task3.driver.DriverSingleton;
import task3.service.TestDataReaderFromConfigFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CommonUtils {

    public static void switchTab(ArrayList<String> tabs, int tabIndex) {
        DriverSingleton.getDriver().switchTo().window(tabs.get(tabIndex));
    }

    public static void deleteFile(String path) {
        File directoryForDownloads = new File(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("directoryForDownloads"));
        if (directoryForDownloads.list().length > 0) {
            try {
                Files.delete(Path.of(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
