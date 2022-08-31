package task3.pages;

import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.elements.Button;
import task3.elements.OptionInList;
import task3.elements.ProgressBar;
import task3.elements.TextElement;
import task3.utils.JavaScriptUtils;
import task3.utils.WaitUtils;

public class ProgressBarForm extends BaseForm{

    private static TextElement progressBarHeader = new TextElement("headerOfSliderForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private OptionInList progressBarOption = new OptionInList("progressBarOption", By.xpath("//div[contains(@class, 'show')]//li[@id='item-4']"));
    private Button startStopButton = new Button("startStopButton", By.id("startStopButton"));
    private ProgressBar progressBar = new ProgressBar("progressBar", By.xpath("//div[@role='progressbar']"));

    public ProgressBarForm() {
        super(progressBarHeader);
    }

    public void clickOnProgressBarOption(){
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(progressBarOption.getLocator()));
        progressBarOption.click();
    }

    public void clickStartStopButton(){
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(startStopButton.getLocator()));
        startStopButton.click();
    }

    public void clickStopButtonAfterAchievingValueOfTestersAge(String ageOfTester){
        //when testers age is in the beginning of the progress bar, waiter is able to catch the value of the attribute 'value now' (ex. age 23)
        //when in the middle or end, waiter doesn't catch the value of attribute  because progress bar speed is too high (ex. age 50)
        WaitUtils.waitForProgressBarValue(progressBar, ageOfTester);
        startStopButton.click();
    }



    public String getValueOfProgressBar(){
        return BrowserUtils.findElementOnThePage(progressBar.getLocator()).getAttribute("aria-valuenow");
    }

    public boolean combineRequiredAndActualProgressBarValuesWithCalculationError(String requiredValue, String actualValue, long percentageOfCalculationError){
        long minProgressBarPermissibleValue = Integer.parseInt(requiredValue) - Integer.parseInt(requiredValue)*percentageOfCalculationError/100;
        long maxProgressBarPermissionValue = Integer.parseInt(requiredValue) + Integer.parseInt(requiredValue)*percentageOfCalculationError/100;
        return Long.parseLong(actualValue) >= minProgressBarPermissibleValue && Long.parseLong(actualValue) <= maxProgressBarPermissionValue;
    }
}
