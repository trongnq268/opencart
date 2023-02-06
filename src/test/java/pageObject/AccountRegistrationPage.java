package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(name = "firstname")
    WebElement txtFirstName;

    @FindBy(name = "lastname")
    WebElement txtLastName;

    @FindBy(name = "email")
    WebElement txtEmail;

    @FindBy(name = "telephone")
    WebElement txtTelephone;

    @FindBy(name="password")
    WebElement txtPassword;

    @FindBy(name = "confirm")
    WebElement txtConfirmPassword;
}
