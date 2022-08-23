package task3.pages;

import task3.elements.OptionInList;
import task3.elements.TextElement;
import org.openqa.selenium.By;

public class ElementForm extends BaseForm {

    private static TextElement headerOfElementPage = new TextElement("headerOfElementPage", By.xpath(""));
    private static OptionInList webTablesFormOption = new OptionInList("webTablesForm", By.xpath("//div[contains(@class, 'show')]//li[@id='item-3']"));

    public ElementForm() {
        super(headerOfElementPage);
    }

    public void clickOnWebTablesFormOption() {
        webTablesFormOption.click();
    }
}
