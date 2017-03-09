package acme.expedia.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Created by vanwh on 06/03/2017.
 */
public class CottagePageFactoryHp {

    private WebDriver driver;

    // Define WebElements here using PageFactory FindBy
    //@FindBy (xpath = "//ul[@id='top-nav']/li[2]/a")
    @FindBy (partialLinkText = "Back to Expedia")
    private WebElement backToExpedia;


    // Create Constructor of class
    public CottagePageFactoryHp(WebDriver driver){
        this.driver = driver;
        // Now use Page Factory to initialise the Elements of THIS Class
        PageFactory.initElements(driver, this);
    }

    // Define Methods to be used for Menu activity

    public void clickBackToExpedia(){
        System.out.println("Am I in clickBackToExpedia");
        backToExpedia.click();
    }

    public void cottageHelp(){
        System.out.println("I am in cottage Page..");
    }

}
