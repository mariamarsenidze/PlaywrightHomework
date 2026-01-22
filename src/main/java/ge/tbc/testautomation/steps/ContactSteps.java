package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.ContactPage;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactSteps {
    private final ContactPage contactPage;

    public ContactSteps(Page page) {
        this.contactPage = new ContactPage(page);
    }

    public ContactSteps fillContactForm(String subject, String email, String message) {
        contactPage.subjectSelect.selectOption(subject);
        contactPage.emailInput.fill(email);
        contactPage.messageArea.fill(message);
        return this;
    }

    public ContactSteps uploadFile() {
        contactPage.fileUploadInput.setInputFiles(Paths.get("src/main/resources/thisTXT.txt"));
        return this;
    }

    public ContactSteps submitForm() {
        contactPage.sendButton.click();
        return this;
    }

    public ContactSteps verifySuccessMessage() {
        assertThat(contactPage.successAlert).isVisible();
        assertThat(contactPage.successAlert).containsText(Constants.EXPECTED);
        return this;
    }
}