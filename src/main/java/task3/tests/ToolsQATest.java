package task3.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task3.browser.BrowserUtils;
import task3.pages.AlertFrameAndWindowsForm;
import task3.pages.AlertsForm;
import task3.pages.BrowserWindowsForm;
import task3.pages.DatePickerForm;
import task3.pages.ElementForm;
import task3.pages.FramesForm;
import task3.pages.LinksForm;
import task3.pages.NestedFrameForm;
import task3.pages.ProgressBarForm;
import task3.pages.RegistrationForm;
import task3.pages.SamplePage;
import task3.pages.SliderForm;
import task3.pages.TablesForm;
import task3.pages.ToolsQAHomeForm;
import task3.pages.UploadAndDownloadForm;
import task3.service.DataProvider;
import task3.service.TestDataReaderFromConfigFile;
import task3.service.TestDataReaderFromTestFile;
import task3.service.User;
import task3.utils.CommonUtils;
import task3.utils.LogUtils;
import task3.utils.StringUtils;

import java.util.ArrayList;

public class ToolsQATest extends CommonTestConditions {
    ToolsQAHomeForm toolsQAHomePage = new ToolsQAHomeForm();

    AlertFrameAndWindowsForm alertFrameAndWindowsPage = new AlertFrameAndWindowsForm();
    AlertsForm alertsForm = new AlertsForm();

    NestedFrameForm nestedFrameForm = new NestedFrameForm();
    FramesForm framesForm = new FramesForm();

    ElementForm elementPage = new ElementForm();
    TablesForm tablesForm = new TablesForm();
    RegistrationForm registrationForm = new RegistrationForm();

    BrowserWindowsForm browserWindowsForm = new BrowserWindowsForm();
    SamplePage samplePage = new SamplePage();
    LinksForm linksForm = new LinksForm();

    SliderForm sliderForm = new SliderForm();
    ProgressBarForm progressBarForm = new ProgressBarForm();

    DatePickerForm datePickerForm = new DatePickerForm();

    UploadAndDownloadForm uploadAndDownloadForm = new UploadAndDownloadForm();

