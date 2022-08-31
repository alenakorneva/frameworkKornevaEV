package task3.pages;

import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.elements.OptionInList;
import task3.elements.TextElement;
import task3.utils.JavaScriptUtils;
import task3.utils.LocatorUtils;

public class AlertFrameAndWindowsForm extends BaseForm {

    private static TextElement headerOfAlertFrameAndWindowsPage = new TextElement("headerOfAlertFrameAndWindowsPage", By.xpath("//div[contains(@class, 'main-header')]"));
    private String alertFrameAndWindowsOptionsList = "//span[contains(text(), 'Browser Windows')]/parent::li";
    private OptionInList nestedFramesOption = new OptionInList("nestedFramesOption", By.xpath("//div[contains(@class, 'show')]//li[@id='item-3']"));

    public AlertFrameAndWindowsForm() {
        super(headerOfAlertFrameAndWindowsPage);
    }

    public void openAlertForm(String nameOfAlertForm) {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(LocatorUtils.getDynamicLocatorByXpath(alertFrameAndWindowsOptionsList, nameOfAlertForm)));
        BrowserUtils.findElementOnThePage(LocatorUtils.getDynamicLocatorByXpath(alertFrameAndWindowsOptionsList, nameOfAlertForm)).click();
    }

    public void openNestedFrameForm() {
        nestedFramesOption.click();
    }

    public void openBrowserWindowForm(String nameOfBrowserWindowForm) {
        BrowserUtils.findElementOnThePage(LocatorUtils.getDynamicLocatorByXpath(alertFrameAndWindowsOptionsList, nameOfBrowserWindowForm)).click();

    }


}
