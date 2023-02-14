package Pages;

public class JobPage extends BasePage {
    private static final String LOCATION_BOX = "//input[@placeholder='location']";
    private static final String SEARCH_BUTTON = "//button[text()='search']";
    private static final String LIST_DISPLAYED = "//li[@class = 'entry-content']";
    private static final String LIST_EMPTY = "//span[@class='boom']";
    private static final String POSITION_BOX = "//input[@placeholder='position']";
    private static final String POSITION_LIST = "//li[@class = 'entry-content']";
    private static final String COMPANY_BOX = "//input[@placeholder = 'company']";
    private static final String COMPANY_LIST = "//li[@class = 'entry-content']";
    private static final String ERROR_MESSAGE= "//span[@class='boom']";
    private static final String RESET_BUTTON = "//button[text()='reset']";
    private static final String VERIFY_RESET = "//span[text() ='26051']";

    public boolean searchForLocation(String location) {
        findElementByXpath(LOCATION_BOX).sendKeys(location);
        findElementByXpath(SEARCH_BUTTON).click();
        return elementExists(LIST_DISPLAYED);
    }


    public boolean searchForNegativeLocation(String location) {
        findElementByXpath(LOCATION_BOX).sendKeys(location);
        findElementByXpath(SEARCH_BUTTON).click();
        return elementExists(LIST_EMPTY);
    }

    public boolean searchForPosition (String position){
        findElementByXpath(POSITION_BOX).sendKeys(position);
        findElementByXpath(SEARCH_BUTTON).click();
        return elementExists(POSITION_LIST);
    }

    public boolean searchForCompany (String company){
        findElementByXpath(COMPANY_BOX).sendKeys(company);
        findElementByXpath(SEARCH_BUTTON).click();
        return elementExists(COMPANY_LIST);
    }

    public boolean combinedSearch (){
        findElementByXpath(POSITION_BOX).sendKeys("Manager");
        findElementByXpath(COMPANY_BOX).sendKeys("Google");
        findElementByXpath(LOCATION_BOX).sendKeys("USA");
        return elementExists(COMPANY_LIST);
    }

    public boolean negativeSearchForPosition (){
        findElementByXpath(POSITION_BOX).sendKeys("abracadabra");
        findElementByXpath(SEARCH_BUTTON).click();
        return elementExists(ERROR_MESSAGE);
    }

    public boolean resetButtons (){
        findElementByXpath(RESET_BUTTON).click();
        return elementExists(VERIFY_RESET);
    }

}
