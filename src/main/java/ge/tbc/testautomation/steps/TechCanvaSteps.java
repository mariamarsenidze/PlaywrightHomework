package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitUntilState;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.TechCanvaPage;
import io.qameta.allure.Step;

public class TechCanvaSteps {

    private final Page page;
    private final TechCanvaPage techCanvaPage;

    public TechCanvaSteps(Page page) {
        this.page = page;
        this.techCanvaPage = new TechCanvaPage(page);
    }

    @Step("გვერდზე გადასვლა: {Constants.URL}")
    public TechCanvaSteps navigateToTechCanvaPage() {
        page.navigate(Constants.URL, new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.NETWORKIDLE));
        return this;
    }

    @Step("სახელის შეყვანა: {firstName}")
    public TechCanvaSteps fillFirstName(String firstName) {
        techCanvaPage.firstName.fill(firstName);
        return this;
    }

    @Step("გვარის შეყვანა: {lastName}")
    public TechCanvaSteps fillLastName(String lastName) {
        techCanvaPage.lastName.fill(lastName);
        return this;
    }

    @Step("სქესის არჩევა: {gender}")
    public TechCanvaSteps selectGender(String gender){
        if(gender.equalsIgnoreCase(Constants.MALE)) {
            techCanvaPage.maleRadio.click();
        } else if(gender.equalsIgnoreCase(Constants.FEMALE)) {
            techCanvaPage.femaleRadio.click();
        }
        return this;
    }

    @Step("მოდელის არჩევა: {modelValue}")
    public TechCanvaSteps selectModel(String modelValue) {
        techCanvaPage.model.selectOption(new SelectOption().setValue(modelValue));
        return this;
    }

    @Step("პირველი მისამართის შეყვანა: {address1}")
    public TechCanvaSteps fillAddress1(String address1) {
        techCanvaPage.address1.fill(address1);
        return this;
    }

    @Step("მეორე მისამართის შეყვანა: {address2}")
    public TechCanvaSteps fillAddress2(String address2) {
        techCanvaPage.address2.fill(address2);
        return this;
    }

    @Step("ქალაქის მითითება: {city}")
    public TechCanvaSteps fillCity(String city) {
        techCanvaPage.city.fill(city);
        return this;
    }

    @Step("პირველი საკონტაქტო ნომრის შეყვანა: {contact1}")
    public TechCanvaSteps fillContact1(String contact1) {
        techCanvaPage.contact1.fill(contact1);
        return this;
    }

    @Step("მეორე საკონტაქტო ნომრის შეყვანა: {contact2}")
    public TechCanvaSteps fillContact2(String contact2) {
        techCanvaPage.contact2.fill(contact2);
        return this;
    }
}