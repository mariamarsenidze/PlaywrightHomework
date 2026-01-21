package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import org.testng.annotations.Test;

public class GuestCheckoutTest extends BaseTest {
    @Test(priority = 1, description = "მთავარი გვერდის და კატალოგის ხილვადობის შემოწმება")
    void HomePageCatalog() {
        homeSteps.openHomePage(Constants.BASE_URL)
                .verifyCatalogVisible();
    }

    @Test(priority = 2, description = "პროდუქტის ძებნა დასახელებით")
    void searchItem() {
        homeSteps
                .searchProduct("Hammer")
                .verifyProducts("Hammer");
    }

    @Test(priority = 3, description = "ფილტრების გამოყენება ძიებისას")
    void applyFilters() {
        homeSteps.applyFilter();
    }

    @Test(priority = 4, description = "პროდუქტის დეტალების გვერდის შემოწმება")
    void productSelect() {
        homeSteps.selectProduct();
        productSteps.verifyDetails();
    }

    @Test(priority = 5, description = "პროდუქტის რაოდენობის შეცვლა")
    void quantityInput() {
        productSteps
                .increaseQuantity(2)
                .verifyQuantity(2);
    }

    @Test(priority = 6, description = "პროდუქტის კალათაში დამატება")
    void addToCart() {
        productSteps
                .addToCart()
                .verifyCartChanges();
    }

    @Test(priority = 7, description = "კალათის გვერდზე გადასვლა და მონაცემების ვალიდაცია")
    void cartPage() {
        commonSteps
                .openCartPage();
        cartSteps.verifyCartItems(
                "Hammer",
                2,
                "$13.41",
                "$26.82"
        );
    }

    @Test(priority = 8, description = "კალათაში რაოდენობის განახლება და ფასის გადათვლა")
    void quantityChange() {
        cartSteps
                .updateQuantity(3)
                .verifyTotalRecalculated(3);
    }

    @Test(priority = 9, description = "Checkout გვერდზე გადასვლა")
    void verifyCheckoutPage() {
        cartSteps.goToCheckout();
        checkoutSteps.verifyCheckout();
    }

    @Test(priority = 10, description = "საკონტაქტო ინფორმაციის შევსება (Guest Checkout)")
    void completeCheckoutInfo() {
        checkoutSteps
                .goToGuest()
                .fillInfo(
                        "user@example.com",
                        "John",
                        "Doe"
                );
    }

    @Test(priority = 11, description = "მისამართის და საგადახდო ინფორმაციის შევსება")
    void billingInfo() {
        checkoutSteps
                .continueToBilling()
                .fillBillingInfo(
                        "Dadiani",
                        "Tbilisi",
                        "Tbilisi",
                        "Georgia",
                        "0101"
                );
    }

    @Test(priority = 12, description = "გადახდის მეთოდის არჩევა და შეკვეთის დასრულება")
    void selectPayment() {
        checkoutSteps
                .selectPaymentMethod("cash-on-delivery")
                .verifyOrderSuccess();
    }
}