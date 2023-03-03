package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage{

    String firstNameXpath = "firstname";
    String lastNameXpath= "lastname";

    String emailXpath = "email";

    String telephoneXpath = "telephone";

    String passwordXpath = "password";

    String confirmPasswordXpath = "confirm";

    String agreeXpath = "agree";

    String btnContinueXpath = "//input[@value='Continue']";

    String msgConfirmationXpath = "//h1[normalize-space()='Your Account Has Been Created!']";
    String textDangeFirstName = "(//div[@class='col-sm-10'])[2]/div";
    String textDangeLastName = "(//div[@class='col-sm-10'])[3]/div";
    String textDangeEmail = "(//div[@class='col-sm-10'])[4]/div";
    String textDangePasswordConfirm = "(//div[@class='col-sm-10'])[7]/div";

    public void setFirstName(WebDriver driver,String fname) {
        WebElement txtFirstname = driver.findElement(By.name(firstNameXpath));
        txtFirstname.sendKeys(fname);

    }

    public void setLastName(WebDriver driver,String lname) {
        WebElement txtLasttname = driver.findElement(By.name(lastNameXpath));
        txtLasttname.sendKeys(lname);

    }

    public void setEmail(WebDriver driver,String email) {
        WebElement txtEmail = driver.findElement(By.name(emailXpath));
        txtEmail.sendKeys(email);

    }

    public void setTelephone(WebDriver driver,String tel) {
        WebElement txtTelephone = driver.findElement(By.name(telephoneXpath));
        txtTelephone.sendKeys(tel);

    }

    public void setPassword(WebDriver driver,String pwd) {
        WebElement txtPassword = driver.findElement(By.name(passwordXpath));
        txtPassword.sendKeys(pwd);

    }

    public void setConfirmPassword(WebDriver driver,String pwd) {
        WebElement txtConfirmPassword = driver.findElement(By.name(confirmPasswordXpath));
        txtConfirmPassword.sendKeys(pwd);

    }

    public void setPrivacyPolicy(WebDriver driver) {
        WebElement chkdPolicy = driver.findElement(By.name(agreeXpath));
        chkdPolicy.click();

    }

    public void clickContinue(WebDriver driver) {
        WebElement btnContinue = driver.findElement(By.xpath(btnContinueXpath));
        //sol1
        btnContinue.click();

    }

    public String getConfirmationMsg(WebDriver driver) {
        try {
            WebElement msgConfirmation = driver.findElement(By.xpath(msgConfirmationXpath));
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }
    }

    public String getTextDangeFirstName(WebDriver driver){
        try{
            WebElement msgTextDangerFirstName = driver.findElement(By.xpath(textDangeFirstName));
            return (msgTextDangerFirstName.getText());
        } catch (Exception e){
            return (e.getMessage());
        }
    }

    public String getTextDangeLastName(WebDriver driver){
        try{
            WebElement msgTextDangerLastName = driver.findElement(By.xpath(textDangeLastName));
            return (msgTextDangerLastName.getText());
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    public String getTextDangeEmail(WebDriver driver){
        try{
            WebElement msgTextDangeEmail = driver.findElement(By.xpath(textDangeEmail));
            return (msgTextDangeEmail.getText());
        } catch (Exception e){
            return (e.getMessage());
        }
    }

    public String getTextDangePasswordConfirm(WebDriver driver){
        try{
            WebElement msgTextDangePasswordConfirm = driver.findElement(By.xpath(textDangePasswordConfirm));
            return (msgTextDangePasswordConfirm.getText());
        } catch (Exception e){
            return (e.getMessage());
        }
    }



}
