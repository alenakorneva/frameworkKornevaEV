package task3.pages;

import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.driver.DriverSingleton;
import task3.elements.Button;
import task3.elements.TextElement;
import task3.service.User;
import task3.utils.JavaScriptUtils;
import task3.utils.LocatorUtils;

public class TablesForm extends BaseForm {

    private static TextElement headerOfTablesForm = new TextElement("headerOfTablesForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private Button addButton = new Button("addButton", By.id("addNewRecordButton"));
    private Button actionButtons = new Button("actionButtons", By.xpath("//div[contains(@class, 'action-buttons')]"));
    private String cellWithUserData = "//div[contains(@class, 'rt-tr-group')][%d]//div[contains(@class, 'rt-td')][%d]";
    private String deleteButtonId = "delete-record-%s";

    public TablesForm() {
        super(headerOfTablesForm);
    }

    public void clickOnAddButton() {
        addButton.click();
    }

    public User getUserFromTable() {
        String firstName = DriverSingleton.getDriver().findElement(LocatorUtils.getDynamicLocatorByXpath(cellWithUserData, getIndexOfLineWithUserData(), 1)).getText();
        String lastName = DriverSingleton.getDriver().findElement(LocatorUtils.getDynamicLocatorByXpath(cellWithUserData, getIndexOfLineWithUserData(), 2)).getText();
        long age = Long.parseLong(DriverSingleton.getDriver().findElement(LocatorUtils.getDynamicLocatorByXpath(cellWithUserData, getIndexOfLineWithUserData(), 3)).getText());
        String email = DriverSingleton.getDriver().findElement(LocatorUtils.getDynamicLocatorByXpath(cellWithUserData, getIndexOfLineWithUserData(), 4)).getText();
        long salary = Long.parseLong(DriverSingleton.getDriver().findElement(LocatorUtils.getDynamicLocatorByXpath(cellWithUserData, getIndexOfLineWithUserData(), 5)).getText());
        String department = DriverSingleton.getDriver().findElement(LocatorUtils.getDynamicLocatorByXpath(cellWithUserData, getIndexOfLineWithUserData(), 6)).getText();

        return new User(firstName, lastName, email, age, salary, department);
    }

    public int getIndexOfLineWithUserData() {
        return BrowserUtils.getListOfElements(actionButtons.getLocator()).size();
    }

    public void clickDeleteButton() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(DriverSingleton.getDriver().findElement(LocatorUtils.getDynamicLocatorById(deleteButtonId, getIndexOfLineWithUserData())));
        DriverSingleton.getDriver().findElement(LocatorUtils.getDynamicLocatorById(deleteButtonId, getIndexOfLineWithUserData())).click();
    }
}
