package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage{

//    public HomePage(WebDriver driver){
//        super(driver);
//    }
    //Element
    String lnkMyAccountXpath = "//span[normalize-space()='My Account']";
    String linkTextXpath = "Register";
    String lnkLoginXpath =  "//a[normalize-space()='Login']";

    //Action Methods
    public void clickMyAccount(WebDriver driver){
        WebElement lnkMyAccount = driver.findElement(By.xpath(lnkMyAccountXpath));
        lnkMyAccount.click();
    }

    public void clickRegister(WebDriver driver){
        WebElement lnkRegister = driver.findElement(By.linkText(linkTextXpath));
        lnkRegister.click();
    }

    public void clickLogin(WebDriver driver){
        WebElement lnkLogin = driver.findElement(By.xpath(lnkLoginXpath));
        lnkLogin.click();
    }
}
