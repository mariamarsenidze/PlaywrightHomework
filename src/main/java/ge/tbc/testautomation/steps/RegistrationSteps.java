package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.RegistrationPage;

public class RegistrationSteps extends CommonSteps {

    private final RegistrationPage registrationPage;

    public RegistrationSteps(Page page) {
        super(page);
        this.registrationPage = new RegistrationPage(page);
    }

    public RegistrationSteps fillRegistrationForm(
            String fName,
            String lName,
            String country,
            String email,
            String pass
    ) {
        registrationPage.firstName.fill(fName);
        registrationPage.lastName.fill(lName);
        registrationPage.dob.fill("1990-01-01");
        registrationPage.address.fill("Tbilisi Street");
        registrationPage.city.fill("Tbilisi");
        registrationPage.state.fill("Georgia");
        registrationPage.country.selectOption(country);
        registrationPage.postcode.fill("0101");
        registrationPage.phone.fill("555123456");
        registrationPage.email.fill(email);
        registrationPage.password.fill(pass);
        registrationPage.registerBtn.click();
        return this;
    }
}
