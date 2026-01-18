package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.DashboardPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DashboardSteps extends CommonSteps {
    private final DashboardPage dashboardPage;

    public DashboardSteps(Page page) {
        super(page);
        this.dashboardPage = new DashboardPage(page);
    }

    public DashboardSteps goToFavourites() {
        commonPage.menu.click();
        dashboardPage.favouritesLink.waitFor();
        dashboardPage.favouritesLink.click();
        return this;
    }

    public String addRandomProductToFavourites() {
        dashboardPage.productCard.first().waitFor();

        String name = dashboardPage.productCard.first()
                .locator("[data-test='product-name']")
                .innerText()
                .trim();

        dashboardPage.productCard.first().click();

        dashboardPage.addToFavouritesBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        dashboardPage.addToFavouritesBtn.click();

        return name;
    }



    public void assertProductInFavourites(String expectedName) {
        assertThat(dashboardPage.productName).containsText(expectedName);
    }

    public DashboardSteps selectHandTools() {
        dashboardPage.handToolsCheckbox.click();
        return this;
    }

    public DashboardSteps selectPowerTools() {
        dashboardPage.powerToolsCheckbox.click();
        return this;
    }

    public DashboardSteps uncheckHandTools() {
        dashboardPage.handToolsCheckbox.click();
        return this;
    }

    public int getProductCount() {
        page.waitForTimeout(1000);
        return dashboardPage.allProducts.count();
    }
    public DashboardSteps hammerClick(){
        dashboardPage.hammerCategory.click();
        return this;
    }



}