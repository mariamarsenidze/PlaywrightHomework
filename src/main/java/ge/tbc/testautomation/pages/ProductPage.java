package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {

    protected Page page;
    public Locator productName;
    public Locator unitPrice;
    public Locator description;
    public Locator co2Rating;
    public Locator quantityInput;
    public Locator increaseQtyBtn;
    public Locator addToCartBtn;
    public Locator toastMessage;
    public Locator cartBadge;
    public Locator favoritesBtn;


    public ProductPage(Page page) {
        this.page = page;
        this.productName = page.locator("[data-test='product-name']");
        this.unitPrice = page.locator("[data-test='unit-price']");
        this.description = page.locator("[data-test='product-description']");
        this.co2Rating = page.locator("[data-test='co2-rating-badge']");
        this.quantityInput = page.locator("[data-test='quantity']");
        this.increaseQtyBtn = page.locator("[data-test='increase-quantity']");
        this.addToCartBtn= page.locator("[data-test='add-to-cart']");
        this.toastMessage = page.locator("#toast-container .toast-message");
        this.cartBadge = page.locator("[data-test='cart-quantity']");
        this.favoritesBtn = page.locator("[data-test='add-to-favorites']");


    }
}
