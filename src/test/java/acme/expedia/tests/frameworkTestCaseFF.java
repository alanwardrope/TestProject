package acme.expedia.tests;

import acme.expedia.framework.pages.SearchPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by vanwh on 23/02/2017.
 */
public class frameworkTestCaseFF {

    private WebDriver driver;
    private String baseUrl;
    SearchPageFactory searchPage;

    // New profile
    // C:\\users\\vanw\\AppData\\Roaming\\Mozilla\\Roaming\\Profiles\\omm1901.seleniumtest
    // ProfilesIni profile = new ProfilesIni();
    // FirefoxProfile fxProfile = profile.getProfile("seleniumtest");


    @BeforeClass
    public void beforeClass(){

        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile fxProfile = profile.getProfile("seleniumtest");

        driver = new FirefoxDriver(fxProfile);
        baseUrl = "https://www.expedia.com";

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
        searchPage.clickFlightsTab();

        searchPage.setOriginatingCity("New York");
        searchPage.setDestinationCity("Chicago");
        searchPage.setDepartureDate("18/03/2017");
        searchPage.selectReturnDateField();

        //Note once you enter a dept date when you select the rtn date field it automaticall populates it with the next day
        //String aDate = searchPage.getReturnDate();
        //System.out.println("The date returned is " + aDate);

        //searchPage.setReturnDate("25/03/2017");
    }

    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
}
