package task3.pages;

import task3.driver.DriverSingleton;
import task3.elements.BaseElement;

public abstract class BaseForm {

    private BaseElement elementShowsPageOrFormIsOpened;

    public BaseForm(BaseElement elementShowsPageOrFormIsOpened) {
        this.elementShowsPageOrFormIsOpened = elementShowsPageOrFormIsOpened;
    }

    public boolean isOpened() {
        return elementShowsPageOrFormIsOpened.getListOfElements().size() != 0;
    }

    public void closePage() {
        DriverSingleton.getDriver().close();
    }
}