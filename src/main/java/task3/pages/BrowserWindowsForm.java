package task3.pages;

import task3.elements.Button;
import task3.elements.TextElement;
import org.openqa.selenium.By;

public class BrowserWindowsForm extends BaseForm {

    private static TextElement headerOfBrowserWindowsForm = new TextElement("headerOfBrowserWindowsForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private Button newTabButton = new Button("newTabButton", By.id("tabButton"));

    public BrowserWindowsForm() {
        super(headerOfBrowserWindowsForm);
    }

    public void clickOnNewTabButton() {
        newTabButton.click();
    }
}
