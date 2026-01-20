package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.FavoritesPage;

public class FavoritesSteps {



        protected Page page;
        protected FavoritesPage favoritesPage;

        public FavoritesSteps(Page page) {
            this.page = page;
            this.favoritesPage = new FavoritesPage(page);
        }


        public FavoritesSteps deleteFavorites(){
            favoritesPage.deleteBtn.click();
            return this;
        }

    public int getFavoritesCount() {
        page.waitForTimeout(1000);
        return favoritesPage.favoriteCard.count();
}
}
