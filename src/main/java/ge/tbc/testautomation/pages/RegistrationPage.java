
package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegistrationPage {

    public Locator firstName;
    public Locator lastName;
    public Locator dob;
    public Locator address;
    public Locator city;
    public Locator state;
    public Locator country;
    public Locator postcode;
    public Locator phone;
    public Locator email;
    public Locator password;
    public Locator registerBtn;
    public Locator emailError;
    public Locator passwordError;


    public RegistrationPage(Page page) {
        firstName = page.locator("#first_name");
        lastName = page.locator("#last_name");
        dob = page.locator("#dob");
        address = page.locator("input[data-test='street']");
        city = page.locator("input[data-test='city']");
        state = page.locator("input[data-test='state']");
        country = page.locator("select[data-test='country']");
        postcode = page.locator("input[data-test='postal_code']");
        phone = page.locator("input[data-test='phone']");
        email = page.locator("input[data-test='email']");
        password = page.locator("input[data-test='password']");
        registerBtn = page.locator("button[type='submit']");
        emailError = page.locator("[data-test='email-error']");
        passwordError = page.locator("[data-test='password-error']");




    }
}