    @Test
    public void alertsTest() {

        LogUtils.setLogInfoForStep(1, "Go to main page");
        Assert.assertTrue(toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click 'Alerts, Frame & Windows' button. " +
                "On the opened page click 'Alerts' in the left menu.");
        toolsQAHomePage.clickOnAlertFrameAndWindowsButton();
        alertFrameAndWindowsPage.openAlertForm(TestDataReaderFromTestFile.getStringValueFromJsonByKey("alertOption"));
        Assert.assertTrue(alertsForm.isOpened(), "Alert form isn't opened.");

        LogUtils.setLogInfoForStep(3, "Click button 'Click Button to see alert'");
        alertsForm.clickOnButtonToSeeClickAlert();
        Assert.assertEquals(alertsForm.getTextOfClickAlert(), TestDataReaderFromTestFile.getStringValueFromJsonByKey("clickAlertText"),
                "Text of click alert isn't correct.");

        LogUtils.setLogInfoForStep(4, "Click 'OK' button");
        alertsForm.clickOKButtonOfClickAlert();
        Assert.assertTrue(alertsForm.clickAlertIsClosed(), "Alert isn't closed.");

        LogUtils.setLogInfoForStep(5, "Click 'On button click, confirm box will appear' button");
        alertsForm.clickOnButtonOfConfirmAlert();
        SoftAssert softAssertForOpeningConfirmAlert = new SoftAssert();
        softAssertForOpeningConfirmAlert.assertTrue(alertsForm.isOpened(), "Confirm alert isn't opened.");
        softAssertForOpeningConfirmAlert.assertTrue(alertsForm.getConfirmAlertText()
                        .equals(TestDataReaderFromTestFile.getStringValueFromJsonByKey("confirmAlertText")),
                String.format("Confirm alert isn't opened with the text %s",
                        TestDataReaderFromTestFile.getStringValueFromJsonByKey("confirmAlertText")));
        softAssertForOpeningConfirmAlert.assertAll(String.format("Confirm alert isn't opened with the text %s",
                TestDataReaderFromTestFile.getStringValueFromJsonByKey("confirmAlertText")));

        LogUtils.setLogInfoForStep(6, "Click 'OK' button");
        alertsForm.clickOnOKButtonOfConfirmAlert();
        SoftAssert softAssertForClosingConfirmAlert = new SoftAssert();
        softAssertForClosingConfirmAlert.assertTrue(alertsForm.confirmAlertIsClosed(), "Confirm alert isn't closed.");
        softAssertForClosingConfirmAlert.assertTrue(alertsForm.getTextNextToOKButtonOfConfirmAlert()
                        .equals(TestDataReaderFromTestFile.getStringValueFromJsonByKey("textNextToConfirmAlert")),
                String.format("Text in confirm alert isn't similar to %s",
                        TestDataReaderFromTestFile.getStringValueFromJsonByKey("textNextToConfirmAlert")));
        softAssertForClosingConfirmAlert.assertAll(String.format("Confirm alert isn't closed with the text %s",
                TestDataReaderFromTestFile.getStringValueFromJsonByKey("textNextToConfirmAlert")));

        LogUtils.setLogInfoForStep(7, "Click 'On button click, prompt box will appear' button");
        alertsForm.clickOnPromptAlertButton();
        SoftAssert softAssertForOpeningPromptAlert = new SoftAssert();
        softAssertForOpeningPromptAlert.assertTrue(alertsForm.promptAlertsOpened(), "Prompt alert isn't opened.");
        softAssertForOpeningPromptAlert.assertTrue(alertsForm.getTextOfPromptAlert()
                .equals("Please enter your name"), String.format("Text in prompt alert isn't similar to %s",
                TestDataReaderFromTestFile.getStringValueFromJsonByKey("promptAlertText")));
        softAssertForOpeningPromptAlert.assertAll(String.format("Prompt alert isn't opened with the text %s",
                TestDataReaderFromTestFile.getStringValueFromJsonByKey("promptAlertText")));

        LogUtils.setLogInfoForStep(8, "Insert randomly generated text, click 'OK' button");
        alertsForm.enterRandomTextInPromptAlertInputArea();
        alertsForm.clickOnOKButtonOfPromptAlert();
        SoftAssert softAssertForClosingPromptAlert = new SoftAssert();
        softAssertForClosingPromptAlert.assertTrue(alertsForm.promptAlertIsClosed(), "Prompt alert isn't closed.");
        softAssertForClosingPromptAlert.assertTrue(alertsForm.getTextNextToOKButtonOfPromptAlert()
                        .equals(AlertsForm.randomlyGeneratedText),
                String.format("Randomly generated text isn't similar to %s", AlertsForm.randomlyGeneratedText));
        softAssertForClosingPromptAlert.assertAll(String.format("Prompt alert isn't closed with the text %s", AlertsForm.randomlyGeneratedText));

    }

