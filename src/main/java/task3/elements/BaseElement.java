package task3.elements;

import task3.browser.BrowserUtils;
import org.openqa.selenium.By;
import task3.utils.LogUtils;


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

    public By getLocator() {
        return locator;
    }

    public void click() {
        BrowserUtils.findElementOnThePage(locator).click();
        LogUtils.setLogInfoForActionWithElement("Click ", name);
    }

    public String getText() {
        LogUtils.setLogInfoForActionWithElement("Get text of ", name);
        return BrowserUtils.findElementOnThePage(locator).getText();
    }

    public String getValueOfAttribute(String attribute){
        return BrowserUtils.findElementOnThePage(locator).getAttribute(attribute);
    }

    public boolean isDisplayed(By locator) {
        LogUtils.setLogInfoForActionWithElement("Show that displayed ", name);
        return BrowserUtils.getListOfElements(locator).size() != 0;
    }

    public boolean isEnabled() {
        LogUtils.setLogInfoForActionWithElement("Show that enabled ", name);
        return BrowserUtils.findElementOnThePage(locator).isEnabled();
    }
}
