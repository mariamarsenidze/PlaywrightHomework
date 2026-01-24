package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TechCanvaPage {

    public final Locator
            firstName,
            lastName,
            address1,
            address2,
            city,
            contact1,
            contact2,
            maleRadio,
            femaleRadio,
            model,
    clickButton;



    private final Page page;

    public TechCanvaPage(Page page) {
        this.page = page;
        this.firstName = page.locator("input[value='First Name']");
        this.lastName = page.locator("input[value='Last Name']");
        this.maleRadio = page.locator("input[value='male']");
        this.femaleRadio = page.locator("input[value='female']");
        this.model = page.locator("select[name='model']");
        this.address1 = page.locator("input[value='Address1']");
        this.address2 = page.locator("input[value='Address2']");
        this.city = page.locator("input[value='City']");
        this.contact1 = page.locator("input[value='Contact1']");
        this.contact2 = page.locator("input[value='Contact2']");
        this.clickButton = page.locator("input[value='Register']");

    }
}