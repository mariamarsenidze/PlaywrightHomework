package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.AssertJUnit.assertNotNull;

public class HomeSteps {
    protected Page page;
    protected HomePage homePage;
    private String extractedEmail;

    public HomeSteps(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
    }

    public HomeSteps open() {
        page.navigate(Constants.URL);
        return this;
    }

    public HomeSteps verifyShopLoaded() {
        homePage.logo.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(homePage.logo).isVisible();
        return this;
    }

    public HomeSteps getFooterEmail() {
        Object email = page.frame("framelive").evaluate("""
            () => document.querySelector("footer a[href^='mailto:']").textContent
        """);

        this.extractedEmail = (String) email;
        System.out.println(Constants.MESSAGE1 + extractedEmail);
        return this;
    }

    public HomeSteps verifyFooterEmail() {
        assertNotNull(Constants.MESSAGE2, extractedEmail);
        return this;
    }

    public HomeSteps goContactUs() {
        homePage.contactUs.click();
        return this;
    }
}

