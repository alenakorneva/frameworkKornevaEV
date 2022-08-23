package task3.pages;

import task3.elements.TextElement;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {

    private static TextElement samplePageHeader = new TextElement("samplePageHeader", By.id("sampleHeading"));

    public SamplePage(){
        super(samplePageHeader);
    }
}
