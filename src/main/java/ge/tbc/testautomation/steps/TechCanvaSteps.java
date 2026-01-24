package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitUntilState;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.TechCanvaPage;

public class TechCanvaSteps {

    private final Page page;
    private final TechCanvaPage techCanvaPage;

    public TechCanvaSteps(Page page) {
        this.page = page;
        this.techCanvaPage = new TechCanvaPage(page);
    }
    public TechCanvaSteps navigateToTechCanvaPage() {
        page.navigate(Constants.URL, new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.NETWORKIDLE));

                return this;
    }

    public TechCanvaSteps fillFirstName(String firstName) {
        techCanvaPage.firstName.fill(firstName);
        return this;
    }

    public TechCanvaSteps fillLastName(String lastName) {
        techCanvaPage.lastName.fill(lastName);
        return this;
    }

    public TechCanvaSteps selectGender(String gender){
        if(gender.equalsIgnoreCase(Constants.MALE)) {
            techCanvaPage.maleRadio.click();
        } else if(gender.equalsIgnoreCase(Constants.FEMALE)) {
            techCanvaPage.femaleRadio.click();
        }
        return this;
    }


    public TechCanvaSteps selectModel(String modelValue) {
        techCanvaPage.model.selectOption(new SelectOption().setValue(modelValue));
        return this;
    }

    public TechCanvaSteps fillAddress1(String address1) {
        techCanvaPage.address1.fill(address1);
        return this;
    }

    public TechCanvaSteps fillAddress2(String address2) {
        techCanvaPage.address2.fill(address2);
        return this;
    }

    public TechCanvaSteps fillCity(String city) {
        techCanvaPage.city.fill(city);
        return this;
    }

    public TechCanvaSteps fillContact1(String contact1) {
        techCanvaPage.contact1.fill(contact1);
        return this;
    }

    public TechCanvaSteps fillContact2(String contact2) {
        techCanvaPage.contact2.fill(contact2);
        return this;
    }
}
