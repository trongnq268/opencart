package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPaswordPage {

    String txtForgotPasswordPageXpath = "//h1[normalize-space()='Forgot Your Password?']";


    public boolean isForgotPasswordPage(WebDriver driver){
        try {
            WebElement txtForgotPasswordPage = driver.findElement(By.xpath(txtForgotPasswordPageXpath));
            return (txtForgotPasswordPage.isDisplayed());
        }
        catch (Exception e) {
            return (false);
        }
    }
}
