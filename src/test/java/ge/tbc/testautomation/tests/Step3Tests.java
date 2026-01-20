package ge.tbc.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static ge.tbc.testautomation.data.Constants.*;

public class Step3Tests extends IsolatedBaseTest {

    @Override
    protected boolean isHeadless() {
        return false;
    }

    @Test(description = "Add product to favourites and verify persistence", priority = 1)
    public void favouritesPersistenceTest() {
        loginSteps.openHomePage();
        String addedProductName = dashboardSteps.addRandomProductToFavourites();

        loginSteps.logout();
        loginSteps.navigateToLogin().login(userEmail, userPassword);

        dashboardSteps.goToFavourites().assertProductInFavourites(addedProductName);
    }

    @Test(description = "Verify filter counts sum logic", priority = 2)
    public void filterTest() {
        loginSteps.openHomePage();
        int handToolsCount = dashboardSteps.selectHandTools().getProductCount();
        int powerToolsCount = dashboardSteps.uncheckHandTools().selectPowerTools().getProductCount();

        int combinedCount = powerToolsCount + handToolsCount;
        Assert.assertEquals(combinedCount, handToolsCount + powerToolsCount, SUM_ERROR);
    }

    @Test(description = "Verify product removal from favorites", priority = 3)
    public void removeProductFromFavouritesTest() {
        loginSteps.openHomePage();
        dashboardSteps.addRandomProductToFavourites();

        dashboardSteps.goToFavourites();
        favoritesSteps.deleteFavorites();

        loginSteps.logout();
        loginSteps.navigateToLogin().login(userEmail, userPassword);
        Assert.assertEquals(favoritesSteps.getFavoritesCount(), 0, FAV_DELETE_ERROR);
    }

    @Test(description = "Verify hammer category and tags", priority = 4)
    public void hammerCategoryTest() {
        loginSteps.openHomePage();
        commonSteps.openCategory();
        productSteps.hammerCategoryClick();
        productSteps.hammerClick();
        productSteps.verifyProductTag(HAMMER_TAG);
    }
}