    @Test
    public void iframeTest() {

        LogUtils.setLogInfoForStep(1, "Move to Home page");
        Assert.assertTrue(toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click ' Alerts, Frame & Windows' button. " +
                "On the opened page click 'Nested Frames' in the left menu.");
        toolsQAHomePage.clickOnAlertFrameAndWindowsButton();
        alertFrameAndWindowsPage.openNestedFrameForm();
        SoftAssert softAssertForNestedFrameForm = new SoftAssert();
        softAssertForNestedFrameForm.assertTrue(nestedFrameForm.isOpened(), "NestedForm isn't opened.");
        softAssertForNestedFrameForm.assertTrue(nestedFrameForm.getTextOfParentFrameTextElement()
                        .equals(TestDataReaderFromTestFile.getStringValueFromJsonByKey("textInParentFrame")),
                String.format("Parent frame doesn't contain text %s", TestDataReaderFromTestFile.getStringValueFromJsonByKey("textInParentFrame")));
        softAssertForNestedFrameForm.assertTrue(nestedFrameForm.getTextOfChildFrameTextElement()
                        .equals(TestDataReaderFromTestFile.getStringValueFromJsonByKey("textInChildFrame")),
                String.format("Child frame doesn't contain text %s", TestDataReaderFromTestFile.getStringValueFromJsonByKey("textInChildFrame")));
        softAssertForNestedFrameForm.assertAll(String.format("Nested frames form isn't opened with %s and %s text.", "Parent frame", "Child Iframe"));
        BrowserUtils.goOutOfFrames();

        LogUtils.setLogInfoForStep(3, "Choose 'Frames' option in the left menu.");
        framesForm.clickOnFramesOption();
        SoftAssert softAssertForFrameForm = new SoftAssert();
        softAssertForFrameForm.assertTrue(framesForm.isOpened(), "Frame form isn't opened.");
        softAssertForFrameForm.assertEquals(framesForm.getUpperText(), framesForm.getDownText(),
                "Text in upper form isn't similar to the text in down form");
        softAssertForFrameForm.assertAll("IFrames form isn't opened with similar text in upper and down frames.");

    }

