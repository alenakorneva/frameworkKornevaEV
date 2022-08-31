package task3.pages;

import org.openqa.selenium.By;
import task3.browser.BrowserUtils;
import task3.elements.Button;
import task3.elements.OptionInList;
import task3.elements.TextElement;
import task3.utils.JavaScriptUtils;
import task3.utils.WaitUtils;

import java.nio.file.Files;
import java.nio.file.Path;

public class UploadAndDownloadForm extends BaseForm {

    private static TextElement headerOfUploadAndDownloadForm = new TextElement("headerOfUploadAndDownloadForm", By.xpath("//div[contains(@class, 'main-header')]"));
    private OptionInList uploadAndDownloadOption = new OptionInList("uploadAndDownloadOption", By.xpath("//div[contains(@class, 'show')]//li[@id='item-7']"));
    private Button downloadButton = new Button("downloadButton", By.id("downloadButton"));
    private Button chooseFileButton = new Button("chooseFileButton", By.id("uploadFile"));
    private TextElement pathOfUploadedFile = new TextElement("pathOfUploadedFile", By.id("uploadedFilePath"));

    public UploadAndDownloadForm() {
        super(headerOfUploadAndDownloadForm);
    }

    public void clickOnUploadAndDownloadOption() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(uploadAndDownloadOption.getLocator()));
        uploadAndDownloadOption.click();
    }

    public void clickOnDownloadButton() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(downloadButton.getLocator()));
        downloadButton.click();
    }

    public static boolean fileIsDownload(String path) {
        return Files.exists(Path.of(path));
    }

    public void waitForFileToDownload(String path, long timeout) {
        WaitUtils.waitUntilFileIsDownloaded(path, timeout);
    }

    public String getFileName(String absolutePath) {
        int indexOfLastSlash = absolutePath.lastIndexOf("\\");
        return absolutePath.substring(indexOfLastSlash + 1);
    }

    public void uploadFile(String path) {
        BrowserUtils.findElementOnThePage(chooseFileButton.getLocator()).sendKeys(path);
    }

    public boolean pathNextToUploadedFileContainsDownloadedFileName(String fileName) {
        return pathOfUploadedFile.getText().contains(fileName);
    }


}
