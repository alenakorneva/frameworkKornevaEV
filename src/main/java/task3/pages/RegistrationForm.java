package task3.pages;

import org.openqa.selenium.NoSuchElementException;
import task3.elements.Button;
import task3.elements.InputField;
import task3.elements.ListOfElements;
import task3.elements.TextElement;
import org.openqa.selenium.By;
import task3.service.User;
import task3.utils.CommonUtils;
import task3.utils.WaitUtils;

public class RegistrationForm extends BaseForm {

    private static TextElement headerOfRegistrationForm = new TextElement("headerOfRegistrationForm", By.id("registration-form-modal"));
    private InputField firstName = new InputField("firstName", By.id("firstName"));
    private InputField lastName = new InputField("lastName", By.id("lastName"));
    private InputField email = new InputField("email", By.id("userEmail"));
    private InputField age = new InputField("age", By.id("age"));
    private InputField salary = new InputField("salary", By.id("salary"));
    private InputField department = new InputField("department", By.id("department"));

    private Button submitButton = new Button("submitButton", By.id("submit"));
    private ListOfElements listOfElementsWithUsers = new ListOfElements("tableWithUsers", By.xpath(""));

    public RegistrationForm() {
        super(headerOfRegistrationForm);
    }

    public void insertUserCredentials(User user) {
        firstName.fulfillInputArea(user.getFirstName());
        lastName.fulfillInputArea(user.getLastName());
        email.fulfillInputArea(user.getEmail());
        age.fulfillInputArea(Long.toString(user.getAge()));
        salary.fulfillInputArea(Long.toString(user.getSalary()));
        department.fulfillInputArea(user.getDepartment());
    }

    public void clickOnSubmitButton() {
        //use JS executor as submit button is invisible because of google advertisement in the footer
        CommonUtils.executeScriptToClick(submitButton.find());
    }

    public boolean isClosed() {
        try {
            WaitUtils.waitUntilWebElementIsInvisible(headerOfRegistrationForm.find());
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
