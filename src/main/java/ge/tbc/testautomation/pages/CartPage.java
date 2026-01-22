package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage {

    protected Page page;

    public Locator productName;
    public Locator quantityInput;
    public Locator unitPrice;
    public Locator totalPrice;
    public Locator checkout;



    public CartPage(Page page) {
        this.page = page;
        this.productName = page.locator("[data-test='product-title']");
        this.quantityInput = page.locator("[data-test='product-quantity']");
        this.unitPrice = page.locator("[data-test='product-price']");
        this.totalPrice = page.locator("[data-test='cart-total']");
        this.checkout = page.locator("[data-test='proceed-1']");


    }
}
