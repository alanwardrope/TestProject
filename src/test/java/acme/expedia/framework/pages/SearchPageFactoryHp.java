package acme.expedia.framework.pages;

//import com.sun.org.apache.xpath.internal.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.lang.String;

/**
 * Created by vanwh on 23/02/2017.
 */
public class SearchPageFactoryHp {

    private WebDriver driver;

    /*
    @FindBy(id = "header-history")
    private WebElement headerHistory;

    @FindBy(xpath = "//*[@id='redirectBanner']/div/button")
    private WebElement redirectBannerCloseButton;

    @FindBy(id = "join-rewards-close-btn")
    private WebElement joinRewardsCloseButton;

    @FindBy(id="header-account-menu")
    private WebElement headerAccountMenu;
*/

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightsTab;

    @FindBy(id ="flight-type-roundtrip-label-hp-flight")
    public WebElement returnTripButton;

    @FindBy(id ="flight-type-one-way-label-hp-flight")
    public WebElement oneWayTripButton;

    @FindBy(id ="flight-type-multi-dest-label-hp-flight")
    public WebElement multiDestTripButton;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement originatingCity;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement destinationCity;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement departureDate;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement returnDate;

    @FindBy(id = "flight-adults-hp-flight")
    private WebElement numberOfAdultsDropdown;
    //public Select numAdultsDropdown = new Select(numberOfAdults);

    @FindBy(id = "flight-children-hp-flight")
    private WebElement numberOfChildrenDropdown;
    //public Select numChildrenDropdown = new Select(numberOfChildren);

    @FindBy(id = "flight-advanced-options-hp-flight")
    private WebElement advancedOptionsLink;

    @FindBy(id = "advanced-flight-nonstop-hp-flight")
    private WebElement directFlightCheckBox;

    @FindBy(id = "advanced-flight-refundable-hp-flight")
    private WebElement refundableFlightCheckBox;

    @FindBy(id = "flight-advanced-preferred-airline-hp-flight")
    private WebElement preferredAirlineDropdown;

    @FindBy(id = "flight-advanced-preferred-class-hp-flight")
    private WebElement preferredClassDropdown;

    @FindBy(id = "flight-add-car-checkbox-hp-flight")
    private WebElement addCarCheckBox;

    @FindBy(id = "driver-age-checkbox-hp-flight")
    private WebElement driverAgeCheckBox;

    @FindBy(id = "driver-age-help-default")
    private WebElement driverAgeHelpInfoButton;

    @FindBy (css = ".sub-nav-select.disable")
    private WebElement flightOptionButtonsDisabled;

    String helpInfoButtonElement = "//*[@id='gcw-flights-form-hp-flight']/fieldset[@class='sub-nav-select disable']/div/a";
    @FindBy (xpath = "//*[@id='gcw-flights-form-hp-flight']/fieldset[@class='sub-nav-select disable']/div/a")
    private WebElement flightTypeHelpInfoButton;

    @FindBy (id = "flight-add-hotel-checkbox-hp-flight")
    private WebElement hotelCheckbox;

    @FindBy (id = "flight-age-select-1-label-hp-flight")
    private WebElement childOneAgeDropDownLabel;

    @FindBy (id = "flight-age-select-2-label-hp-flight")
    private WebElement childTwoAgeDropDownLabel;

    @FindBy (id = "flight-age-select-3-label-hp-flight")
    private WebElement childThreeAgeDropDownLabel;

    @FindBy (id = "flight-age-select-4-label-hp-flight")
    private WebElement childFourAgeDropDownLabel;

    @FindBy (id = "flight-age-select-5-label-hp-flight")
    private WebElement childFiveAgeDropDownLabel;

    @FindBy (id = "flight-age-select-6-label-hp-flight")
    private WebElement childSixAgeDropDownLabel;

    @FindBy (id="flight-age-select-1-hp-flight")
    private WebElement childOneAgeDropDown;

    @FindBy (id = "flight-children-in-lap-hp-flight")
    private WebElement childInLapRadioButton;

    @ FindBy (xpath="//*[@id='flight-children-in-lap-label-hp-flight']/span")
    private WebElement childInLapRadioButtonText;


    @FindBy (id = "flight-children-in-seat-hp-flight")
    private WebElement childInSeatRadioButton;

    @ FindBy (xpath="//*[@id='flight-children-in-seat-label-hp-flight']/span")
    private WebElement childInSeatRadioButtonText;
    /*
        Now create a constructor for the class
     */