    @Test(
            dataProvider = "getUsersData",
            dataProviderClass = DataProvider.class
    )
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
        softAssertForRemovingUser.assertTrue(amountOfLinesAfterAddingNewUser - amountOfLinesAfterDeletingUser > 0,
                "Amount of lines in the table hasn't changed.");
        softAssertForRemovingUser.assertNotEquals(tablesForm.getUserFromTable(), user);
        softAssertForRemovingUser.assertAll("Amount of lines in the table hasn't changed and user data wasn't deleted from the table.");

    }

    @Test
    public void windowHandlesTest() {

        LogUtils.setLogInfoForStep(1, "Move to Main Page.");
        Assert.assertTrue(this.toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click 'Alerts, Frame & Windows' button. " +
                "On the opened page click 'Browser Windows' in the left menu");
        toolsQAHomePage.clickOnAlertFrameAndWindowsButton();
        alertFrameAndWindowsPage.openBrowserWindowForm(TestDataReaderFromTestFile.getStringValueFromJsonByKey("browserWindowsOption"));
        Assert.assertTrue(browserWindowsForm.isOpened(), "Browser windows form isn't opened.");

        LogUtils.setLogInfoForStep(3, "Click 'New Tab' button.");
        this.browserWindowsForm.clickOnNewTabButton();
        ArrayList<String> tabListWithSamplePage = StringUtils.createTabHandles();
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
        ArrayList<String> tabsListWithHomePage = StringUtils.createTabHandles();
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

    @Test
    public void SliderAndProgressBarTest() {

        LogUtils.setLogInfoForStep(1, "Move to Main Page.");
        Assert.assertTrue(toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click 'Widgets' button on the main page. " +
                "Click 'Slider' option in the left menu on Widgets page.");
        toolsQAHomePage.clickWidgetsButton();
        sliderForm.clickOnSliderOption();
        Assert.assertTrue(sliderForm.isOpened(), "Slider form isn't opened.");

        LogUtils.setLogInfoForStep(3, "Set correct randomly generated value for slider.");
        sliderForm.setRandomValueForSlider();
        Assert.assertEquals(Integer.toString(SliderForm.randomInputValue), sliderForm.getValueNextToSlider(),
                "Value next to the slider bar isn't similar to randomly generated value.");

        LogUtils.setLogInfoForStep(4, "Select 'Progress bar' option in the left menu.");
        progressBarForm.clickOnProgressBarOption();
        Assert.assertTrue(progressBarForm.isOpened(), "Page with progress bar isn't opened.");

        LogUtils.setLogInfoForStep(5, "Click 'Start' button.");
        progressBarForm.clickStartStopButton();

        LogUtils.setLogInfoForStep(6, "Click 'Stop' button when progress bar has value similar to engineer's age.");
        progressBarForm.clickStopButtonAfterAchievingValueOfTestersAge(TestDataReaderFromTestFile.getStringValueFromJsonByKey("engineerAge"));
        Assert.assertTrue(progressBarForm.combineRequiredAndActualProgressBarValuesWithCalculationError(
                        TestDataReaderFromTestFile.getStringValueFromJsonByKey("engineerAge"),
                        progressBarForm.getValueOfProgressBar(),
                        TestDataReaderFromTestFile.getLongValueFromJsonByKey("percentageOfCalculationError")),
                "Value on progress bar isn't similar to engineer's age");

    }

    @Test
    public void DatePickerTest() {

        LogUtils.setLogInfoForStep(1, "Move to the main page.");
        Assert.assertTrue(this.toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click 'Widgets' button on the main page. " +
                "Click 'Date picker' option in the left menu on Widgets page.");
        toolsQAHomePage.clickWidgetsButton();
        datePickerForm.clickOnDatePickerOption();
        SoftAssert softAssertForCurrentDate = new SoftAssert();
        softAssertForCurrentDate.assertTrue(datePickerForm.isOpened(), "Date picker form isn't opened.");
        softAssertForCurrentDate.assertEquals(datePickerForm.getDateFromSelectDateField(), datePickerForm.getCurrentDate(),
                "Date from 'Select Date' field isn't similar to current date");
        softAssertForCurrentDate.assertEquals(datePickerForm.getDateFromDateAndTimeField(), datePickerForm.getCurrentDateAndTime(),
                "Date from 'Date And Time' field isn't similar to current date");
        softAssertForCurrentDate.assertAll("Date picker form isn't opened with date from 'Select Date' and 'Date And Time' fields similar to current date.");

        LogUtils.setLogInfoForStep(3, "Select the nearest February, 29.");
        datePickerForm.setRequiredDate(TestDataReaderFromTestFile.getStringValueFromJsonByKey("requiredMonth"), TestDataReaderFromTestFile.getStringValueFromJsonByKey("requiredDay"));
        Assert.assertEquals(datePickerForm.getDateFromSelectDateForm(),
                TestDataReaderFromTestFile.getStringValueFromJsonByKey("requiredDate"),
                "Date in the 'Select date' field isn't similar to the date that was set");

    }

    @Test
    public void UploadingAndDownloadingFilesTest() {

        LogUtils.setLogInfoForStep(1, "Move to the main page.");
        Assert.assertTrue(toolsQAHomePage.isOpened(), "ToolsQA Home Page isn't opened.");

        LogUtils.setLogInfoForStep(2, "Click on 'Elements' button. Click 'Upload and Download' option in the left menu of the opened page.");
        toolsQAHomePage.clickOnElementsButton();
        uploadAndDownloadForm.clickOnUploadAndDownloadOption();
        Assert.assertTrue(uploadAndDownloadForm.isOpened(), "Upload and Download form isn't opened.");

        LogUtils.setLogInfoForStep(3, "Click 'Download' button and wait for file downloading.");
        uploadAndDownloadForm.clickOnDownloadButton();
        uploadAndDownloadForm.waitForFileToDownload(TestDataReaderFromTestFile.getStringValueFromJsonByKey("absolutePathForFile"),
                TestDataReaderFromConfigFile.getLongValueFromJsonByKey("awaitTimeout"));
        Assert.assertTrue(UploadAndDownloadForm.fileIsDownload(TestDataReaderFromTestFile.getStringValueFromJsonByKey("absolutePathForFile")));

        LogUtils.setLogInfoForStep(4, "Upload the file downloaded in step 3 on the page.");
        uploadAndDownloadForm.uploadFile(TestDataReaderFromTestFile.getStringValueFromJsonByKey("absolutePathForFile"));
        String fileName = uploadAndDownloadForm.getFileName(TestDataReaderFromTestFile.getStringValueFromJsonByKey("absolutePathForFile"));
        Assert.assertTrue(uploadAndDownloadForm.pathNextToUploadedFileContainsDownloadedFileName(fileName),
                "Path to file contains file's name.");

    }
}
