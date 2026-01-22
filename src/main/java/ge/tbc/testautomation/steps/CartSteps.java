package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.CartPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartSteps {

    private final Page page;
    protected CartPage cartPage;

    public CartSteps(Page page) {
        this.page = page;
        this.cartPage = new CartPage(page);
    }

    public CartSteps verifyCartItems(
            String expectedProductName,
            int expectedQuantity,
            String expectedUnitPrice,
            String expectedTotalPrice
    ) {

        assertThat(cartPage.productName.first())
                .containsText(expectedProductName);

        assertThat(cartPage.quantityInput.first())
                .hasValue(String.valueOf(expectedQuantity));

        assertThat(cartPage.unitPrice.first())
                .hasText(expectedUnitPrice);

        assertThat(cartPage.totalPrice)
                .hasText(expectedTotalPrice);

        return this;
    }
    public CartSteps updateQuantity(int newQuantity) {
        cartPage.quantityInput.fill(String.valueOf(newQuantity));
        cartPage.quantityInput.press(Constants.ENTER);
        return this;



}
    public CartSteps verifyTotalRecalculated(int expectedQuantity) {

        String unitPriceText = cartPage.unitPrice.first().innerText()
                .replace("$", "")
                .trim();

        double unitPrice = Double.parseDouble(unitPriceText);

        double expectedTotal = unitPrice * expectedQuantity;

        assertThat(cartPage.totalPrice)
                .hasText("$" + String.format("%.2f", expectedTotal));

        return this;
    }
    public CartSteps goToCheckout() {
        cartPage.checkout.click();
        return this;
    }



}
