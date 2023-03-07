package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage{

    String msgHeadingXpath = "//h2[text()='My Account']";
    String btnMyAccountXpath = "//span[normalize-space()='My Account']";
    String logoutXpath = "//div[@class='list-group']//a[text()='Logout']";
    String logoutXpathAcc = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']";
    String btnContinueXpath = "//a[normalize-space()='Continue']";

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

    public void clickMyAccountPage(WebDriver driver){
        WebElement btnMyAccount = driver.findElement(By.xpath(btnMyAccountXpath));
        btnMyAccount.click();
    }

    public void clickLogoutAcc(WebDriver driver){
        WebElement lnkLogoutAcc = driver.findElement(By.xpath(logoutXpathAcc));
        lnkLogoutAcc.click();
        
    }

    public boolean isBtnLogout(WebDriver driver){
        try{
            WebElement lnkLogoutAcc = driver.findElement(By.xpath(logoutXpathAcc));
            return (lnkLogoutAcc.isDisplayed());
        }catch (Exception e){
            return (false);
        }
    }

    public void clickBtnContinue(WebDriver driver){
        WebElement btnContinue = driver.findElement(By.xpath(btnContinueXpath));
        btnContinue.click();
    }
}
