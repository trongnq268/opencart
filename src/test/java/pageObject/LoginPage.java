package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage{
//
//    public LoginPage(WebDriver driver){
//        super(driver);
//    }

    String emailXpath = "//input[@id='input-email']";
    String passwordXpath = "//input[@id='input-password']";
    String btnLoginXpath =  "//input[@value='Login']";
    String msgAlertXpath = "//div[@class='alert alert-danger alert-dismissible']";
    String btnForgotPasswordXpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";

    public void setEmail(WebDriver driver,String email){
        WebElement txtEmail = driver.findElement(By.xpath(emailXpath));
        txtEmail.sendKeys(email);
    }

    public String getTextEmail(WebDriver driver){
       try{
           WebElement txtEmail = driver.findElement(By.xpath(emailXpath));
           return (txtEmail.getAttribute("placeholder"));
       }catch (Exception e){
           return (e.getMessage());
       }
    }

    public void setPassword(WebDriver driver,String password){
        WebElement txtPassword = driver.findElement(By.xpath(passwordXpath));
        txtPassword.sendKeys(password);
    }

    public String getTextPassword(WebDriver driver){
        try {
            WebElement txtPassword = driver.findElement(By.xpath(passwordXpath));
            return(txtPassword.getAttribute("placeholder"));
        }catch(Exception e){
            return(e.getMessage());
        }
    }

    public void clickLogin(WebDriver driver){
        WebElement btnLogin = driver.findElement(By.xpath(btnLoginXpath));
        btnLogin.click();
    }

    public String msgLoginFail(WebDriver driver){
        try{
            WebElement msgAlert = driver.findElement(By.xpath(msgAlertXpath));
            return(msgAlert.getText());
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    public boolean isMsgAlert(WebDriver driver){
        try{
            WebElement msgAlert = driver.findElement(By.xpath(msgAlertXpath));
            return msgAlert.isDisplayed();
        }catch (Exception e){
           return (false);
        }
    }

    public void clickForgotPassword(WebDriver driver){
        WebElement btnForgotPassword = driver.findElement(By.xpath(btnForgotPasswordXpath));
        btnForgotPassword.click();
    }

    public void backPage(WebDriver driver){
        driver.navigate().back();
    }
}
