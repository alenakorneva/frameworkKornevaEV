package task3.pages;

import task3.driver.DriverSingleton;
import task3.elements.Button;
import task3.elements.ListOfElements;
import task3.elements.TextElement;
import org.openqa.selenium.By;
import task3.service.User;
import task3.utils.CommonUtils;

public class TablesForm extends BaseForm {

    private static TextElement headerOfTablesForm = new TextElement("headerOfTablesForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private Button addButton = new Button("addButton", By.id("addNewRecordButton"));
    private ListOfElements actionButtons = new ListOfElements("actionButtons", By.xpath("//div[contains(@class, 'action-buttons')]"));
    private TextElement userName = new TextElement("firstCell", By.xpath("//div[contains(@class, 'rt-tr-group')][4]//div[contains(@class, 'rt-td')][1]"));
    private String cellWithUserData = "//div[contains(@class, 'rt-tr-group')][%d]//div[contains(@class, 'rt-td')][%d]";
    private String deleteButtonId = "delete-record-%s";

    public TablesForm() {
        super(headerOfTablesForm);
    }

    public void clickOnAddButton() {
        addButton.click();
    }

    public User getUserFromTable() {
        String firstName = DriverSingleton.getDriver().findElement(By.xpath(String.format(cellWithUserData, getIndexOfLineWithUserData(), 1))).getText();
        String lastName = DriverSingleton.getDriver().findElement(By.xpath(String.format(cellWithUserData, getIndexOfLineWithUserData(), 2))).getText();
        long age = Long.parseLong(DriverSingleton.getDriver().findElement(By.xpath(String.format(cellWithUserData, getIndexOfLineWithUserData(), 3))).getText());
        String email = DriverSingleton.getDriver().findElement(By.xpath(String.format(cellWithUserData, getIndexOfLineWithUserData(), 4))).getText();
        long salary = Long.parseLong(DriverSingleton.getDriver().findElement(By.xpath(String.format(cellWithUserData, getIndexOfLineWithUserData(), 5))).getText());
        String department = DriverSingleton.getDriver().findElement(By.xpath(String.format(cellWithUserData, getIndexOfLineWithUserData(), 6))).getText();

        return new User(firstName, lastName, email, age, salary, department);
    }

    public int getIndexOfLineWithUserData() {
        return actionButtons.getListOfElements().size();
    }

    public void clickDeleteButton() {
        CommonUtils.scrollUntilWebElementIsVisible(DriverSingleton.getDriver().findElement(By.id(String.format(deleteButtonId, getIndexOfLineWithUserData()))));
        DriverSingleton.getDriver().findElement(By.id(String.format(deleteButtonId, getIndexOfLineWithUserData()))).click();
    }
}
