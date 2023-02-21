package testCases;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {


    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void test_LoginDDT(String email, String pws, String exp){
        logger.info("***Starting TC_003_loginDataDrivenTest");

        try{
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage loginPage  = new LoginPage(driver);
            loginPage.setEmail(email);
            loginPage.setPassword(pws);
            loginPage.clickLogin();

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetpage = macc.isMyAccountPageExits();

            if(exp.equals("Valid")){
                if (targetpage == true){
                    macc.clickLogout();
                    Assert.assertTrue(true);
                }
                else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equals("Invalid")){
                if (targetpage == true){
                    macc.clickLogout();
                    Assert.assertTrue(false);
                }
                else {
                    Assert.assertTrue(true);
                }
            }

        }catch (Exception e){
            Assert.fail();
        }
    }
}
