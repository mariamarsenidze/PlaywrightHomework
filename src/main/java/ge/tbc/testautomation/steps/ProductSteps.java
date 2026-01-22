package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.HomePage;
import ge.tbc.testautomation.pages.ProductPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductSteps {
    private final Page page;
    protected ProductPage productPage;


    public ProductSteps(Page page) {
        this.page = page;
        this.productPage = new ProductPage(page);
    }
    public ProductSteps verifyDetails() {

        assertThat(productPage.productName).isVisible();
        assertThat(productPage.unitPrice).isVisible();
        assertThat(productPage.description).isVisible();
        assertThat(productPage.co2Rating).isVisible();
        assertThat(productPage.quantityInput).isVisible();

        return this;
    }
    public ProductSteps increaseQuantity(int expectedQuantity) {
        productPage.increaseQtyBtn.click();

        return this;

    }
    public ProductSteps verifyQuantity(int expectedQuantity) {
    assertThat(productPage.quantityInput).hasValue(String.valueOf(expectedQuantity));
    return this;
    }
    public ProductSteps addToCart() {
        productPage.addToCartBtn.click();
        return this;
    }
    public ProductSteps verifyCartChanges() {
        assertThat(productPage.toastMessage).hasText(Constants.EXPECTED_TEXT);
        productPage.cartBadge.isVisible();
        return this;
    }
    public ProductSteps favorites() {
        productPage.favoritesBtn.click();
        return this;
    }
    public  ProductSteps verifyFavorites() {
        productPage.toastMessage.isVisible();
    return this;}




}
