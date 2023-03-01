package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement msgAlert;

    @FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
    WebElement btnForgotPassword;

    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }

    public String getTextEmail(){
       try{
           return (txtEmail.getAttribute("placeholder"));
       }catch (Exception e){
           return (e.getMessage());
       }
    }

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public String getTextPassword(){
        try {
            return(txtPassword.getAttribute("placeholder"));
        }catch(Exception e){
            return(e.getMessage());
        }
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public String msgLoginFail(){
        try{
            return(msgAlert.getText());
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    public boolean isMsgAlert(){
        try{
            return msgAlert.isDisplayed();
        }catch (Exception e){
           return (false);
        }
    }

    public void clickForgotPassword(){
        btnForgotPassword.click();
    }
}
