package task3.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class TestDataReaderFromTestFile {

    private JSONObject jsonObjectFromTestFile;
    static TestDataReaderFromTestFile testDataReaderFromTestFile;

    static {
        testDataReaderFromTestFile = new TestDataReaderFromTestFile();
    }

    public TestDataReaderFromTestFile() {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader fileReaderFromTestFile = new FileReader("src/main/resources/testDataForToolsQA.json");
            Object objectFromTestFile = jsonParser.parse(fileReaderFromTestFile);
            jsonObjectFromTestFile = (JSONObject) objectFromTestFile;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String getStringValueFromJsonByKey(String key) {
        return (String) testDataReaderFromTestFile.jsonObjectFromTestFile.get(key);
    }

    public static int getIntegerValueFromJsonByKey(String key) {
        return (int) testDataReaderFromTestFile.jsonObjectFromTestFile.get(key);
    }

    public static long getLongValueFromJsonByKey(String key) {
        return (long) testDataReaderFromTestFile.jsonObjectFromTestFile.get(key);
    }
}
