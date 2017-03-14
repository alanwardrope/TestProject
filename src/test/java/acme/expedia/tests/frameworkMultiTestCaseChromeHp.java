package acme.expedia.tests;

import acme.expedia.framework.pages.MainMenuFactoryHp;
import acme.expedia.framework.pages.SearchPageFactoryHp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by vanwh on 23/02/2017.
 */
public class frameworkMultiTestCaseChromeHp {

    private WebDriver driver;
    private String baseUrl;
    private String baseUrl2;
    SearchPageFactoryHp searchPage;
    MainMenuFactoryHp menuSelect;


    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("*** BEFORE CLASS CALLED");
        // For Chrome Add Options
        // C:\\users\\vanw\\AppData\\Local\\Google\\Chrome\\User Data\\Default\Extensions\<extension_id>\version_num.crx\
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\vanwh\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ecnphlgnajanjnkcmbpancdjoidceilk\\2.0.8563_0.crx"));
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com";
        searchPage = new SearchPageFactoryHp(driver);
        menuSelect = new MainMenuFactoryHp(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test(groups = {"smoke", "regression"})
    public void test1() {
        /*
        */
        System.out.println("AM I HERE");
        menuSelect.clearHeadersOnStartUp();
        System.out.println("AM I HERE NOW");
        //wait(10000);

        searchPage.getWhenVisible(By.id("tab-flight-tab-hp"), 20);

        searchPage.clickFlightsTab();

        // Rotate through the trip buttons
        searchPage.selectOneWayTripButton();
        searchPage.selectMultiDestButton();
        searchPage.selectReturnTripButton();

        // Now enter values for flight
        searchPage.setOriginatingCity("New York");
        searchPage.setDestinationCity("Chicago");
        // Hp site - Cannot enter dates into the input field - needs rework
        //searchPage.setDepartureDate("18/03/2017");
        //searchPage.clearAndSetReturnDate("25/03/2017");

        //Note once you enter a dept date when you select the rtn date field it automaticall populates it with the next day
        //String aDate = searchPage.getReturnDate()
        //System.out.println("The date returned is " + aDate);
        //searchPage.setReturnDate("25/03/2017");

    }

    @Test(groups = {"regression"})
    public void test2(){
        // Now select number of adults and children
        searchPage.setNumberOfAdultsDropdown(2);
        //searchPage.getNumAdultsDropdown();
        searchPage.setNumberOfChildrenDropdown("2");
        //searchPage.numAdultsDropdown.selectByIndex(2);
        //searchPage.numChildrenDropdown.selectByVisibleText("6");

        // Validate the number of Child Labels to be displayed, enter the expected number
        if (searchPage.validateChildLabelsDisplayed(driver, 2))
        { System.out.println("Childrens Ages can be set as expected"); } else {
            System.out.println("Some form of error - maybe add an assert here");
        }

        // Set the Age of a Child Label Dropdown
        searchPage.setAgeOfChildOneDropdown(1);

        // Validate if the Child Age Limit section is displayed, enter expected status true/false based on Child Age selection above
        if (searchPage.validateChildAgeLimitSection(driver, true )){
            System.out.println("The Age Limit section is displayed as expected");
        }else {
            System.out.println("Some form of error - maybe add an assert here");
        }


        if (searchPage.validateInLapRBText().equals("In lap")){
            System.out.println("In Lap label is correct " + searchPage.validateInLapRBText());
        }else {
            System.out.println("In Lap label is incorrect " + searchPage.validateInLapRBText());
        }

        if (searchPage.validateInSeatRBText().equals("In Seat")){
            System.out.println("In Seat label is correct " + searchPage.validateInSeatRBText());
        }else {
            System.out.println("In Seat label is incorrect " + searchPage.validateInSeatRBText());
        }

    }

    @Test(groups = {"regression"})
    public void test3(){
        // Advanced Options section
        searchPage.selectAdvancedOptionsLink();

        searchPage.checkDirectFlight();
        searchPage.checkDirectFlight();
        searchPage.uncheckDirectFlight();
        searchPage.uncheckDirectFlight();
        searchPage.checkDirectFlight();

        searchPage.checkRefundFlight();
        searchPage.checkRefundFlight();
        searchPage.uncheckRefundFlight();
        searchPage.uncheckRefundFlight();
        searchPage.checkRefundFlight();

        searchPage.setPreferredAirlineDropdown(20);
        searchPage.setPreferredClassDropdown("business");

        searchPage.checkAddCar();
        searchPage.checkAddCar();
        searchPage.uncheckAddCar();
        searchPage.uncheckAddCar();
        //searchPage.checkAddCar();

        searchPage.checkDriverAge();
        searchPage.checkDriverAge();
        searchPage.uncheckDriverAge();
        searchPage.uncheckDriverAge();
        //searchPage.checkDriverAge();

        // Hp site - Selecting CheckDriverAge does not display the driver Age section
        //searchPage.selectDriverAgeHelpInfo();

        /*
        if (searchPage.checkFlightOptionButtonsDisabled()){
            System.out.println("The flight option buttons are disabled select the Help Icon");
            searchPage.selectFlightTypeHelpInfo();
        }else {
            System.out.println("The The flight option buttons are enabled select one if required");
        // The following options should be non-selectable as we have selected Add A Car
        //searchPage.checkButtonStatus(searchPage.oneWayTripButton);
        //searchPage.checkButtonStatus(searchPage.multiDestTripButton);
        //searchPage.checkButtonStatus(searchPage.returnTripButton);
        };
        */

        searchPage.checkHotelCheckbox();
        searchPage.checkHotelCheckbox();
        searchPage.uncheckHotelCheckbox();
        searchPage.uncheckHotelCheckbox();
        //searchPage.checkHotelCheckbox();

        // Print all the names associated with the <a> links on the page.
        // Will also display blanks where no name is specified
        //utils pagelist = new utils();
        //pagelist.UrlList(driver);
        //searchPage.getDataContentForHelpInfo(driver);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println("*** AFTER CLASS CALLED");
        driver.quit();
    }
}
