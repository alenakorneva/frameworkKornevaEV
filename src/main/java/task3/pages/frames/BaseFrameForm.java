package task3.pages.frames;

import org.openqa.selenium.By;

public abstract class BaseFrameForm {

    protected String name;
    protected By locator;

    public BaseFrameForm(String name, By locator) {
        this.name = name;
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }
}
