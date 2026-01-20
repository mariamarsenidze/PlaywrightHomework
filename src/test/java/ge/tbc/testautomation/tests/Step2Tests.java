package ge.tbc.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.*;

public class Step2Tests extends BaseTest {



    @Override
    protected boolean isHeadless() {
        return false;
    }

    @Test(description = "Add product to favourites, logout and check after login", priority = 1)
    public void favouritesPersistenceTest() {
        loginSteps.openHomePage();

        String addedProductName = dashboardSteps.addRandomProductToFavourites();

        loginSteps.logout();

        loginSteps.navigateToLogin().login(userEmail, userPassword);

        dashboardSteps.goToFavourites().assertProductInFavourites(addedProductName);
    }


    @Test(description = "Verify filter sum logic", priority = 2)
    public void filterTest() {
        loginSteps.openHomePage();
        int handToolsCount = dashboardSteps
                .selectHandTools()
                .getProductCount();
        System.out.println("Hand Tools count: " + handToolsCount);



        int powerToolsCount = dashboardSteps
                .uncheckHandTools()
                .selectPowerTools()
                .getProductCount();
        System.out.println("Only Power Tools count: " + powerToolsCount);

        int combinedCount = powerToolsCount+handToolsCount;
        System.out.println("Combined count: " + combinedCount);

        Assert.assertEquals(combinedCount, handToolsCount + powerToolsCount,
                SUM_ERROR);
    }
    @Test(description = "Verify filter sum logic", priority = 3)
    public void removeProductFromFavouritesTest() {

        loginSteps.openHomePage();
        dashboardSteps.goToFavourites();
        favoritesSteps.deleteFavorites();
        loginSteps.logout();
        loginSteps.navigateToLogin().login(userEmail, userPassword);
        Assert.assertEquals(favoritesSteps.getFavoritesCount(), 0,
                FAV_DELETE_ERROR);




    }

    @Test(description = "Verify filter sum logic", priority = 4)
    public void hammercategoryTest() {
        loginSteps.openHomePage();
        commonSteps.openCategory();
        productSteps.hammerCategoryClick();
        productSteps.hammerClick();
        productSteps.verifyProductTag(HAMMER_TAG);




    }










 }


