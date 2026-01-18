package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class IsolatedBaseTest {
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

    protected String userEmail;
    protected final String userPassword = "Passw0rd!2026$MyUnique!";

    protected abstract boolean isHeadless();

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(isHeadless())
                        .setSlowMo(1000)
        );

        context = browser.newContext();
        page = context.newPage();

        loginSteps = new LoginSteps(page);
        registrationSteps = new RegistrationSteps(page);
        dashboardSteps = new DashboardSteps(page);
        favoritesSteps = new FavoritesSteps(page);
        productSteps = new ProductSteps(page);
        commonSteps = new CommonSteps(page);

        userEmail = "isolated_user_" + System.nanoTime() + "@gmail.com";

        commonSteps.openHomePage();
        loginSteps.navigateToLogin().goToRegistration();
        registrationSteps.fillRegistrationForm("Isolated", "User", "Georgia", userEmail, userPassword);
        loginSteps.login(userEmail, userPassword);
    }

    @AfterMethod
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}