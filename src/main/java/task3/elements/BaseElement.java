package task3.elements;

import task3.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import task3.utils.LogUtils;

import java.util.List;

public abstract class BaseElement {
    protected String name;
    protected By locator;

    public BaseElement(String name, By locator) {
        this.name = name;
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public WebElement find() {
        return DriverSingleton.getDriver().findElement(locator);
    }

    public void click() {
        find().click();
        LogUtils.setLogInfoForActionWithElement("Click ", name);
    }

    public String getText() {
        LogUtils.setLogInfoForActionWithElement("Get text of ", name);
        return find().getText();
    }

    public boolean isDisplayed() {
        LogUtils.setLogInfoForActionWithElement("Show that displayed ", name);
        return find().isDisplayed();
    }

    public boolean isEnabled() {
        LogUtils.setLogInfoForActionWithElement("Show that enabled ", name);
        return find().isEnabled();
    }

    public List<WebElement> getListOfElements() {
        return DriverSingleton.getDriver().findElements(locator);
    }
}
