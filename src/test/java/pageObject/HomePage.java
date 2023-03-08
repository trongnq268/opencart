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
    String slideCss = ".slideshow";

    String inputSearchXpath = "//input[@placeholder='Search']";
    String btnSearchXpath = "//button[@class='btn btn-default btn-lg']";

    String searchDataXpath = "//a[normalize-space()='iMac']";
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

    public boolean isSlide(WebDriver driver){
        try{
            WebElement slide = driver.findElement(By.cssSelector(slideCss));
            return (slide.isDisplayed());
        }catch (Exception e){
            return (false);
        }
    }

    public void inputSearch(WebDriver driver,String search){
        WebElement txtInputSearch = driver.findElement(By.xpath(inputSearchXpath));
        txtInputSearch.sendKeys(search);
    }

    public void btnSearch(WebDriver driver){
        WebElement btnSearch = driver.findElement(By.xpath(btnSearchXpath));
        btnSearch.click();
    }

    public boolean isSearchData(WebDriver driver){
        try{
            WebElement isSearchData = driver.findElement(By.xpath(searchDataXpath));
            return (isSearchData.isDisplayed());
        }catch (Exception e){
            return (false);
        }
    }
}
