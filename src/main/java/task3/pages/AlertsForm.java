package task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import task3.browser.BaseAlert;
import task3.browser.BrowserUtils;
import task3.elements.Button;
import task3.elements.TextElement;
import task3.service.TestDataReaderFromTestFile;
import task3.utils.JavaScriptUtils;
import task3.utils.StringUtils;

public class AlertsForm extends BaseForm {

    private static TextElement headerOfAlertsForm = new TextElement("headerOfAlertsForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private Button clickAlertButton = new Button("alertButton", By.id("alertButton"));
    private BaseAlert clickBaseAlert = new BaseAlert("clickAlert");
    private Button confirmAlertButton = new Button("buttonForConfirmBoxToAppear", By.id("confirmButton"));
    private BaseAlert confirmBaseAlert = new BaseAlert("confirmAlert");
    private TextElement textNextToOKButtonOfConfirmAlert = new TextElement("TextNextToOKButtonOfConfirmActionAlert", By.id("confirmResult"));
    private Button promptAlertButton = new Button("promptAlertButton", By.id("promtButton"));
    private BaseAlert promptBaseAlert = new BaseAlert("promptAlert");
    private TextElement textNextToOKButtonOfPromptAlert = new TextElement("textNextToOKButtonOfPromptAlert", By.id("promptResult"));// You entered "input text"
    public static String randomlyGeneratedText;

    public AlertsForm() {
        super(headerOfAlertsForm);
    }

    public void clickOnButtonToSeeClickAlert() {
        clickAlertButton.click();
    }

    public String getTextOfClickAlert() {
        clickBaseAlert.switchToAlert();
        return clickBaseAlert.getTextOfAlert();
    }

    public void clickOKButtonOfClickAlert() {
        clickBaseAlert.acceptAlert();
    }

    public boolean clickAlertIsClosed() {
        return alertIsClosed(clickBaseAlert);
    }

    public void clickOnButtonOfConfirmAlert() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(confirmAlertButton.getLocator()));
        confirmAlertButton.click();
    }

    public String getConfirmAlertText() {
        return confirmBaseAlert.getTextOfAlert();
    }

    public void clickOnOKButtonOfConfirmAlert() {
        confirmBaseAlert.acceptAlert();
    }

    public boolean confirmAlertIsClosed() {
        return alertIsClosed(confirmBaseAlert);
    }

    public String getTextNextToOKButtonOfConfirmAlert() {
        return textNextToOKButtonOfConfirmAlert.getText();
    }

    public void clickOnPromptAlertButton() {
        promptAlertButton.click();
    }

    public boolean promptAlertsOpened() {
        return alertIsOpened(promptBaseAlert);
    }

    public String getTextOfPromptAlert() {
        return promptBaseAlert.getTextOfAlert();
    }

    public void enterRandomTextInPromptAlertInputArea() {
        int lengthOfRandomText = (int) TestDataReaderFromTestFile.getLongValueFromJsonByKey("lengthOfRandomLine");
        randomlyGeneratedText = StringUtils.getRandomlyGeneratedText(lengthOfRandomText);
        promptBaseAlert.insertTextIntoAlert(randomlyGeneratedText);
    }

    public void clickOnOKButtonOfPromptAlert() {
        promptBaseAlert.acceptAlert();
    }

    public boolean promptAlertIsClosed() {
        return alertIsClosed(promptBaseAlert);
    }

    public String getTextNextToOKButtonOfPromptAlert() {
        String wholePhrase = textNextToOKButtonOfPromptAlert.getText();
        int indexOfLastCharInFixedPhrase = TestDataReaderFromTestFile.getStringValueFromJsonByKey("lineWithRandomTextBeginsWith").length();
        return wholePhrase.substring(indexOfLastCharInFixedPhrase);
    }

    private boolean alertIsClosed(BaseAlert baseAlert) {
        try {
            baseAlert.switchToAlert();
            return false;
        } catch (NoAlertPresentException Ex) {
            return true;
        }
    }

    private boolean alertIsOpened(BaseAlert alert) {
        try {
            alert.switchToAlert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }
}
