package ge.tbc.testautomation.pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ContactPage {
    public FrameLocator shopFrame;
    public Locator subjectSelect;
    public Locator emailInput;
    public Locator messageArea;
    public Locator fileUploadInput;
    public Locator sendButton;
    public Locator successAlert;

    public ContactPage(Page page) {
        this.shopFrame = page.frameLocator("#framelive");
        this.subjectSelect = shopFrame.locator("select[name='id_contact']");
        this.emailInput = shopFrame.locator("input[name='from']");
        this.messageArea = shopFrame.locator("textarea[name='message']");
        this.fileUploadInput = shopFrame.locator("input[name='fileUpload']");
        this.sendButton = shopFrame.locator("input[name='submitMessage']");
        this.successAlert = shopFrame.locator(".alert-success");
    }
}