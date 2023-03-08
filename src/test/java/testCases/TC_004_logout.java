package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_004_logout extends BaseClass {

    HomePage homePage = new HomePage();
    MyAccountPage macc = new MyAccountPage();
    LoginPage login = new LoginPage();

    @Test(groups = "Master")
    public void TC_LG_001(){
        try {
            homePage.clickMyAccount(driver);
            homePage.clickLogin(driver);

            login.setEmail(driver, rb.getString("email"));
            login.setPassword(driver, rb.getString("password"));
            login.clickLogin(driver);

            macc.clickMyAccountPage(driver);
            macc.clickLogoutAcc(driver);
            macc.clickBtnContinue(driver);

            boolean btnLogoutAcc = macc.isBtnLogout(driver);
            Assert.assertFalse(btnLogoutAcc);

            boolean slideDisplay = homePage.isSlide(driver);
            Assert.assertTrue(slideDisplay);
        }catch (Exception e){
            e.getStackTrace();
            Assert.fail();
        }
    }
}
