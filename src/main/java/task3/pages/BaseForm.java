package task3.pages;

import org.openqa.selenium.NoSuchElementException;
import task3.browser.BrowserUtils;
import task3.driver.DriverSingleton;
import task3.elements.BaseElement;
import task3.utils.WaitUtils;

public abstract class BaseForm {

    private BaseElement elementShowsPageOrFormIsOpened;

    public BaseForm(BaseElement elementShowsPageOrFormIsOpened) {
        this.elementShowsPageOrFormIsOpened = elementShowsPageOrFormIsOpened;
    }

    public boolean isOpened() {
        return elementShowsPageOrFormIsOpened.isDisplayed(elementShowsPageOrFormIsOpened.getLocator());
    }

    public boolean isClosed() {
        try {
            WaitUtils.waitUntilWebElementIsInvisible(BrowserUtils.findElementOnThePage(elementShowsPageOrFormIsOpened.getLocator()));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void closePage() {
        DriverSingleton.getDriver().close();
    }
}