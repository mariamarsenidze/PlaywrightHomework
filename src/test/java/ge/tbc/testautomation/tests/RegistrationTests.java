package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.RegistrationData;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test(dataProvider = "registrationData", dataProviderClass = RegistrationData.class)
    public void fillRegistrationForm(
            String firstName,
            String lastName,
            String gender,
            String model,
            String address1,
            String address2,
            String city,
            String contact1,
            String contact2
    ) {

        techCanvaSteps
                .navigateToTechCanvaPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .selectGender(gender)
                .selectModel(model)
                .fillAddress1(address1)
                .fillAddress2(address2)
                .fillCity(city)
                .fillContact1(contact1)
                .fillContact2(contact2);
    }
}
