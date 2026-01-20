package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.LoginPage;

public class LoginSteps extends CommonSteps {

    private final LoginPage loginPage;

    public LoginSteps(Page page) {
        super(page);
        this.loginPage = new LoginPage(page);
    }

    public LoginSteps navigateToLogin() {
        commonPage.signIn.click();
        return this;
    }

    public LoginSteps goToRegistration() {
        loginPage.registerLink.click();
        return this;
    }


    public LoginSteps login(String email, String password) {

        loginPage.emailInput.fill(email);
        loginPage.passwordInput.fill(password);
        loginPage.loginButton.click();
        return this;
    }

}
