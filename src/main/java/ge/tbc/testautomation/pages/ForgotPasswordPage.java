package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class ForgotPasswordPage {


    protected Page page;

    public Locator emailInput;
    public Locator submitBtn;
    public Locator passwordUpdateAlert;


    public ForgotPasswordPage(Page page) {
        this.page = page;
        this.emailInput = page.locator("input[data-test='email']");
        this.submitBtn = page.locator("input[data-test='forgot-password-submit']");
        this.passwordUpdateAlert = page.locator("div.alert-success:has-text('Your password is successfully updated!')");

    }



}