package task3.pages;

import task3.elements.OptionInList;
import task3.elements.TextElement;
import org.openqa.selenium.By;
import task3.utils.CommonUtils;

public class AlertFrameAndWindowsForm extends BaseForm {

    private static TextElement headerOfAlertFrameAndWindowsPage = new TextElement("headerOfAlertFrameAndWindowsPage", By.xpath("//div[contains(@class, 'main-header')]"));
    private OptionInList alertOption = new OptionInList("alertOption", By.xpath("//div[contains(@class, 'accordion')]/div[3]//li[@id='item-1']"));
    private OptionInList nestedFramesOption = new OptionInList("nestedFramesOption", By.xpath("//div[contains(@class, 'show')]//li[@id='item-3']"));
    private OptionInList browserWindowsOption = new OptionInList("browserWindowsOption", By.xpath("//div[contains(@class, 'accordion')]/div[3]//li[@id='item-0']"));

    public AlertFrameAndWindowsForm() {
        super(headerOfAlertFrameAndWindowsPage);
    }


    public void openAlertForm() {
        CommonUtils.scrollUntilWebElementIsVisible(alertOption.find());
        alertOption.click();
    }

    public void openNestedFrameForm() {
        nestedFramesOption.click();
    }

    public void openBrowserWindowForm() {
        browserWindowsOption.click();
    }
}
