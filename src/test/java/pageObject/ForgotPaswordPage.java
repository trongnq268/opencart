package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPaswordPage extends BasePage {

    public ForgotPaswordPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")
    WebElement txtForgotPasswordPage;

    public boolean isForgotPasswordPage(){
        try {
            return (txtForgotPasswordPage.isDisplayed());
        }
        catch (Exception e) {
            return (false);
        }
    }
}
