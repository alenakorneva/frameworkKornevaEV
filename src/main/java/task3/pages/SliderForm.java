package task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import task3.browser.BrowserUtils;
import task3.driver.DriverSingleton;
import task3.elements.InputField;
import task3.elements.OptionInList;
import task3.elements.Slider;
import task3.elements.TextElement;
import task3.utils.JavaScriptUtils;

public class SliderForm extends BaseForm {

    private static TextElement headerOfSliderForm = new TextElement("headerOfSliderForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private OptionInList sliderOption = new OptionInList("sliderOption", By.xpath("//div[contains(@class, 'show')]//li[@id='item-3']"));
    private Slider slider = new Slider("slider", By.xpath("//input[contains(@class, 'slider')]"));
    private InputField inputForSliderValue = new InputField("inputForSliderValue", By.id("sliderValue"));
    public static int randomInputValue;

    public SliderForm() {
        super(headerOfSliderForm);
    }

    public void clickOnSliderOption() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(sliderOption.getLocator()));
        sliderOption.click();
    }

    public void setRandomValueForSlider() {
        Actions actions = new Actions(DriverSingleton.getDriver());
        //move mouse in the middle of the slider line
        actions.moveToElement(BrowserUtils.findElementOnThePage(slider.getLocator()), 0, 0);
        actions.clickAndHold(BrowserUtils.findElementOnThePage(slider.getLocator()));
        getRandomInputValue();
        if (randomInputValue > 50) {
            //длину слайдера узнать из атрибута, т.к. длина не всегда 100, меняется, хардкод
            for (int i = 0; i < (randomInputValue - 50); i++) {
                actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
        } else {
            for (int i = 0; i < (50 - randomInputValue); i++) {
                actions.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
        }
    }

    public String getValueNextToSlider() {
        return inputForSliderValue.getValueOfAttribute("value");
    }

    private int getRandomInputValue() {
        randomInputValue = (int) (Math.random() * 100 + 1);
        return randomInputValue;
    }
}
