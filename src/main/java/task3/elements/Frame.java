package task3.elements;

import task3.driver.DriverSingleton;
import org.openqa.selenium.By;

public class Frame extends BaseElement {

    public Frame(String name, By locator) {
        super(name, locator);
    }

    public void openFrame() {
        DriverSingleton.getDriver().switchTo().frame(find());
    }

    public void goOutOfFrames() {
        DriverSingleton.getDriver().switchTo().defaultContent();
    }
}
