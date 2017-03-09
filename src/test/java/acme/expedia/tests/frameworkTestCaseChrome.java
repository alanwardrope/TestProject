package acme.expedia.tests;

import acme.expedia.framework.pages.SearchPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.io.File;

/**
 * Created by vanwh on 23/02/2017.
 */
public class frameworkTestCaseChrome {

    private WebDriver driver;
    private String baseUrl;
    private String baseUrl2;
    SearchPageFactory searchPage;


    @BeforeClass
    public void beforeClass(){

        // For Chrome Add Options
        // C:\\users\\vanw\\AppData\\Local\\Google\\Chrome\\User Data\\Default\Extensions\<extension_id>\version_num.crx\
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\vanwh\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ecnphlgnajanjnkcmbpancdjoidceilk\\2.0.8563_0.crx"));
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com";
        //baseUrl2 = "https://www.expedia.co.uk";
        baseUrl2 = "https://www.expedia.co.uk/?rfrr=Redirect.From.www.expedia.com%2F";
        searchPage = new SearchPageFactory(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() {
        /*
        */
        System.out.println("AM I HERE");
        searchPage.clearHeadersOnStartUp();
        System.out.println("AM I HERE NOW");
        //wait(10000);

        searchPage.getWhenVisible(By.id("tab-flight-tab"), 20);

        searchPage.clickFlightsTab();

        // Rotate through the trip buttons
        searchPage.selectOneWayTripButton();
        searchPage.selectMultiDestButton();
        searchPage.selectReturnTripButton();

        // Now enter values for flight
        searchPage.setOriginatingCity("New York");
        searchPage.setDestinationCity("Chicago");
        searchPage.setDepartureDate("18/03/2017");
        searchPage.clearAndSetReturnDate("25/03/2017");
        //Note once you enter a dept date when you select the rtn date field it automaticall populates it with the next day
        //String aDate = searchPage.getReturnDate()
        //System.out.println("The date returned is " + aDate);
        //searchPage.setReturnDate("25/03/2017");


        // Now select number of adults and children
        searchPage.setNumberOfAdultsDropdown(2);
        //searchPage.getNumAdultsDropdown();
        searchPage.setNumberOfChildrenDropdown("2");
        //searchPage.numAdultsDropdown.selectByIndex(2);
        //searchPage.numChildrenDropdown.selectByVisibleText("6");

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
        searchPage.checkAddCar();

        searchPage.checkDriverAge();
        searchPage.checkDriverAge();
        searchPage.uncheckDriverAge();
        searchPage.uncheckDriverAge();
        searchPage.checkDriverAge();

        searchPage.selectDriverAgeHelpInfo();

        searchPage.selectFlightTypeHelpInfo();

        // The following options should be non-selectable as we have selected Add A Car
        searchPage.checkButtonStatus(searchPage.oneWayTripButton);
        searchPage.checkButtonStatus(searchPage.multiDestTripButton);
        searchPage.checkButtonStatus(searchPage.returnTripButton);


    }


    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
}
