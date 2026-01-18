package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected LoginSteps loginSteps;
    protected RegistrationSteps registrationSteps;
    protected DashboardSteps dashboardSteps;
    protected FavoritesSteps favoritesSteps;
    protected ProductSteps productSteps;
    protected CommonSteps commonSteps;

    protected final String userEmail =
            "testuser_" + System.currentTimeMillis() + "@gmail.com";
    protected final String userPassword =
            "Passw0rd!2026$MyUnique!";

    protected abstract boolean isHeadless();

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(isHeadless())
                        .setSlowMo(1500)
        );

        context = browser.newContext();
        page = context.newPage();

        loginSteps = new LoginSteps(page);
        registrationSteps = new RegistrationSteps(page);
        dashboardSteps = new DashboardSteps(page);
        favoritesSteps = new FavoritesSteps(page);
        productSteps = new ProductSteps(page);
        commonSteps = new CommonSteps(page);

        commonSteps.openHomePage();

        loginSteps
                .navigateToLogin()
                .goToRegistration();

        registrationSteps.fillRegistrationForm(
                "Test",
                "User",
                "Georgia",
                userEmail,
                userPassword
        );

        loginSteps.login(userEmail, userPassword);
    }

    @AfterClass
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
