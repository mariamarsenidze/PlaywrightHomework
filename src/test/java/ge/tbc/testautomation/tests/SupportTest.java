package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SupportTest extends BaseTest {
    @Test(priority = 1, description = "კონტაქტის გვერდზე გადასვლა")
    void openContactPage() {
        homeSteps
                .openHomePage(Constants.BASE_URL);
        commonSteps.openContactn();
    }

    @Test(priority = 2, description = "ცარიელი ფორმის გაგზავნა და ვალიდაციის შემოწმება")
    void emptyFormErrors() {
        contactSteps.emptyForm();
    }

    @Test(priority = 3, description = "პერსონალური მონაცემების შევსება")
    void fillForm() {
        contactSteps.fillFormStart(
                "Maria",
                "Petrova",
                "user@example.com"
        );
    }

    @Test(priority = 4, description = "თემის არჩევა")
    void fillSubject() {
        contactSteps.fillSubject("Webmaster");
    }

    @Test(priority = 5, description = "შეტყობინების ტექსტის შევსება")
    void fillMessage() {
        contactSteps.fillMessage(
"Software testing plays a crucial role in ensuring the quality and reliability of modern applications. By carefully validating functionality, usability, and performance, testers help identify defects before they reach end users. Well-written test cases improve communication within the team and ensure that business requirements are correctly implemented and verified throughout the development process."        );
    }

    @Test(priority = 6, description = "არავალიდური ფორმატის ფაილის მიბმა")
    void attachFileWrong() {
        contactSteps.attachWrong();
    }

    @Test(priority = 7, description = "ვალიდური .txt ფაილის მიბმა")
    void attachFileRight() {
        contactSteps.attachRight();
    }

    @Test(priority = 8, description = "ფორმის გაგზავნა")
    void submitForm() {
        contactSteps.submit();
    }

    @Test(priority = 9, description = "ფორმის გასუფთავების შემოწმება ხელახალი გაგზავნისთვის")
    void verification() {
        commonSteps.openHomePage();
        commonSteps.openContactn();
        contactSteps.verifyForNewForm();
    }
}