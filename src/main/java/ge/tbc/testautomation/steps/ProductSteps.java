package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ProductPage;

import java.util.List;

public class ProductSteps {
    protected Page page;
    protected ProductPage productPage;

    public ProductSteps(Page page) {
        this.page = page;
        this.productPage = new ProductPage(page);
    }

    public ProductSteps hammerCategoryClick() {
        productPage.hammerCategory.click();
        return this;
    }

    public ProductSteps hammerClick() {
        productPage.thorHammer.click();
        return this;
    }

    public void verifyProductTag(String expectedTag) {
        List<String> actualTags = productPage.Tags.allTextContents();
        org.testng.Assert.assertTrue(actualTags.contains(expectedTag),
                "თეგი '" + expectedTag + "' ვერ მოიძებნა! ნაპოვნი თეგებია: " + actualTags);
    }
}