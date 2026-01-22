package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.RegistrationPage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegistrationSteps  {
    private final Page page;
    private final RegistrationPage registrationPage;

    public RegistrationSteps(Page page) {
        this.page = page;

        this.registrationPage = new RegistrationPage(page);
    }

    public RegistrationSteps fillInvalidRegistrationForm(
            String fName,
            String lName,
            String birthDate,
            String street,
            String postcode,
            String city,
            String state,
            String phone,
            String country,
            String email,
            String pass
    ) {
        registrationPage.firstName.fill(fName);
        registrationPage.lastName.fill(lName);
        registrationPage.dob.fill(birthDate);
        registrationPage.address.fill(street);
        registrationPage.postcode.fill(postcode);
        registrationPage.city.fill(city);
        registrationPage.state.fill(state);
        registrationPage.country.selectOption(country);
        registrationPage.phone.fill(phone);
        registrationPage.email.fill(email);
        registrationPage.password.fill(pass);
        return this;
    }
    public RegistrationSteps verifyErrorsExist(){
        registrationPage.emailError.isVisible();
        registrationPage.passwordError.isVisible();
        return  this;

    }


    public RegistrationSteps fillValidRegistrationForm(
            String fName,
            String lName,
            String birthDate,
            String street,
            String postcode,
            String city,
            String state,
            String phone,
            String country,
            String email,
            String pass
    ) {
        registrationPage.firstName.fill(fName);
        registrationPage.lastName.fill(lName);
        registrationPage.dob.fill(birthDate);
        registrationPage.address.fill(street);
        registrationPage.postcode.fill(postcode);
        registrationPage.city.fill(city);
        registrationPage.state.fill(state);
        registrationPage.country.selectOption(country);
        registrationPage.phone.fill(phone);
        registrationPage.email.fill(email);
        registrationPage.password.fill(pass);
        return this;
    }
    public RegistrationSteps submitRegistrationForm() {
        registrationPage.registerBtn.click();
        assertThat(page).hasURL(Pattern.compile(Constants.LOGIN_URL));
        return this;
    }

}