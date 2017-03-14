package acme.expedia.framework.pages;

import acme.expedia.framework.common.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vanwh on 02/03/2017.
 */
public class MainMenuFactoryHp {

    private WebDriver driver;

    // Define WebElements here using PageFactory FindBy
    @FindBy (id="primary-header-home")
    private WebElement searchMainMenuTab;

    @FindBy (id="primary-header-hotel")
    private WebElement hotelsMainMenuTab;

    @FindBy (id="primary-header-flight")
    private WebElement flightsMainMenuTab;

    @FindBy (id="primary-header-package")
    private WebElement flightAndHotelMainMenuTab;

    @FindBy (id="primary-header-car")
    private WebElement carMainMenuTab;

    @FindBy (id="primary-header-rail")
    private WebElement trainsMainMenuTab;

    @FindBy (id="primary-header-lastminute")
    private WebElement lastMinuteMainMenuTab;

    @FindBy (id="primary-header-beach")
    private WebElement beachMainMenuTab;

    @FindBy (id="primary-header-deals")
    private WebElement dealsMainMenuTab;

    @FindBy (id="primary-header-citybreaks")
    private WebElement cityBreaksMainMenuTab;

    @FindBy (id="primary-header-activity")
    private WebElement thingsToDoMainMenuTab;

    @FindBy (xpath="//li[@class='all-in-collapsed-desktop']")
    private WebElement moreDropDownMenuGt1015px;

    @FindBy (xpath = "//ul[@class='utility-nav nav-group cf']/li[@class='all-in-collapsed-desktop']/ul/li")
    private WebElement moreDropDownListGt1015px;

    // Banner removal transfererd from SearchPageFactory
    @FindBy(id = "header-history")
    private WebElement headerHistory;

    @FindBy(xpath = "//*[@id='redirectBanner']/div/button")
    private WebElement redirectBannerCloseButton;

    @FindBy(id = "join-rewards-close-btn")
    private WebElement joinRewardsCloseButton;

    @FindBy(id="header-account-menu")
    private WebElement headerAccountMenu;
    // End of Banner removal



    // Create Constructor of class
    public MainMenuFactoryHp(WebDriver driver){
        this.driver = driver;
        // Now use Page Factory to initialise the Elements of THIS Class
        PageFactory.initElements(driver, this);
    }

    utils cUtils = new utils();

    // Define Methods to be used for Menu activity

    public void clickSearchMainMenuTab(){
        searchMainMenuTab.click();
    }

    public void clickHotelsMainMenuTab(){
        hotelsMainMenuTab.click();
    }

    public void clickFlightsMainMenuTab(){ flightsMainMenuTab.click(); }

    public void clickFlightAndHotelMainMenuTab(){
        flightAndHotelMainMenuTab.click();
    }

    public void clickCarMainMenuTab(){
        carMainMenuTab.click();
    }

    public void clickTrainsMainMenuTab(){
        trainsMainMenuTab.click();
    }

    public void clickLastMinuteMainMenuTab(){
        lastMinuteMainMenuTab.click();
    }

    public void clickBeachMainMenuTab(){
        beachMainMenuTab.click();
    }

    public void clickDealsMainMenuTab(){
        dealsMainMenuTab.click();
    }

    public void clickCityBreaksMainMenuTab(){
        cityBreaksMainMenuTab.click();
    }

    public void clickThingsToDoMainMenuTab(){
        thingsToDoMainMenuTab.click();
    }

    public void clickMoreMenuTabGt1015px() { moreDropDownMenuGt1015px.click();}

    public void clearHeadersOnStartUp(){
        //headerHistory.click();
        redirectBannerCloseButton.click();
        // Mar 10 2017 - Rewards Close Button has gone missing
        //joinRewardsCloseButton.click();
        headerAccountMenu.click();
    }

