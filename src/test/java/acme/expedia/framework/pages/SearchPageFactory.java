package acme.expedia.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

/**
 * Created by vanwh on 23/02/2017.
 */
public class SearchPageFactory {
    private WebDriver driver;


    @FindBy(id = "header-history")
    private WebElement headerHistory;

    @FindBy(xpath = "//*[@id='redirectBanner']/div/button")
    private WebElement redirectBannerCloseButton;

    @FindBy(id = "join-rewards-close-btn")
    private WebElement joinRewardsCloseButton;

    @FindBy(id="header-account-menu")
    private WebElement headerAccountMenu;

    @FindBy(id = "tab-flight-tab")
    private WebElement flightsTab;

    @FindBy(id ="flight-type-roundtrip-label")
    public WebElement returnTripButton;

    @FindBy(id ="flight-type-one-way-label")
    public WebElement oneWayTripButton;

    @FindBy(id ="flight-type-multi-dest-label")
    public WebElement multiDestTripButton;

    @FindBy(id = "flight-origin")
    private WebElement originatingCity;

    @FindBy(id = "flight-destination")
    private WebElement destinationCity;

    @FindBy(id = "flight-departing")
    private WebElement departureDate;

    @FindBy(id = "flight-returning")
    private WebElement returnDate;

    @FindBy(id = "flight-adults")
    private WebElement numberOfAdultsDropdown;
    //public Select numAdultsDropdown = new Select(numberOfAdults);

    @FindBy(id = "flight-children")
    private WebElement numberOfChildrenDropdown;
    //public Select numChildrenDropdown = new Select(numberOfChildren);

    @FindBy(id = "advanced-options")
    private WebElement advancedOptionsLink;

    @FindBy(id = "advanced-flight-nonstop")
    private WebElement directFlightCheckBox;

    @FindBy(id = "advanced-flight-refundable")
    private WebElement refundableFlightCheckBox;

    @FindBy(id = "flight-advanced-preferred-airline")
    private WebElement preferredAirlineDropdown;

    @FindBy(id = "flight-advanced-preferred-class")
    private WebElement preferredClassDropdown;

    @FindBy(id = "flight-add-car-checkbox")
    private WebElement addCarCheckBox;

    @FindBy(id = "driver-age-checkbox")
    private WebElement driverAgeCheckBox;

    @FindBy(id = "driver-age-help-default")
    private WebElement driverAgeHelpInfoButton;

    @FindBy (id="flight-type-help-default")
    private WebElement flightTypeHelpInfoButton;

    /*
        Now create a constructor for the class
     */

    public SearchPageFactory(WebDriver driver){
        this.driver = driver;
        // Now use Page Factory to initialise the Elements of THIS Class
        PageFactory.initElements(driver, this);
    }

    /*
       Now write the methods
     */

    public void clearHeadersOnStartUp(){
        //headerHistory.click();
        redirectBannerCloseButton.click();
        joinRewardsCloseButton.click();
        headerAccountMenu.click();
    }

    public WebElement getWhenVisible(By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        System.out.println("YESY YESY");
        return element;
    }

    public void clickFlightsTab(){
        flightsTab.click();
    }

    public void selectReturnTripButton(){ returnTripButton.click();}

    public void selectOneWayTripButton(){ oneWayTripButton.click();}

    public void selectMultiDestButton () { multiDestTripButton.click();}

    public void setOriginatingCity(String origin){
        originatingCity.sendKeys(origin);
    }

    public void setDestinationCity(String destination){
        destinationCity.sendKeys(destination);
    }

    public void selectAdvancedOptionsLink () { advancedOptionsLink.click();}

    public Select getNumAdultsDropdown() {
        return new Select(numberOfAdultsDropdown);
    }
    public void setNumberOfAdultsDropdown(int theIndex) {
        //Uses the Index starts at 0
        getNumAdultsDropdown().selectByIndex(theIndex);
    }

    public Select getNumChildrenDropdown() {
        return new Select(numberOfChildrenDropdown);
    }
    public void setNumberOfChildrenDropdown(String theValue) {
        // Uses the value
        getNumChildrenDropdown().selectByValue(theValue);
    }

    public void clearAndSetDepartureDate(String rtnDate){
        departureDate.clear();
        departureDate.sendKeys(rtnDate);
    }


    public void setDepartureDate(String departDate){ departureDate.sendKeys(departDate); }

    public void clearAndSetReturnDate(String rtnDate){
        returnDate.clear();
        returnDate.sendKeys(rtnDate);
    }

