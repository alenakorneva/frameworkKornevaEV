package task3.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogUtils {

    private static Logger logger;
    private static FileHandler fileHandler;

    static {
        LogManager.getLogManager().reset();
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        try {
            fileHandler = new FileHandler("logFile.log");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Logging isn't written into file.");
        }
    }

    public static void setLogInfoForActionWithElement(String action, String nameOfElement) {
        logger.info(action + nameOfElement);
    }

    public static void setLogInfoForStep(int step, String stepDescription) {
        logger.info("Step " + step + ": " + stepDescription);
    }
}
