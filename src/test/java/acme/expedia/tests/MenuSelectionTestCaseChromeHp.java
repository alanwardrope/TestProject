package acme.expedia.tests;

import acme.expedia.framework.pages.MainMenuFactoryHp;
import acme.expedia.framework.pages.CottagePageFactoryHp;
import acme.expedia.framework.common.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
public class MenuSelectionTestCaseChromeHp {

    private WebDriver driver;
    private String baseUrl;
    MainMenuFactoryHp menuSelect;
    CottagePageFactoryHp cottagePage;


    @BeforeClass
    public void beforeClass(){

        // For Chrome Add Options
        // C:\\users\\vanw\\AppData\\Local\\Google\\Chrome\\User Data\\Default\Extensions\<extension_id>\version_num.crx\
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\vanwh\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ecnphlgnajanjnkcmbpancdjoidceilk\\2.0.8563_0.crx"));
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com";
        //searchPage = new SearchPageFactoryHp(driver);
        menuSelect = new MainMenuFactoryHp(driver);
        cottagePage = new CottagePageFactoryHp(driver);

        // Maximize the browser's window
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1015,840));
        System.out.println(driver.manage().window().getSize());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        /*
        */
        utils pgTitle = new utils();
        String titleOfPage, urlOfPage;
        boolean validNumOptions;

        System.out.println("AM I HERE");
        menuSelect.clearHeadersOnStartUp();
        Thread.sleep(2000);
        System.out.println("AM I HERE NOW");

        // Home Page
        titleOfPage = pgTitle.selectedPageTitle(driver);
        menuSelect.clickMoreMenuTabGt1015px();
        menuSelect.verifyNumMoreMenuOptionGt1015px(driver, 3);
        Thread.sleep(1000);

        menuSelect.clickBeachMainMenuTab();
        titleOfPage = pgTitle.selectedPageTitle(driver);
        System.out.println("The page title is : " + titleOfPage);
        menuSelect.clickMoreMenuTabGt1015px();
        menuSelect.verifyNumMoreMenuOptionGt1015px(driver, 4);
        Thread.sleep(1000);

        menuSelect.clickCityBreaksMainMenuTab();
        titleOfPage = pgTitle.selectedPageTitle(driver);
        System.out.println("The page title is : " + titleOfPage);
        menuSelect.clickMoreMenuTabGt1015px();
        menuSelect.verifyNumMoreMenuOptionGt1015px(driver, 4);
        Thread.sleep(1000);


        menuSelect.clickDealsMainMenuTab();
        titleOfPage = pgTitle.selectedPageTitle(driver);
        System.out.println("The page title is : " + titleOfPage);
        menuSelect.clickMoreMenuTabGt1015px();
        menuSelect.verifyNumMoreMenuOptionGt1015px(driver, 4, "Cottages");
        Thread.sleep(1000);

        // Now we should be in Cottage Page
        // Want to Assert this to do a compariosn with what is returned
        titleOfPage = pgTitle.selectedPageTitle(driver);
        System.out.println("The page title is :" + titleOfPage);
        urlOfPage = pgTitle.selectedPageURL(driver);
        System.out.println("The page url is :" + urlOfPage);
        Thread.sleep(2000);

        cottagePage.cottageHelp();

        // Now to return to Expedia
        cottagePage.clickBackToExpedia();

        // Should return to Home/Search page
        titleOfPage = pgTitle.selectedPageTitle(driver);
        System.out.println("The page title is : " + titleOfPage);
    }


    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
}
