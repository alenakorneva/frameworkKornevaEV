package task3.pages;

import task3.elements.Button;
import task3.elements.Logo;
import org.openqa.selenium.By;
import task3.utils.CommonUtils;

public class ToolsQAHomeForm extends BaseForm {

    private static Logo toolsQALogo = new Logo("toolsQALogo", By.xpath("//img[contains(@src, 'Toolsqa')]"));
    private Button alertsFrameAndWindowsButton = new Button("alertsFrameAndWindowsButton", By.xpath("//div[contains(@class, card-body)]//h5[contains(text(), 'Alerts')]"));
    private Button elementsButton = new Button("elementsButton", By.xpath("//div[contains(@class, 'card mt-4 top-card')][1]"));

    public ToolsQAHomeForm() {
        super(toolsQALogo);
    }

    public void clickOnAlertFrameAndWindowsButton() {
        CommonUtils.scrollUntilWebElementIsVisible(alertsFrameAndWindowsButton.find());
        alertsFrameAndWindowsButton.click();
    }

    public void clickOnElementsButton() {
        CommonUtils.scrollUntilWebElementIsVisible(elementsButton.find());
        elementsButton.click();
    }
}
