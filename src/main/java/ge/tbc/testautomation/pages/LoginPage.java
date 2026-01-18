package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    public Locator emailInput;
    public Locator passwordInput;
    public Locator loginButton;
    public Locator registerLink;

    public LoginPage(Page page) {
        emailInput = page.locator("input[data-test='email']");
        passwordInput =  page.locator("input[data-test='password']");
        loginButton = page.locator("input[data-test='login-submit']");
        registerLink = page.locator("a[data-test='register-link']");
    }
}
