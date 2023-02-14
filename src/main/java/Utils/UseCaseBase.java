package Utils;

import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.logging.Level;


public class UseCaseBase {
    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setUpHome() {
        page = new BasePage();
        webDriver = SharedDriver.getWebDriver(SharedDriver.Browser.CHROME);
        page.setWebDriver(webDriver);
    }

    @AfterEach
    public void logTest (){
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entries.getAll();
        for (LogEntry e : logs) {
            System.out.println("Message : " + e.getMessage());
            System.out.println("Level : " + e.getLevel());
            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());}
    }

    @AfterAll
    public static void tearDownHome() {
        SharedDriver.closeDriver();
        webDriver = null;
    }

    }

