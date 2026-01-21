package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CartPage;
import ge.tbc.testautomation.pages.CheckoutPage;

public class CheckoutSteps {
    private final Page page;
    protected CheckoutPage checkoutPage;

    public CheckoutSteps(Page page) {
        this.page = page;
        this.checkoutPage = new CheckoutPage(page);
    }


    public CheckoutSteps verifyCheckout() {
        checkoutPage.signInTab.isVisible();
        return this;
    }
    public CheckoutSteps goToGuest() {
        checkoutPage.guestMode.click();
        return this;
    }
    public CheckoutSteps fillInfo(String email, String firstName, String lastName) {
        checkoutPage.emailInput.fill(email);
        checkoutPage.nameInput.fill(firstName);
        checkoutPage.lNameInput.fill(lastName);
        return this;
    }
    public CheckoutSteps continueToBilling() {
       checkoutPage.submitBtn.click();
       checkoutPage.continueBtn.click();

        return this;
    }
    public CheckoutSteps fillBillingInfo(String street, String city, String state, String country, String postalCode) {
        checkoutPage.street.fill(street);
        checkoutPage.city.fill(city);
        checkoutPage.state.fill(state);
        checkoutPage.country.fill(country);
        checkoutPage.postalCode.fill(postalCode);
        checkoutPage.proceed.click();

        return this;
    }
    public CheckoutSteps selectPaymentMethod(String methodValue) {
        checkoutPage.payment.click();
        checkoutPage.payment.selectOption(methodValue);
        checkoutPage.finishBtn.click();
        return this;
    }
    public CheckoutSteps verifyOrderSuccess() {
        checkoutPage.successMsg.isVisible();

        return this;
    }






}
