package task3.browser;

import org.openqa.selenium.Alert;
import task3.driver.DriverSingleton;

public class BaseAlert {

    private String name;

    public BaseAlert(String name) {
        this.name = name;
    }

    public Alert switchToAlert(){
        return DriverSingleton.getDriver().switchTo().alert();
    }

    public void acceptAlert(){
        switchToAlert().accept();
        DriverSingleton.getDriver().switchTo().defaultContent();
    }

    public String getTextOfAlert(){
        return switchToAlert().getText();
    }

    public void insertTextIntoAlert(String textToInsert){
        switchToAlert().sendKeys(textToInsert);
    }
}
