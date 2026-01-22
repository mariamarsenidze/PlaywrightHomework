package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    protected Page page;
    public Locator products;
    public Locator filter;
    public Locator sort;
    public Locator pagination;
    public Locator search;
    public Locator searchBtn;
    public Locator productTitle;
    public  Locator category;
    public  Locator brand;




    public HomePage(Page page) {
        this.page = page;
        this.products = page.locator(".card");
        this.sort = page.locator("[data-test='sort']");
        this.filter = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Filters"));
        this.pagination = page.locator("ul.pagination");
        this.search = page.locator("[data-test='search-query']");
        this.searchBtn = page.locator("button[data-test='search-submit']");
        this.productTitle = page.locator("[data-test='product-name']");
        this.category = page.locator("label:has-text('Hand Tools')");
        this.brand = page.locator("label:has-text('ForgeFlex Tools')");






} }
