package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.CommonPage;


public class CommonSteps {

    protected Page page;
    protected CommonPage commonPage;

    public CommonSteps(Page page) {
        this.page = page;
        this.commonPage = new CommonPage(page);
    }

    public CommonSteps openHomePage() {
        page.navigate(Constants.URL);
        return this;
    }
    public CommonSteps logout() {
        commonPage.menu.waitFor();
        commonPage.menu.click();
        commonPage.logout.waitFor();
        commonPage.logout.click();
        return this;
    }
    public CommonSteps openCategory() {
        commonPage.menu.click();
        commonPage.categoriesDropdown.click();
        commonPage.handToolsLink.click();
        return this;


    }
}