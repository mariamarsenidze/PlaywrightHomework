package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import org.testng.annotations.Test;

public class RegisterAndLoginTest extends BaseTest {
    private final String firstName = "Maria";
    private final String uniqueEmail = "user" + System.currentTimeMillis() + "@example.com";
    private final String password = "Passw0rd!2026$MyUnique!";

    @Test(priority = 1, description = "მთავარ გვერდზე გადასვლა და ავტორიზაციის გახსნა")
    void HomePage() {
        homeSteps
                .openHomePage(Constants.BASE_URL);
        commonSteps.openSignInPage();
    }

    @Test(priority = 2, description = "რეგისტრაციის გვერდზე გადასვლა")
    void startRegister() {
        loginSteps.goToRegistration();
    }

    @Test(priority = 3, description = "რეგისტრაცია არასწორი მონაცემებით და შეცდომების ვალიდაცია")
    void invalidInfo() {
        registrationSteps
                .fillInvalidRegistrationForm(
                        "John",
                        "Doe",
                        "1999-08-08",
                        "Chavchavadze",
                        "0101",
                        "Tbilisi",
                        "Tbilisi",
                        "555555555",
                        "Georgia",
                        "bla.bla",
                        "bla")
                .verifyErrorsExist();
    }

    @Test(priority = 4, description = "რეგისტრაციის ფორმის შევსება ვალიდური მონაცემებით")
    void registerWithValidInfo() {
        registrationSteps
                .fillValidRegistrationForm(
                        firstName,
                        "Gilbert",
                        "2000-09-10",
                        "Dadiani",
                        "0101",
                        "Batumi",
                        "Georgia",
                        "599999999",
                        "Georgia",
                        uniqueEmail,
                        password);
    }

    @Test(priority = 5, description = "რეგისტრაციის დასრულება")
    void registerAndVerify() {
        registrationSteps.submitRegistrationForm();
    }

    @Test(priority = 6, description = "ავტორიზაცია ახლად შექმნილი მომხმარებლით")
    void loginWithAccount() {
        loginSteps.login(uniqueEmail, password);
        commonSteps.verifyLogin(firstName);
    }

    @Test(priority = 7, description = "პროდუქტის რჩეულებში დამატება და შემოწმება")
    void productSelect() {
        commonSteps.openHomePage();
        homeSteps.selectProduct();
        productSteps.favorites();
        productSteps.verifyFavorites();
    }

    @Test(priority = 8, description = "სისტემიდან გამოსვლა (Logout)")
    void logOut() {
        commonSteps.logOut();
    }

    @Test(priority = 9, description = "პაროლის აღდგენის გვერდზე გადასვლა")
    void ForgotPassword() {
        commonSteps.signIn();
        loginSteps.clickForgotPassword();
    }

    @Test(priority = 10, description = "პაროლის აღდგენის მოთხოვნის გაგზავნა")
    void resetPassword() {
        forgotSteps.submitForgotPassword(uniqueEmail);
    }
}