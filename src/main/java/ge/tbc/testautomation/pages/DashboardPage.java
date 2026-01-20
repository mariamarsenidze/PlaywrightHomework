package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage extends CommonPage {
    public Locator productCard;
    public Locator productName;
    public Locator addToFavouritesBtn;
    public Locator favouritesLink;
    public Locator handToolsCheckbox;
    public Locator powerToolsCheckbox;
    public Locator allProducts;
    public Locator hammerCategory;


    public DashboardPage(Page page) {
        super(page);
        this.productCard = page.locator("a.card");
        this.productName = page.locator("[data-test='product-name']");
        this.addToFavouritesBtn = page.locator("[data-test='add-to-favorites']");
        this.favouritesLink = page.locator("a[data-test='nav-my-favorites']");
        this.handToolsCheckbox = page.locator("label:has-text('Hand Tools')");
        this.powerToolsCheckbox = page.locator("label:has-text('Power Tools')");
        this.allProducts = page.locator(".card");

    }
}
