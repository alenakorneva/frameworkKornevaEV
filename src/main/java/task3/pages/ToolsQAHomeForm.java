package task3.pages;

import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.elements.Button;
import task3.elements.TextElement;
import task3.utils.JavaScriptUtils;

public class ToolsQAHomeForm extends BaseForm {

    private static TextElement toolsQALogo = new TextElement("toolsQALogo", By.xpath("//img[contains(@src, 'Toolsqa')]"));
    private Button alertsFrameAndWindowsButton = new Button("alertsFrameAndWindowsButton", By.xpath("//div[contains(@class, card-body)]//h5[contains(text(), 'Alerts')]"));
    private Button elementsButton = new Button("elementsButton", By.xpath("//div[contains(@class, 'card mt-4 top-card')][1]"));
    private Button widgetsButton = new Button("widgetsButton", By.xpath("//div[contains(@class, 'card mt-4 top-card')][4]"));

    public ToolsQAHomeForm() {
        super(toolsQALogo);
    }

    public void clickOnAlertFrameAndWindowsButton() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(alertsFrameAndWindowsButton.getLocator()));
        alertsFrameAndWindowsButton.click();
    }

    public void clickOnElementsButton() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(elementsButton.getLocator()));
        elementsButton.click();
    }

    public void clickWidgetsButton(){
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(widgetsButton.getLocator()));
        widgetsButton.click();
    }
}
