package Pages;

public class AboutUsPage extends BasePage {
    private static final String ABOUT_US_LOGO = "//a[@name = 'About Us']";

    public boolean isAboutUsLogoVisible() {
        return elementExists(ABOUT_US_LOGO);
    }

}
