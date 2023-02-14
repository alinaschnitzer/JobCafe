import Pages.AboutUsPage;
import Pages.HomePage;
import Pages.JobPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.logging.Level;

public class HomePageTest extends UseCaseBase {

    private static HomePage homePage;
//    private static final String LOCATION_BOX = "//input[@placeholder='location']";

    @BeforeAll
    public static void classSetUp (){
        homePage = new HomePage();
    }
    @BeforeEach
    public void beforeTest (){
        homePage.navigateToHomePage();
    }



    @Test
    public void homePageLoadTest (){
        boolean success = homePage.isLogoVisible();
        assertTrue(success);
    }

    @Test
    public void aboutUsLoadTest (){
        AboutUsPage aboutUsPage = homePage.openAboutUs();
        boolean isLoaded = aboutUsPage.isAboutUsLogoVisible();
        assertTrue(isLoaded);
    }
    @ParameterizedTest
    @ValueSource (strings = {"Toronto", "Chicago"})
    public void searchLocationBoxTest (String locationInput) throws InterruptedException {
        JobPage jobPage = homePage.openFindJobPage();
       boolean isListVisible= jobPage.searchForLocation(locationInput);
        Thread.sleep(2000);
        assertTrue(isListVisible);
    }

    @ParameterizedTest
    @ValueSource (strings = {"Tel-Aviv", "New-York"})
    public void negativeSearchLocationBox (String locationInput) throws InterruptedException {
        JobPage jobPage = homePage.openFindJobPage();
       boolean isListVisible=  jobPage.searchForNegativeLocation(locationInput);
        Thread.sleep(2000);
        assertTrue(isListVisible);
    }

    @ParameterizedTest
    @ValueSource(strings = {"QA", "Developer", "Project Manager"})
    public void searchForPositionTest (String positionInput) throws InterruptedException{
        JobPage jobPage= homePage.openFindJobPage();
        boolean isListVisible = jobPage.searchForPosition(positionInput);
        Thread.sleep(2000);
        assertTrue(isListVisible);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Apple", "Facebook", "Google"})
    public void searchForCompanyTest (String companyInput) throws InterruptedException{
        JobPage jobPage = homePage.openFindJobPage();
        boolean isListVisible = jobPage.searchForCompany(companyInput);
        Thread.sleep(2000);
        assertTrue(isListVisible);
    }

    @Test
    public void combinedSearchTest ()throws InterruptedException{
        JobPage jobPage = homePage.openFindJobPage();
        boolean isListVisible = jobPage.combinedSearch();
        Thread.sleep(2000);
        assertTrue(isListVisible);
    }

    @Test
    public void negativeSearchForPosition ()throws InterruptedException{
        JobPage jobPage = homePage.openFindJobPage();
        boolean isErrorMessageVisible = jobPage.negativeSearchForPosition();
        Thread.sleep(2000);
        assertTrue(isErrorMessageVisible);
    }

    @Test
    public void resetTest ()throws InterruptedException{
        JobPage jobPage = homePage.openFindJobPage();
        boolean isPageReset = jobPage.resetButtons();
        Thread.sleep(2000);
        assertTrue(isPageReset);
    }

}