    public void verifyNumMoreMenuOptionGt1015px(WebDriver driver, int numOptions){

        List<WebElement> allElements = driver.findElements(By.xpath("//li[@class='all-in-collapsed-desktop open']/div/ul/li/a"));
        int s = allElements.size();
        String[] names = new String[s];
        System.out.println("Total number of elements is : " + s);

        int i = 0;
        for (WebElement element: allElements) {
            names[i] = element.getText();
            System.out.println("element.getText : " + element.getText());
            System.out.println("element.getText : " + names[i]);
            System.out.println("element.getAttribute href : " + element.getAttribute("href"));
            i = i + 1;
        }

        if (numOptions == s){
        System.out.println("Number of displayed options is correct " + s);

        } else if (numOptions < s){
            System.out.println("Number of displayed options is LESS than expected " + s + " and should be " + numOptions);

        } else {
            System.out.println("Number of displayed options is MORE THAN than expected " + s + " and should be " + numOptions);

        }
    }

    public void verifyNumMoreMenuOptionGt1015px(WebDriver driver, int numOptions, String menuOption) {

        List<WebElement> allElements = driver.findElements(By.xpath("//li[@class='all-in-collapsed-desktop open']/div/ul/li/a"));
        int s = allElements.size();
        String[] names = new String[s];
        System.out.println("Total number of elements is : " + s);

        if (numOptions == s){
            System.out.println("Number of displayed options is correct " + s);

            int i = 0;
            for (WebElement element: allElements) {
                names[i] = element.getText();
                System.out.println("element.getText : " + element.getText());
                System.out.println("element.getText : " + names[i]);
                System.out.println("element.getAttribute href : " + element.getAttribute("href"));
                System.out.println("names[" + i + "] " + names[i] + "\t" + "menuOption : " + menuOption);


                if (names[i].equals(menuOption)){
                    element.click();
                    System.out.println("Clicking Menu Option [" + i + "] : " + names[i]);

                    // Now to get out of loop
                    break;
                }

                i = i + 1;
            }
        } else if (numOptions < s){
            System.out.println("Number of displayed options is LESS than expected " + s + " and should be " + numOptions);
        } else {
            System.out.println("Number of displayed options is MORE THAN than expected " + s + " and should be " + numOptions);
        }
    }

    public void verifyNumMoreMenuOptionGt1015px2(WebDriver driver, int numOptions, String menuOption) {

        //Version 2 upgraded to include Hamcrest Asserts
        List<WebElement> allElements = driver.findElements(By.xpath("//li[@class='all-in-collapsed-desktop open']/div/ul/li/a"));
        int s = allElements.size();
        String[] names = new String[s];

        System.out.println("Actual number of elements is : " + s + "\tExpected number is " + numOptions);
        // Assert to validate the number of Menu Options displayed.
        assertThat(s, equalTo(numOptions));

/*
        int j = 0;
        for (WebElement element: allElements) {
            names[j] = element.getText();
            j++;
        }
*/

        /* Create a String List namesList from the String array names
        Not really required anymore as I found a way to use Arrays in Hamcrest
        List namesList = (List) Arrays.asList(names);
        for(int k=0; k < namesList.size(); k++){
            System.out.println("NamesList ["+k+"] : " + namesList.get(k));
        }
        */

        // Populate array with Names of all the Elements
        names = cUtils.getElementArray(allElements);
        // Assert to ensure Menu List contains Menu Option to be selected.
        assertThat(names, hasItemInArray(menuOption));

        //Now to select the Menu Option
        int i = 0;
        for (WebElement element: allElements) {
                names[i] = element.getText();
                System.out.println("element.getText : " + element.getText());
                System.out.println("element.getText : " + names[i]);
                System.out.println("element.getAttribute href : " + element.getAttribute("href"));
                System.out.println("names[" + i + "] " + names[i] + "\t" + "menuOption : " + menuOption);

                if (names[i].equals(menuOption)){
                    element.click();
                    System.out.println("Clicking Menu Option [" + i + "] : " + names[i]);

                    // Now to get out of loop
                    break;
                }
                i = i + 1;
            }
    }


}

