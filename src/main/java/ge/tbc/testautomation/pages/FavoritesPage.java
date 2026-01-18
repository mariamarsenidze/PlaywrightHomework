package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FavoritesPage {

        protected Page page;
        public Locator deleteBtn;
        public Locator favoriteCard;

        public FavoritesPage(Page page) {
            this.page = page;
            this.deleteBtn = page.locator("[data-test='delete']");
            this.favoriteCard = page.locator(".card.mb-3");
}
}
