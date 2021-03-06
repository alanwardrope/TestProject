package acme.expedia.framework.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vanwh on 01/03/2017.
 */
public class utils {


    // Methods

    public void UrlList(WebDriver driver){
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (int i = 1; i<=links.size(); i=i+1)
        {
            System.out.println(links.get(i).getText());
        }
    }

    public String selectedPageTitle(WebDriver driver){
        String thePageTitle;
        thePageTitle = driver.getTitle();
        //System.out.println("The page title is : " + thePageTitle);
        return thePageTitle;
    }

    public String selectedPageURL(WebDriver driver){
        String theCurrentUrl;
        theCurrentUrl = driver.getCurrentUrl();
        //System.out.println("The page title is : " + thePageTitle);
        return theCurrentUrl;
    }

    public String[] getElementArray(List<WebElement> allElements) {

        int s = allElements.size();
        String[] names = new String[s];

        int j = 0;
        for (WebElement element: allElements) {
            names[j] = element.getText();
            j++;

    }
    return names;
    }

}
