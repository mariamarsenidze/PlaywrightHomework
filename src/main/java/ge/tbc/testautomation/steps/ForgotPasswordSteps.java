package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ForgotPasswordPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ForgotPasswordSteps {
    private final Page page;
    protected ForgotPasswordPage forgotPage;


    public ForgotPasswordSteps(Page page) {
        this.page = page;
        this.forgotPage = new ForgotPasswordPage(page);
    }

    public ForgotPasswordSteps submitForgotPassword(String email) {
        forgotPage.emailInput.fill(email);
        forgotPage.submitBtn.click();
        assertThat(forgotPage.passwordUpdateAlert).isVisible();

        return this;
    }

}
