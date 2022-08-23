package task3.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task3.pages.AlertFrameAndWindowsForm;
import task3.pages.AlertsForm;
import task3.pages.BrowserWindowsForm;
import task3.pages.ElementForm;
import task3.pages.FrameForm;
import task3.pages.LinksForm;
import task3.pages.NestedFrameForm;
import task3.pages.RegistrationForm;
import task3.pages.SamplePage;
import task3.pages.TablesForm;
import task3.pages.ToolsQAHomeForm;
import org.testng.Assert;
import task3.service.DataProvider;
import task3.service.TestDataReaderFromTestFile;
import task3.service.User;
import task3.utils.CommonUtils;
import task3.utils.LogUtils;

import java.util.ArrayList;

public class ToolsQATest extends CommonTestConditions {

    ToolsQAHomeForm toolsQAHomePage = new ToolsQAHomeForm();
    AlertFrameAndWindowsForm alertFrameAndWindowsPage = new AlertFrameAndWindowsForm();

    AlertsForm alertsForm = new AlertsForm();

    NestedFrameForm nestedFrameForm = new NestedFrameForm();
    FrameForm frameForm = new FrameForm();

    ElementForm elementPage = new ElementForm();
    TablesForm tablesForm = new TablesForm();
    RegistrationForm registrationForm = new RegistrationForm();

    BrowserWindowsForm browserWindowsForm = new BrowserWindowsForm();
    SamplePage samplePage = new SamplePage();
    LinksForm linksForm = new LinksForm();

