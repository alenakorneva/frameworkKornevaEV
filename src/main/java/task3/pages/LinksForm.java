package task3.pages;


import task3.elements.Link;
import task3.elements.OptionInList;
import task3.elements.TextElement;
import org.openqa.selenium.By;
import task3.utils.CommonUtils;

public class LinksForm extends BaseForm {

    private static TextElement headerOfLinksForm = new TextElement("headerOfLinksForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private OptionInList elementsOption = new OptionInList("elementsOption", By.xpath("//div[contains(@class, 'accordion')]/div[1]//div[contains(@class, 'header-right')]"));
    private OptionInList linksOption = new OptionInList("linksOption", By.xpath("//div[contains(@class, 'show')]//li[@id='item-5']"));
    private Link homeLink = new Link("homeLink", By.id("simpleLink"));

    public LinksForm() {
        super(headerOfLinksForm);
    }

    public void openLinksForm(){
        elementsOption.click();
        CommonUtils.scrollUntilWebElementIsVisible(linksOption.find());
        linksOption.click();
    }

    public void clickOnHomeLink(){
        homeLink.click();
    }
}
