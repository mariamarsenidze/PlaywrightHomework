
package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.*;


public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    HomeSteps homeSteps;
    ContactSteps contactSteps;



    @BeforeClass
    @Parameters("browserType")
    public void initializeSteps(@Optional("chromium") String browserType){
        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);

        if (browserType.equalsIgnoreCase("webkit")){
            browser = playwright.webkit().launch(launchOptions);
        } else if (browserType.equalsIgnoreCase("chrome")) {
            browser = playwright.chromium().launch(launchOptions);
        }

        context = browser.newContext();
        page = context.newPage();
        homeSteps = new HomeSteps(page);
        contactSteps = new ContactSteps(page);

    }

    @AfterClass
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }
}