    @Test
    public void alertsTest() {
        LogUtils.setLogInfoForStep(1, "Go to main page");
        Assert.assertTrue(toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click 'Alerts, Frame & Windows' button. On the opened page click 'Alerts' in the left menu.");
        toolsQAHomePage.clickOnAlertFrameAndWindowsButton();
        alertFrameAndWindowsPage.openAlertForm();
        Assert.assertTrue(alertsForm.isOpened(), "Alert form isn't opened.");

        LogUtils.setLogInfoForStep(3, "Click button 'Click Button to see alert'");
        alertsForm.clickOnButtonToSeeClickAlert();
        Assert.assertEquals(alertsForm.getTextOfClickAlert(), "You clicked a button", "Text of alert isn't correct.");

        LogUtils.setLogInfoForStep(4, "Click 'OK' button");
        alertsForm.clickOKButtonOfClickAlert();
        Assert.assertTrue(alertsForm.clickAlertIsClosed(), "Alert isn't closed.");

        LogUtils.setLogInfoForStep(5, "Click 'On button click, confirm box will appear' button");
        alertsForm.clickOnButtonOfConfirmAlert();
        SoftAssert softAssertForOpeningConfirmAlert = new SoftAssert();
        softAssertForOpeningConfirmAlert.assertTrue(alertsForm.confirmAlertIsOpened(), "Confirm alert isn't opened.");
        softAssertForOpeningConfirmAlert.assertTrue(alertsForm.getConfirmAlertText().equals("Do you confirm action?"),
                String.format("Confirm alert isn't opened with the text %s", "Do you confirm action?"));
        softAssertForOpeningConfirmAlert.assertAll(String.format("Confirm alert isn't opened with the text %s", "Do you confirm action?"));

        LogUtils.setLogInfoForStep(6, "Click 'OK' button");
        alertsForm.clickOnOKButtonOfConfirmAlert();
        SoftAssert softAssertForClosingConfirmAlert = new SoftAssert();
        softAssertForClosingConfirmAlert.assertTrue(alertsForm.confirmAlertIsClosed(), "Confirm alert isn't closed.");
        softAssertForClosingConfirmAlert.assertTrue(alertsForm.getTextNextToOKButtonOfConfirmAlert().equals("You selected Ok"),
                String.format("Text in confirm alert isn't similar to %s", "You selected Ok"));
        softAssertForClosingConfirmAlert.assertAll(String.format("Confirm alert isn't closed with the text %s", "You selected Ok"));

        LogUtils.setLogInfoForStep(7, "Click 'On button click, prompt box will appear' button");
        alertsForm.clickOnPromptAlertButton();
        SoftAssert softAssertForOpeningPromptAlert = new SoftAssert();
        softAssertForOpeningPromptAlert.assertTrue(alertsForm.promptAlertsOpened(), "Prompt alert isn't opened.");
        softAssertForOpeningPromptAlert.assertTrue(alertsForm.getTextOfPromptAlert().equals("Please enter your name"),
                String.format("Text in prompt alert isn't similar to %s", "Please enter your name"));
        softAssertForOpeningPromptAlert.assertAll(String.format("Prompt alert isn't opened with the text %s", "Please enter your name"));

        LogUtils.setLogInfoForStep(8, "Insert randomly generated text, click 'OK' button");
        alertsForm.enterRandomTextInPromptAlertInputArea();
        alertsForm.clickOnOKButtonOfPromptAlert();
        SoftAssert softAssertForClosingPromptAlert = new SoftAssert();
        softAssertForClosingPromptAlert.assertTrue(alertsForm.promptAlertIsClosed(), "Prompt alert isn't closed.");
        softAssertForClosingPromptAlert.assertTrue(alertsForm.getTextNextToOKButtonOfPromptAlert().equals(AlertsForm.randomlyGeneratedText),
                String.format("Randomly generated text isn't similar to %s", AlertsForm.randomlyGeneratedText));
        softAssertForClosingPromptAlert.assertAll(String.format("Prompt alert isn't closed with the text %s", AlertsForm.randomlyGeneratedText));
    }

    @Test
    public void iframeTest() {
        LogUtils.setLogInfoForStep(1, "Move to Home page");
        Assert.assertTrue(toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click ' Alerts, Frame & Windows' button. On the opened page click 'Nested Frames' in the left menu.");
        toolsQAHomePage.clickOnAlertFrameAndWindowsButton();
        alertFrameAndWindowsPage.openNestedFrameForm();
        SoftAssert softAssertForNestedFrameForm = new SoftAssert();
        softAssertForNestedFrameForm.assertTrue(nestedFrameForm.isOpened(), "NestedForm isn't opened.");
        softAssertForNestedFrameForm.assertTrue(nestedFrameForm.getTextOfParentFrameTextElement().
                        equals(TestDataReaderFromTestFile.getStringValueFromJsonByKey("textInParentFrame")),
                String.format("Parent frame doesn't contain text %s", TestDataReaderFromTestFile.getStringValueFromJsonByKey("textInParentFrame")));
        softAssertForNestedFrameForm.assertTrue(nestedFrameForm.getTextOfChildFrameTextElement().
                        equals(TestDataReaderFromTestFile.getStringValueFromJsonByKey("textInChildFrame")),
                String.format("Child frame doesn't contain text %s", TestDataReaderFromTestFile.getStringValueFromJsonByKey("textInChildFrame")));
        softAssertForNestedFrameForm.assertAll(String.format("Nested frames form isn't opened with %s and %s text.", "Parent frame", "Child Iframe"));
        nestedFrameForm.leaveFrames();

        LogUtils.setLogInfoForStep(3, "Choose 'Frames' option in the left menu.");
        frameForm.clickOnFramesOption();
        SoftAssert softAssertForFrameForm = new SoftAssert();
        softAssertForFrameForm.assertTrue(frameForm.isOpened(), "Frame form isn't opened.");
        softAssertForFrameForm.assertEquals(frameForm.getUpperText(), frameForm.getDownText(),
                "Text in upper form isn't similar to the text in down form");
        softAssertForFrameForm.assertAll("IFrames form isn't opened with similar text in upper and down frames.");
        frameForm.leaveFrames();
    }

    @Test(dataProvider = "getUsersData", dataProviderClass = DataProvider.class)
    public void tablesTest(User user) {
        LogUtils.setLogInfoForStep(1, "Move to Home page.");
        Assert.assertTrue(toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click 'Elements' button. On the opened page click 'Web Tables' option.");
        toolsQAHomePage.clickOnElementsButton();
        elementPage.clickOnWebTablesFormOption();
        Assert.assertTrue(tablesForm.isOpened());

        LogUtils.setLogInfoForStep(3, "Click 'Add' button.");
        tablesForm.clickOnAddButton();
        Assert.assertTrue(registrationForm.isOpened(), "RegistrationForm isn't opened.");

        LogUtils.setLogInfoForStep(4, "Insert 'User #' credentials from the table, than click 'Submit' button.");
        registrationForm.insertUserCredentials(user);
        registrationForm.clickOnSubmitButton();
        SoftAssert softAssertForUserInsertion = new SoftAssert();
        softAssertForUserInsertion.assertTrue(registrationForm.isClosed(), "Registration form isn't closed.");
        softAssertForUserInsertion.assertEquals(tablesForm.getUserFromTable(), user);
        softAssertForUserInsertion.assertAll("Registration form isn't closed and there are no user credentials in the table.");
        int amountOfLinesAfterAddingNewUser = tablesForm.getIndexOfLineWithUserData();

        LogUtils.setLogInfoForStep(5, "Click 'Delete' button in the line with 'User #'.");
        tablesForm.clickDeleteButton();
        int amountOfLinesAfterDeletingUser = tablesForm.getIndexOfLineWithUserData();
        SoftAssert softAssertForRemovingUser = new SoftAssert();
        softAssertForRemovingUser.assertTrue((amountOfLinesAfterAddingNewUser - amountOfLinesAfterDeletingUser) > 0, "Amount of lines in the table hasn't changed.");
        softAssertForRemovingUser.assertNotEquals(tablesForm.getUserFromTable(), user);
        softAssertForRemovingUser.assertAll("Amount of lines in the table hasn't changed and user data wasn't deleted from the table.");
    }

    @Test
    public void windowHandlesTest() {
        LogUtils.setLogInfoForStep(1, "Move to Main Page.");
        Assert.assertTrue(toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click 'Alerts, Frame & Windows' button. On the opened page click 'Browser Windows' in the left menu");
        toolsQAHomePage.clickOnAlertFrameAndWindowsButton();
        alertFrameAndWindowsPage.openBrowserWindowForm();
        Assert.assertTrue(browserWindowsForm.isOpened(), "Browser windows form isn't opened.");

        LogUtils.setLogInfoForStep(3, "Click 'New Tab' button.");
        browserWindowsForm.clickOnNewTabButton();
        ArrayList<String> tabListWithSamplePage = CommonUtils.createTabHandles();
        CommonUtils.switchTab(tabListWithSamplePage, 1);
        SoftAssert softAssertForSamplePage = new SoftAssert();
        softAssertForSamplePage.assertTrue(samplePage.isOpened(), "Sample page isn't opened.");
        softAssertForSamplePage.assertTrue(tabListWithSamplePage.size() > 1, "New tab isn't opened.");
        softAssertForSamplePage.assertAll("Sample page isn't opened in a new tab.");

        LogUtils.setLogInfoForStep(4, "Close current tab.");
        samplePage.closePage();
        CommonUtils.switchTab(tabListWithSamplePage, 0);
        Assert.assertTrue(browserWindowsForm.isOpened());

        LogUtils.setLogInfoForStep(5, "Choose 'Elements → Links' in the left menu.");
        linksForm.openLinksForm();
        Assert.assertTrue(linksForm.isOpened());

        LogUtils.setLogInfoForStep(6, "Move by 'Home' link.");
        linksForm.clickOnHomeLink();
        ArrayList<String> tabsListWithHomePage = CommonUtils.createTabHandles();
        CommonUtils.switchTab(tabsListWithHomePage, 1);
        SoftAssert softAssertForHomePage = new SoftAssert();
        softAssertForHomePage.assertTrue(toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");
        softAssertForHomePage.assertTrue(tabsListWithHomePage.size() > 1, "New tab isn't opened.");
        softAssertForHomePage.assertAll("ToolsQA Home Page isn't opened in a new tab.");

        LogUtils.setLogInfoForStep(7, "Switch to the previous tab.");
        toolsQAHomePage.closePage();
        CommonUtils.switchTab(tabsListWithHomePage, 0);
        Assert.assertTrue(linksForm.isOpened(), "Links form isn't opened.");
    }
}
