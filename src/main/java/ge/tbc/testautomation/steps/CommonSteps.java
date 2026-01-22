package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CommonPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CommonSteps {
    private final Page page;
    protected CommonPage commonPage;


    public CommonSteps(Page page) {
        this.page = page;
        this.commonPage = new CommonPage(page);
    }

    public CommonSteps openCartPage() {
        commonPage.cart.click();
        return this;
    }
    public CommonSteps openSignInPage() {
        commonPage.signIn.click();
        return this;
    }
    public CommonSteps verifyLogin(String expectedFullName) {
        assertThat(commonPage.menu).containsText(expectedFullName);
        return this;

    }
    public CommonSteps openHomePage() {
        commonPage.home.click();
        return this;
    }
    public CommonSteps logOut() {
        commonPage.menu.click();
        commonPage.logoutBtn.click();
        assertThat(commonPage.signIn).isVisible();
        return this;

    }
    public CommonSteps signIn() {
        commonPage.signInBtn.click();
        return this;

    }
    public CommonSteps openContactn() {
        commonPage.contactBtn.click();
        return this;

    }




}