    public SearchPageFactoryHp(WebDriver driver){
        this.driver = driver;
        // Now use Page Factory to initialise the Elements of THIS Class
        PageFactory.initElements(driver, this);
    }

    /*
       Now write the methods
     */
    /*
    public void clearHeadersOnStartUp(){
        //headerHistory.click();
        redirectBannerCloseButton.click();
        joinRewardsCloseButton.click();
        headerAccountMenu.click();
    }
    */

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
            if (!testElement.isDisplayed()) {
                System.out.println("Button: " + testElement + " is not DISPLAYED");
            } else {
                // Select the Button
                testElement.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the Button: " + testElement);
            System.out.println("The exception is : " + e);
        }
    }

    public void selectDriverAgeHelpInfo(){ driverAgeHelpInfoButton.click();}

    public void selectFlightTypeHelpInfo(){ flightTypeHelpInfoButton.click();
    System.out.println("Selected flightTypeHelpInfoButton");}

    // TO FIX: as it doesn't work, Element is not displayed if not set
    public boolean checkFlightOptionButtonsDisabled () {return flightOptionButtonsDisabled.isDisplayed(); }

    public void checkHotelCheckbox() {
        try {
            if (hotelCheckbox.isSelected()) {
                System.out.println("Checkbox: " + hotelCheckbox + " is already selected");
            } else {
                // Select the checkbox
                hotelCheckbox.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the checkbox: " + hotelCheckbox);
        }
    };

    public void uncheckHotelCheckbox() {
        try {
            if (hotelCheckbox.isSelected()) {
                //De-select the checkbox
                hotelCheckbox.click();
            } else {
                System.out.println("Checkbox: "+ hotelCheckbox +" is already deselected");
            }
        } catch (Exception e) {
            System.out.println("Unable to deselect checkbox: "+ hotelCheckbox);
        }
    };

    public void getDataContentForHelpInfo(WebDriver driver){
        List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='gcw-flights-form-hp-flight']/fieldset[@class='sub-nav-select disable']/div/a"));
        int s=allElements.size();
        System.out.println("Total number of elements is : " + s);

        for (WebElement element: allElements) {
            System.out.println("element.getText : " + element.getText());
            System.out.println("element.getAttribute data-content : " + element.getAttribute("data-content"));
        }
    }
    public Select getchildOneAgeDropDown() {
        return new Select(childOneAgeDropDown);
    }
    public void setAgeOfChildOneDropdown(int theIndex) {
        //Uses the Index starts at 0
        getchildOneAgeDropDown().selectByIndex(theIndex);
    }

    public boolean validateChildLabelsDisplayed(WebDriver driver, int numVisibleChildren){

        //List<WebElement> allAgeLabels = driver.findElements(By.xpath("//form[@id='gcw-flights-form-hp-flight']/fieldset[@class='not-room-in-package room-data']/div[2]/label"));
        List<WebElement> allAgeLabels = driver.findElements(By.xpath("//form[@id='gcw-flights-form-hp-flight']/fieldset[contains(@class,'not-room-in-package')]/div[2]/label"));
        int s=allAgeLabels.size();
        String notVisible = "gcw-disabled";
        int i = 0;
        int v = 0;
        System.out.println("Total number of Age Labels is : " + s);

        for (WebElement element: allAgeLabels) {
            System.out.println("element.getAttribute class : " + element.getAttribute("class"));
            if (!element.getAttribute("class").contains(notVisible)){
                v = v + 1;
                System.out.println("v is : " + v);
            }else {
                i = i + 1;
                System.out.println("i is : " + i);
            }
        }
        System.out.println("Visible Age Labels : " + v + "\tInvisible Age Labels : " + i);
        if (v == numVisibleChildren){
            return true;
        }else {
            return false;
        }
    }

    public boolean validateChildAgeLimitSection(WebDriver driver, boolean displayStatus){
        WebElement childAgeLimitSection = driver.findElement(By.xpath("//div[@id='flight-lap-or-seat-container-hp-flight']"));
        String notVisible = "gcw-disabled";
        boolean result;


        if (!childAgeLimitSection.getAttribute("class").contains(notVisible)){
            System.out.println("Child Age Limit Section is visible");
            result = true;
        }else {
            System.out.println("Child Age Limit Section is NOT visible");
            result = false;
        }

        if (displayStatus == result){
            return true;
        } else {
            return false;
        }
    }

    public String validateInLapRBText(){
        return childInLapRadioButtonText.getText();

    }

    public String validateInSeatRBText(){
        System.out.println("Value of RB is : " + childInSeatRadioButtonText.getText());
        return childInSeatRadioButtonText.getText();
    }
}
