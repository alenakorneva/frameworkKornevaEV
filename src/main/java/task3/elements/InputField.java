package task3.elements;

import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.utils.LogUtils;

public class InputField extends BaseElement {

    public InputField(String name, By locator) {
        super(name, locator);
    }

    public void fulfillInputArea(String textToFulfill) {
        LogUtils.setLogInfoForActionWithElement("Insert text " + textToFulfill + " in ", name);
        BrowserUtils.findElementOnThePage(locator).sendKeys(textToFulfill);
    }
}
