package acme.expedia.tests;

import acme.expedia.framework.pages.MainMenuFactoryHp;
import acme.expedia.framework.pages.SearchPageFactoryHp;
import acme.expedia.framework.common.DatabaseConnector;

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
public class DBConnTestCaseChromeHp {

    private WebDriver driver;
    private String baseUrl;
    private String baseUrl2;
    SearchPageFactoryHp searchPage;
    MainMenuFactoryHp menuSelect;
    DatabaseConnector dbc;

    // DB Connection Parameters
    static Connection conn = null;
    // Statement object
    private static Statement stmt;
    // Result Set
    private static ResultSet results = null;
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://";
    // Constant for server name
    public static String DB_SERVER = "localhost";
    // Constant for port number
    public static String DB_PORT = "3306";
    // Constant for Database SID/DBNAME
    public static String DB_SID = "testdb";
    // Constant for Database Username
    public static String DB_USER = "alan";
    // Constant for Database Password
    public static String DB_PASSWORD = "wardrope61";
    // Driver
    //public static String dbdriver = "com.mysql.jdbc.Driver";

    public static String query = "select f.num_children, c.* from flight_info f inner join child_ages c on c.flight_info_id = f.flight_info_id where f.from_apt = \"New York\"";
    public static String query1 = "select f.num_children, c.child_age_id from flight_info f inner join child_ages c on c.flight_info_id = f.flight_info_id where f.from_apt = \"New York\"";


    @BeforeClass
    public void beforeClass() throws IOException {

        // For Chrome Add Options
        // C:\\users\\vanw\\AppData\\Local\\Google\\Chrome\\User Data\\Default\Extensions\<extension_id>\version_num.crx\
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\vanwh\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ecnphlgnajanjnkcmbpancdjoidceilk\\2.0.8563_0.crx"));
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com";
        searchPage = new SearchPageFactoryHp(driver);
        menuSelect = new MainMenuFactoryHp(driver);



        dbc = new DatabaseConnector(DB_SERVER, DB_PORT, DB_SID, DB_URL, DB_USER, DB_PASSWORD);
        //dbconnect = new DatabaseConnector(DB_URL, DB_SERVER, DB_PORT, DB_SID, DB_USER, DB_PASSWORD);
        dbc.openDBConnection();
        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws IOException, SQLException {
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


        // Now select number of adults and children
        searchPage.setNumberOfAdultsDropdown(2);
        //searchPage.getNumAdultsDropdown();
        searchPage.setNumberOfChildrenDropdown("2");
        //searchPage.numAdultsDropdown.selectByIndex(2);
        //searchPage.numChildrenDropdown.selectByVisibleText("6");

        results = dbc.runQuery(query1);
        while (results.next()) {
            int numChildren = results.getInt("num_children");
            int childAgeId = results.getInt("child_age_id");

            // Display Values
            System.out.println("num children: " + numChildren);
            System.out.println("Child Age Id: " + childAgeId);

            // Compare resut with GUI
//        		WebElement element = dv.findElement(By.id("uname"));
//        		String actualUserName = element.getText();
//        		Assert.assertEquals(actualUserName, first);
        }

    }


    @AfterClass
    public void afterClass() throws IOException {

        System.out.println("In AfterClass");
        //driver.quit();
        dbc.closeDBConnection();


    }
}
