package task3.pages;

import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.driver.DriverSingleton;
import task3.elements.OptionInList;
import task3.elements.TextElement;
import task3.utils.JavaScriptUtils;
import task3.utils.LocatorUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatePickerForm extends BaseForm {

    private static TextElement datePickerFormHeader = new TextElement("datePickerFormHeader", By.xpath("//div[contains(@class, 'main-header')]"));
    private OptionInList datePickerOption = new OptionInList("datePickerOption", By.xpath("//div[contains(@class, 'show')]//li[@id='item-2']"));
    private TextElement selectDateField = new TextElement("selectDateField", By.id("datePickerMonthYearInput"));
    private TextElement dateAndTimeField = new TextElement("dateAndTimeField", By.id("dateAndTimePickerInput"));
    private TextElement monthToSelect = new TextElement("monthToSelect", By.xpath("//select[contains(@class, 'month-select')]"));
    private String requiredMonth = "//option[contains(text(), '%s')]";
    private TextElement yearToSelect = new TextElement("yearToSelect", By.xpath("//select[contains(@class, 'year-select')]"));
    private String yearInList = "//select[contains(@class, 'year-select')]/option[contains(@value, '%d')]";
    private String baseLocatorForDayOfMonth = "//div[contains(text(), '%s') and contains(@aria-label, '%s')]";

    public DatePickerForm() {
        super(datePickerFormHeader);
    }

    public void clickOnDatePickerOption() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(datePickerOption.getLocator()));
        datePickerOption.click();
    }

    public String getDateFromSelectDateField() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(selectDateField.getLocator()));
        return selectDateField.getValueOfAttribute("value");
    }

    public String getDateFromDateAndTimeField() {
        return BrowserUtils.findElementOnThePage(dateAndTimeField.getLocator()).getAttribute("value");
    }

    public String getCurrentDate() {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    public String getCurrentDateAndTime() {
        LocalDateTime currentDayAndTime = LocalDateTime.now();
        return currentDayAndTime.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a", Locale.US));
    }

    public void setRequiredDate(String requiredMonth, String requiredDay) {
        selectDateField.click();
        setRequiredMonth(requiredMonth);
        setRequiredYear();
        TextElement requiredDayInMonth = new TextElement("requiredDayInMonth", LocatorUtils.getDynamicLocatorByXpath(baseLocatorForDayOfMonth, requiredDay, requiredMonth));
        requiredDayInMonth.click();
    }

    public String getDateFromSelectDateForm() {
        return selectDateField.getValueOfAttribute("value");
    }

    private void setRequiredMonth(String testValueOfRequiredMonth) {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(monthToSelect.getLocator()));
        monthToSelect.click();
        DriverSingleton.getDriver().findElement(By.xpath(String.format(requiredMonth, testValueOfRequiredMonth))).click();
    }

    private void setRequiredYear() {
        yearToSelect.click();
        BrowserUtils.findElementOnThePage(By.xpath(String.format(yearInList, getNearestLeapYear()))).click();
    }

    private int getNearestLeapYear() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        if (currentDate.isLeapYear()) {
            return currentDate.getYear();
        } else {
            int nextLeapYear = getNextLeapYear(currentYear);
            int previousLeapYear = getPreviousLeapYear(currentYear);
            return getNearestLeapYearToCurrentYear(currentDate, nextLeapYear, previousLeapYear);
        }
    }

    private int getNextLeapYear(int year) {
        for (int i = 0; i < 4; i++) {
            year++;
            if (year % 4 == 0) {
                return year;
            }
        }
        return year;
    }

    private int getPreviousLeapYear(int year) {
        for (int i = 0; i < 4; i++) {
            year--;
            if (year % 4 == 0) {
                return year;
            }
        }
        return year;
    }

    private int getNearestLeapYearToCurrentYear(LocalDate currentDate, int nextYear, int previousYear) {
        if ((currentDate.getYear() - previousYear) < (nextYear - currentDate.getYear())) {
            return previousYear;
        } else if ((nextYear - currentDate.getYear()) < (currentDate.getYear() - previousYear)) {
            return nextYear;
        } else {
            if (currentDate.getMonthValue() >= 6) {
                return nextYear;
            } else {
                return previousYear;
            }
        }
    }
}
