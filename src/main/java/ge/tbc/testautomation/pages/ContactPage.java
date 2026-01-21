package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ContactPage {
    protected Page page;

    public Locator firstName;
    public Locator lastName;
    public Locator email;
    public Locator subject;
    public Locator message;
    public Locator attachment;
    public Locator submitBtn;
    public Locator fNameError;
    public Locator lNameError;
    public Locator emailError;
    public Locator subjectError;
    public Locator messageError;
    public Locator attachmentMsg;
    public Locator successAlert;





    public ContactPage(Page page) {
        this.page = page;
        this.firstName = page.locator("#first_name");
        this.lastName = page.locator("#last_name");
        this.email = page.locator("input[data-test='email']");
        this.subject = page.locator("select[data-test='subject']");
        this.message = page.locator("[data-test='message']");
        this.attachment = page.locator("[data-test='attachment']");
        this.submitBtn = page.locator("[data-test='contact-submit']");
        this.fNameError = page.locator("[data-test='first-name-error']");
        this.lNameError = page.locator("[data-test='last-name-error']");
        this.emailError = page.locator("[data-test='email-error']");
        this.subjectError = page.locator("[data-test='subject-error']");
        this.messageError = page.locator("[data-test='message-error']");
        this.attachmentMsg = page.locator("#attachmentHelp");
        this.successAlert = page.locator("div.alert-success:has-text('Thanks for your message!')");


    }
}