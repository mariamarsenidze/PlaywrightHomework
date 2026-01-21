package ge.tbc.testautomation.steps;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;

import java.nio.file.Path;
import java.nio.file.Paths;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.ContactPage;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactSteps {

    private final Page page;
    protected ContactPage contactPage;

    public ContactSteps(Page page) {
        this.page = page;
        this.contactPage = new ContactPage(page);
    }
    public ContactSteps emptyForm(){
        contactPage.submitBtn.click();
        assertThat(contactPage.fNameError).isVisible();
        assertThat(contactPage.lNameError).isVisible();
        assertThat(contactPage.emailError).isVisible();
        assertThat(contactPage.subjectError).isVisible();
        assertThat(contactPage.messageError).isVisible();
        return this;

    }
    public ContactSteps fillFormStart(String firstName, String lastName, String email) {
        contactPage.firstName.fill(firstName);
        contactPage.lastName.fill(lastName);
        contactPage.email.fill(email);

        return this;
    }
    public ContactSteps fillSubject(String subject) {
        contactPage.subject.selectOption(subject);

        return this;
    }
    public ContactSteps fillMessage(String message) {
        contactPage.message.fill(message);

        return this;
    }
    public ContactSteps attachWrong() {
        FileChooser fileChooser = page.waitForFileChooser(contactPage.attachment::click);
        fileChooser.setFiles(new Path[]{
                Paths.get(System.getProperty("user.dir"), Constants.IMAGE_SRC)

        });
        assertThat(contactPage.attachmentMsg).isVisible();

        return this;
    }
    public ContactSteps attachRight() {
        FileChooser fileChooser = page.waitForFileChooser(contactPage.attachment::click);
        fileChooser.setFiles(new Path[]{
                Paths.get(System.getProperty("user.dir"), Constants.TXT_SRC)

        });

        return this;
    }
    public ContactSteps submit() {
        contactPage.submitBtn.click();
        assertThat(contactPage.successAlert).isVisible();
        return this;
    }
    public ContactSteps verifyForNewForm() {
        assertThat(contactPage.firstName).isEmpty();
        assertThat(contactPage.email).isEmpty();
        assertThat(contactPage.message).isEmpty();
        return this;


    }











}

