package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginSteps {

    private final Page page;
    private final LoginPage loginPage;

    public LoginSteps(Page page) {
        this.page = page;
        this.loginPage = new LoginPage(page);
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

    public LoginSteps clickForgotPassword() {
        loginPage.forgotPassword.click();
        assertThat(loginPage.forgotPasswordForm).isVisible();

        return this;
    }




}
