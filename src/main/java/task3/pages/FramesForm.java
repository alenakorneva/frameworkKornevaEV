package task3.pages;

import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.elements.OptionInList;
import task3.elements.TextElement;
import task3.pages.frames.DownFrame;
import task3.pages.frames.UpperFrame;
import task3.utils.JavaScriptUtils;

public class FramesForm extends BaseForm {

    private static TextElement headerOfFrameForm = new TextElement("headerOfFrameForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private OptionInList framesOption = new OptionInList("framesOption", By.xpath("//div[contains(@class, 'show')]//li[@id='item-2']"));
    private UpperFrame upperFrame = new UpperFrame("upperFrame", By.id("frame1"));
    private TextElement upperText = new TextElement("upperText", By.id("sampleHeading"));
    private DownFrame downFrame = new DownFrame("downFrame", By.id("frame2"));
    private TextElement downText = new TextElement("downText", By.id("sampleHeading"));

    public FramesForm() {
        super(headerOfFrameForm);
    }

    public void clickOnFramesOption() {
        framesOption.click();
    }

    public String getUpperText() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(upperFrame.getLocator()));
        BrowserUtils.openFrame(BrowserUtils.findElementOnThePage(upperFrame.getLocator()));
        String textInUpperFrame = upperText.getText();
        BrowserUtils.goOutOfFrames();
        return textInUpperFrame;
    }

    public String getDownText() {
        BrowserUtils.openFrame(BrowserUtils.findElementOnThePage(downFrame.getLocator()));
        String textInDownFrame = downText.getText();
        BrowserUtils.goOutOfFrames();
        return textInDownFrame;
    }
}
