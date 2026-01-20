package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {
    protected Page page;
    public Locator hammerCategory;
    public Locator thorHammer;
    public Locator Tags;


    public ProductPage(Page page) {
        this.page = page;
        this.hammerCategory = page.locator("input[value='01KF7GQJ41TWWS6J328XJRM8KM']");
        this.thorHammer = page.locator("a.card[data-test='product-01KF7GQJ5PPRQE4AT61VGVVSF8']");
        this.Tags = page.locator(".badge.rounded-pill");



    }
}