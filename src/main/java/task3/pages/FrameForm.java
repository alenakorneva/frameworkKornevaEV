package task3.pages;

import task3.elements.Frame;
import task3.elements.OptionInList;
import task3.elements.TextElement;
import org.openqa.selenium.By;
import task3.utils.CommonUtils;

public class FrameForm extends BaseForm {

    private static TextElement headerOfFrameForm = new TextElement("headerOfFrameForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private OptionInList framesOption = new OptionInList("framesOption", By.xpath("//div[contains(@class, 'show')]//li[@id='item-2']"));
    private Frame upperFrame = new Frame("upperFrame", By.id("frame1"));
    private TextElement upperText = new TextElement("upperText", By.id("sampleHeading"));
    private Frame downFrame = new Frame("downFrame", By.id("frame2"));
    private TextElement downText = new TextElement("downText", By.id("sampleHeading"));

    public FrameForm() {
        super(headerOfFrameForm);
    }

    public void clickOnFramesOption() {
        framesOption.click();
    }

    public String getUpperText() {
        CommonUtils.scrollUntilWebElementIsVisible(upperFrame.find());
        upperFrame.openFrame();
        String textInUpperFrame = upperText.getText();
        upperFrame.goOutOfFrames();
        return textInUpperFrame;
    }

    public String getDownText() {
        downFrame.openFrame();
        String textInDownFrame = downText.getText();
        downFrame.goOutOfFrames();
        return textInDownFrame;
    }

    public void leaveFrames() {
        downFrame.goOutOfFrames();
    }
}
