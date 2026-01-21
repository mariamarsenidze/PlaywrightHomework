package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    public Locator registerLink;
    public Locator emailInput;
    public Locator passwordInput;
    public Locator loginButton;
    public Locator forgotPassword;
    public Locator forgotPasswordForm;




    public LoginPage(Page page) {

    this.registerLink = page.locator("a[data-test='register-link']");
      this.emailInput = page.locator("input[data-test='email']");
        this.passwordInput =  page.locator("input[data-test='password']");
        this.loginButton = page.locator("input[data-test='login-submit']");
        this.forgotPassword = page.locator("[data-test='forgot-password-link']");
        this.forgotPasswordForm = page.locator("[data-test='forgot-password-form']");




    }
}