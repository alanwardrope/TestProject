package acme.expedia.tests;

import acme.expedia.framework.common.SshConnector;
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
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

/**
 * Created by vanwh on 23/02/2017.
 */
public class SshConnTestCaseChromeHp {

    private WebDriver driver;
    private String baseUrl;
    private String baseUrl2;
    SearchPageFactoryHp searchPage;
    MainMenuFactoryHp menuSelect;
    SshConnector sshc;

    // DB Connection Parameters
    static Connection conn = null;
    // Statement object
    private static Statement stmt;
    // Result Set
    private static ResultSet results = null;
    // Constant for Database URL
    public static String SSH_HOST = "ald-eqc-sys-esb";
    // Constant for server name
    public static String SSH_USER = "fuse";
    // Constant for port number
    public static String SSH_PASSWD = "fuseAdmin";
    // Constant for Database SID/DBNAME
    public static String SSH_COMMAND = "./a.sh";


    @BeforeClass
    public void beforeClass() throws IOException {

        // For Chrome Add Options
        // C:\\users\\vanw\\AppData\\Local\\Google\\Chrome\\User Data\\Default\Extensions\<extension_id>\version_num.crx\
        //ChromeOptions options = new ChromeOptions();
        //options.addExtensions(new File("C:\\Users\\vanwh\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ecnphlgnajanjnkcmbpancdjoidceilk\\2.0.8563_0.crx"));
        //driver = new ChromeDriver();
        //baseUrl = "https://www.expedia.com";
        //searchPage = new SearchPageFactoryHp(driver);
        //menuSelect = new MainMenuFactoryHp(driver);



        // Maximize the browser's window
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get(baseUrl);
    }

    @Test
    public void test() throws IOException {
        /*
        */
        //System.out.println("AM I HERE");
        //menuSelect.clearHeadersOnStartUp();
        //System.out.println("AM I HERE NOW");
        //wait(10000);

        //searchPage.getWhenVisible(By.id("tab-flight-tab-hp"), 20);

        //searchPage.clickFlightsTab();

        // Rotate through the trip buttons
        //searchPage.selectOneWayTripButton();
        //searchPage.selectMultiDestButton();
        //searchPage.selectReturnTripButton();

        // Now enter values for flight
        //searchPage.setOriginatingCity("New York");
        //searchPage.setDestinationCity("Chicago");
        // Hp site - Cannot enter dates into the input field - needs rework
        //searchPage.setDepartureDate("18/03/2017");
        //searchPage.clearAndSetReturnDate("25/03/2017");

        //Note once you enter a dept date when you select the rtn date field it automaticall populates it with the next day
        //String aDate = searchPage.getReturnDate()
        //System.out.println("The date returned is " + aDate);
        //searchPage.setReturnDate("25/03/2017");


        // Now select number of adults and children
        //searchPage.setNumberOfAdultsDropdown(2);
        //searchPage.getNumAdultsDropdown();
       // searchPage.setNumberOfChildrenDropdown("2");
        //searchPage.numAdultsDropdown.selectByIndex(2);
        //searchPage.numChildrenDropdown.selectByVisibleText("6");
        sshc = new SshConnector(SSH_HOST, SSH_USER, SSH_PASSWD, SSH_COMMAND);
        //
        // TODO - Need to add condition so it stops in a known time period
        // TODO - Perhaps have two jobs running on UNIX box one to capture a reponse if erro occurs
        //
        sshc.openSshConnection();
        System.out.println("END OF TestClass");


    }


    @AfterClass
    public void afterClass() throws IOException {

        System.out.println("In AfterClass");
        //driver.quit();


    }
}
