package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonPage {

    protected Page page;
    public Locator signIn;
    public Locator menu;
    public Locator logout;
    public Locator categoriesDropdown;
    public Locator handToolsLink;


    public CommonPage(Page page) {
        this.page = page;

        this.signIn = page.locator("a[data-test='nav-sign-in']");
        this.menu = page.locator("a[data-test='nav-menu']");
        this.logout = page.locator("a[data-test='nav-sign-out']");
        this.categoriesDropdown = page.locator("a[data-test='nav-categories']");
        this.handToolsLink = page.locator("a[data-test='nav-hand-tools']");


        }

    }

