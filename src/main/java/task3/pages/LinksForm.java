package task3.pages;


import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.elements.Link;
import task3.elements.OptionInList;
import task3.elements.TextElement;
import task3.utils.JavaScriptUtils;

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
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(linksOption.getLocator()));
        linksOption.click();
    }

    public void clickOnHomeLink(){
        homeLink.click();
    }
}
