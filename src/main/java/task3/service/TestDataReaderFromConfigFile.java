package task3.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class TestDataReaderFromConfigFile {

    private JSONObject jsonObjectFromConfigFile;
    static TestDataReaderFromConfigFile testDataReaderFromConfigFile;

    static {
        testDataReaderFromConfigFile = new TestDataReaderFromConfigFile();
    }

    public TestDataReaderFromConfigFile() {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader fileReaderFromConfigFile = new FileReader("src/main/resources/configToolsQA.json");
            Object objectFromConfigFile = jsonParser.parse(fileReaderFromConfigFile);
            jsonObjectFromConfigFile = (JSONObject) objectFromConfigFile;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }


    public static String getStringValueFromJsonByKey(String key) {
        return (String) testDataReaderFromConfigFile.jsonObjectFromConfigFile.get(key);
    }

    public static int getIntegerValueFromJsonByKey(String key) {
        return (int) testDataReaderFromConfigFile.jsonObjectFromConfigFile.get(key);
    }

    public static long getLongValueFromJsonByKey(String key) {
        return (long) testDataReaderFromConfigFile.jsonObjectFromConfigFile.get(key);
    }
}
