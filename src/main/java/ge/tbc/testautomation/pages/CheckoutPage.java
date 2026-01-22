package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckoutPage {
    protected Page page;

    public Locator signInTab;
    public Locator guestMode;
    public Locator emailInput;
    public Locator nameInput;
    public Locator lNameInput;
    public Locator submitBtn;
    public Locator continueBtn;
    public Locator street;
    public Locator city;
    public Locator state;
    public Locator country;
    public Locator postalCode;
    public Locator proceed;
    public Locator payment;
    public Locator finishBtn;
    public Locator successMsg;





    public CheckoutPage(Page page) {
    this.page = page;
    this.signInTab = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Sign in"));
    this.guestMode = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Continue As Guest"));
    this.emailInput = page.locator("[data-test='guest-email']");
    this.nameInput = page.locator("[data-test='guest-first-name']");
    this.lNameInput = page.locator("[data-test='guest-last-name']");
    this.submitBtn = page.locator("[data-test='guest-submit']");
    this.continueBtn = page.locator("[data-test='proceed-2-guest']");
    this.street = page.locator("[data-test='street']");
    this.state = page.locator("[data-test='state']");
    this.country = page.locator("[data-test='country']");
    this.postalCode = page.locator("[data-test='postal_code']");
    this.city = page.locator("[data-test='city']");
    this.proceed = page.locator("[data-test='proceed-3']");
    this.payment = page.locator("[data-test='payment-method']");
    this.finishBtn = page.locator("[data-test='finish']");
    this.successMsg = page.locator("[data-test='payment-success-message']");









    }
}

