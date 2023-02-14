package Pages;

import Consts.Consts;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_LOGO = "//img[@class = 'img-fluid']";
    private static final String ABOUT_US = "//a[@name = 'About Us']";
    private static final String FIND_JOB = "//a[@name = 'Find Job']";


    public void navigateToHomePage (){
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isLogoVisible (){
        boolean isVisible = elementExists(HOME_PAGE_LOGO);
        return isVisible;
    }

    public AboutUsPage openAboutUs (){
     clickElementByXpath(ABOUT_US);
     return new AboutUsPage();}

    public JobPage openFindJobPage (){
        clickElementByXpath(FIND_JOB);
        return new JobPage();
    }
}
