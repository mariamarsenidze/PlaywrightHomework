package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

public class CustomerSupportTest extends BaseTest {

    @Test(priority = 1, description = "ნავიგაცია მაღაზიაში და iframe-ის ჩატვირთვის შემოწმება")
    public void shouldAccessShopInsideIframe() {
        homeSteps
                .open()
                .verifyShopLoaded();
    }

    @Test(priority = 2, description = "JavaScript-ის საშუალებით ფუტერიდან ელ-ფოსტის მისამართის ამოღება")
    public void shouldExtractFooterEmail() {
        homeSteps
                .getFooterEmail()
                .verifyFooterEmail();
    }

    @Test(priority = 3, description = "საკონტაქტო ფორმის შევსება და ფაილის მიბმა")
    public void openFillContactUs() {
        homeSteps.goContactUs();
        contactSteps
                .fillContactForm(
                        "Webmaster",
                        "user@example.com",
                        "This is a test support message")
                .uploadFile();
    }

    @Test(priority = 4, description = "ფორმის გაგზავნა და წარმატების შეტყობინების ვალიდაცია")
    public void SubmitContactUsForm() {
        contactSteps.submitForm();
        contactSteps.verifySuccessMessage();
    }
}