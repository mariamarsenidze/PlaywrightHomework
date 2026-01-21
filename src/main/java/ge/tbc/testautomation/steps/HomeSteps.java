package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomeSteps {

    private final Page page;
    protected HomePage homePage;


    public HomeSteps(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
    }

    public HomeSteps openHomePage(String url) {
        page.navigate(url);
        return this;
    }

    public HomeSteps verifyCatalogVisible() {

        assertThat(homePage.products.first()).isVisible();
        assertThat(homePage.sort).isVisible();
        assertThat(homePage.pagination).isVisible();
        assertThat(homePage.filter).isVisible();

        return this;
    }

    public HomeSteps searchProduct(String productName) {
        homePage.search.fill(productName);
        homePage.searchBtn.click();
        return this;


    }
    public HomeSteps verifyProducts(String productName) {
    assertThat(homePage.products.first()).isVisible();
    assertThat(homePage.productTitle.first()).containsText(Constants.HAMMER);
    return this;
    }

    public HomeSteps applyFilter() {
        homePage.category.click();
        homePage.brand.click();
        return this;

    }
    public  HomeSteps selectProduct() {
        homePage.products.first().click();
        return this;


    }

}
