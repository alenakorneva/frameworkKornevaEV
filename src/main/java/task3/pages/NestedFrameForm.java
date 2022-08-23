package task3.pages;

import task3.elements.Frame;
import task3.elements.TextElement;
import org.openqa.selenium.By;
import task3.utils.CommonUtils;

public class NestedFrameForm extends BaseForm {

    private static TextElement headerOfNestedFramesForm = new TextElement("headerOfNestedFramesForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private Frame parentFrame = new Frame("parentFrame", By.id("frame1"));
    private TextElement parentFrameTextElement = new TextElement("parentFrameTextElement", By.xpath("//body"));
    private Frame childFrame = new Frame("childFrame", By.xpath("//iframe[contains(@srcdoc, 'Child')]"));
    private TextElement childFrameTextElement = new TextElement("childFrameTextElement", By.xpath("//body"));

    public NestedFrameForm() {
        super(headerOfNestedFramesForm);
    }

    public String getTextOfParentFrameTextElement() {
        CommonUtils.scrollUntilWebElementIsVisible(parentFrame.find());
        parentFrame.openFrame();
        return parentFrameTextElement.getText();
    }

    public String getTextOfChildFrameTextElement() {
        childFrame.openFrame();
        return childFrameTextElement.getText();
    }

    public void leaveFrames() {
        childFrame.goOutOfFrames();
    }
}
