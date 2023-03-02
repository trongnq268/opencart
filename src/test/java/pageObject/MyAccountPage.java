package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage{

    String msgHeadingXpath = "//h2[text()='My Account']";
    String logoutXpath = "//div[@class='list-group']//a[text()='Logout']";


    public boolean isMyAccountPageExits(WebDriver driver){
        try{
            WebElement msgHeading = driver.findElement(By.xpath(msgHeadingXpath));
            return (msgHeading.isDisplayed());
        }catch (Exception e){
            return (false);
        }
    }

    public void clickLogout(WebDriver driver){
        WebElement lnkLogout = driver.findElement(By.xpath(logoutXpath));
        lnkLogout.click();
    }
}
