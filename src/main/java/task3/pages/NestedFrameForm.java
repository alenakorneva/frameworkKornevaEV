package task3.pages;

import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.elements.TextElement;
import task3.pages.frames.ChildFrame;
import task3.pages.frames.ParentFrame;
import task3.utils.JavaScriptUtils;

public class NestedFrameForm extends BaseForm {

    private static TextElement headerOfNestedFramesForm = new TextElement("headerOfNestedFramesForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private ParentFrame parentFrame = new ParentFrame("parentFrame", By.id("frame1"));
    private TextElement parentFrameTextElement = new TextElement("parentFrameTextElement", By.xpath("//body"));
    private ChildFrame childFrame = new ChildFrame("childFrame", By.xpath("//iframe[contains(@srcdoc, 'Child')]"));
    private TextElement childFrameTextElement = new TextElement("childFrameTextElement", By.xpath("//body"));

    public NestedFrameForm() {
        super(headerOfNestedFramesForm);
    }

    public String getTextOfParentFrameTextElement() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(parentFrame.getLocator()));
        BrowserUtils.openFrame(BrowserUtils.findElementOnThePage(parentFrame.getLocator()));
        return parentFrameTextElement.getText();
    }

    public String getTextOfChildFrameTextElement() {
        BrowserUtils.openFrame(BrowserUtils.findElementOnThePage(childFrame.getLocator()));
        return childFrameTextElement.getText();
    }

}
