package ge.tbc.testautomation.pages;

import com.microsoft.playwright.*;


    public class HomePage {
        protected Page page;
        public  Locator logo;
        public Locator footerEmail;
        public FrameLocator shopFrame;
        public Locator contactUs;

        public HomePage(Page page) {
            this.page = page;
            this.shopFrame = page.frameLocator("#framelive");
            this.logo = shopFrame.locator("#_desktop_logo");
            this.footerEmail = shopFrame.locator("footer a[href^='mailto:']");
            this.contactUs = shopFrame.locator("#contact-link");

        }
    }
