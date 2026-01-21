package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonPage {

    protected Page page;
    public Locator menu;
    public Locator signIn;
    public Locator cart;
    public Locator home;
    public Locator logoutBtn;
    public Locator signInBtn;
    public Locator contactBtn;







    public CommonPage(Page page) {
        this.page = page;

        this.signIn = page.locator("a[data-test='nav-sign-in']");
        this.cart = page.locator("a[data-test='nav-cart']");
        this.menu = page.locator("[data-test='nav-menu']");
        this.home = page.locator("[data-test='nav-home']");
        this.logoutBtn = page.locator("a[data-test='nav-sign-out']");
        this.signInBtn = page.locator("a[data-test='nav-sign-in']");
        this.contactBtn = page.locator("a[data-test='nav-contact']");









    }}