    public void setReturnDate(String rtnDate){ returnDate.sendKeys(rtnDate); }

    public void selectReturnDateField(){ returnDate.click(); }

    public String getReturnDate(){
        String theDate;
        theDate = returnDate.getAttribute("");
        return theDate;
    }

    public void checkDirectFlight() {
        try {
            if (directFlightCheckBox.isSelected()) {
                System.out.println("Checkbox: " + directFlightCheckBox + " is already selected");
            } else {
                // Select the checkbox
                directFlightCheckBox.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the checkbox: " + directFlightCheckBox);
        }
    };

    public void uncheckDirectFlight() {
        try {
            if (directFlightCheckBox.isSelected()) {
                //De-select the checkbox
                directFlightCheckBox.click();
            } else {
                System.out.println("Checkbox: "+ directFlightCheckBox +" is already deselected");
            }
        } catch (Exception e) {
            System.out.println("Unable to deselect checkbox: "+ directFlightCheckBox);
        }
    };

    public void checkRefundFlight() {
        try {
            if (refundableFlightCheckBox.isSelected()) {
                System.out.println("Checkbox: " + refundableFlightCheckBox + " is already selected");
            } else {
                // Select the checkbox
                refundableFlightCheckBox.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the checkbox: " + refundableFlightCheckBox);
        }
    };

    public void uncheckRefundFlight() {
        try {
            if (refundableFlightCheckBox.isSelected()) {
                //De-select the checkbox
                refundableFlightCheckBox.click();
            } else {
                System.out.println("Checkbox: "+ refundableFlightCheckBox +" is already deselected");
            }
        } catch (Exception e) {
            System.out.println("Unable to deselect checkbox: "+ refundableFlightCheckBox);
        }
    };

    public Select getPreferredAirline() {
        return new Select(preferredAirlineDropdown);
    }
    public void setPreferredAirlineDropdown(int theIndex) {
        //Uses the Index starts at 0
        getPreferredAirline().selectByIndex(theIndex);
    }

    public Select getPreferredClass() {
        return new Select(preferredClassDropdown);
    }
    public void setPreferredClassDropdown(String theClassName) {
        //Uses String value
        getPreferredClass().selectByValue(theClassName);

    }

    public void checkAddCar() {
        try {
            if (addCarCheckBox.isSelected()) {
                System.out.println("Checkbox: " + addCarCheckBox + " is already selected");
            } else {
                // Select the checkbox
                addCarCheckBox.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the checkbox: " + addCarCheckBox);
        }
    };

    public void uncheckAddCar() {
        try {
            if (addCarCheckBox.isSelected()) {
                //De-select the checkbox
                addCarCheckBox.click();
            } else {
                System.out.println("Checkbox: "+ addCarCheckBox +" is already deselected");
            }
        } catch (Exception e) {
            System.out.println("Unable to deselect checkbox: "+ addCarCheckBox);
        }
    };

    public void checkDriverAge() {
        try {
            if (driverAgeCheckBox.isSelected()) {
                System.out.println("Checkbox: " + driverAgeCheckBox + " is already selected");
            } else {
                // Select the checkbox
                driverAgeCheckBox.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the checkbox: " + driverAgeCheckBox);
        }
    };

    public void uncheckDriverAge() {
        try {
            if (driverAgeCheckBox.isSelected()) {
                //De-select the checkbox
                driverAgeCheckBox.click();
            } else {
                System.out.println("Checkbox: "+ driverAgeCheckBox +" is already deselected");
            }
        } catch (Exception e) {
            System.out.println("Unable to deselect checkbox: "+ driverAgeCheckBox);
        }
    };


    public void checkDriverAgeBySpanName(){
    String text = "Driver aged between 25 - 70?";
    //By xpath = By.xpath("//span[contains(text(),'" + text + "')]/../input")
        By xpath = By.xpath("//*[@id='driver-age-checkbox-label']/span/span[1][contains(text(),'" + text + "')]/../input");
    WebElement element = driver.findElement(xpath);

    }

    public void checkButtonStatus(WebElement testElement){
        System.out.println("Inside checkButtonStatus with button " + testElement);
        try {
            if (!testElement.isEnabled()) {
                System.out.println("Button: " + testElement + " is not ENABLED");
            } else {
                // Select the Button
                testElement.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the Button: " + testElement);
        }
    }

    public void selectDriverAgeHelpInfo(){ driverAgeHelpInfoButton.click();}

    public void selectFlightTypeHelpInfo(){ flightTypeHelpInfoButton.click();
    System.out.println("Selected flightTypeHelpInfoButton");}
}
