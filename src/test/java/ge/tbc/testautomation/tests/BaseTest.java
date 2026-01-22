package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.pages.CommonPage;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected HomeSteps homeSteps;
    protected ProductSteps productSteps;
    protected CommonSteps commonSteps;
    protected CartSteps cartSteps;
    protected CheckoutSteps checkoutSteps;
    protected LoginSteps loginSteps;
    protected RegistrationSteps registrationSteps;
    protected ForgotPasswordSteps forgotSteps;
    protected ContactSteps contactSteps;


    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(1200)
        );

        context = browser.newContext();
        page = context.newPage();

        homeSteps = new HomeSteps(page);
        productSteps = new ProductSteps(page);
        commonSteps = new CommonSteps(page);
        cartSteps = new CartSteps(page);
        checkoutSteps = new CheckoutSteps(page);
        loginSteps = new LoginSteps(page);
        registrationSteps = new RegistrationSteps(page);
        forgotSteps = new ForgotPasswordSteps(page);
        contactSteps = new ContactSteps(page);


    }

    @AfterClass
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
