package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.ForgotPaswordPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity"}, priority = 1)
    public void TC_LF_007() {

        logger.info("***Start test LoginTest...**");
        try {

            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(rb.getString("email"));
            lp.setPassword(rb.getString("password"));
            lp.clickLogin();

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetpage = macc.isMyAccountPageExits();
            Assert.assertEquals(targetpage, true);

            macc.clickLogout();
        }
        catch (Exception e){
            Assert.fail();
        }
        logger.info("Finished TC_002_LoginTest");
    }

    @Test(dataProvider = "TC_002", dataProviderClass = DataProviders.class, priority = 2)
    public void TC_LF_002(String email, String pws){
        logger.info("***Start test TC_LF_002");
        try{
            HomePage homePage = new HomePage(driver);
            LoginPage lp = new LoginPage(driver);

            homePage.clickMyAccount();
            homePage.clickLogin();
            lp.setEmail(email);
            lp.setPassword(pws);
            lp.clickLogin();

            Assert.assertTrue(lp.isMsgAlert(), "It is Alert");
            String actualAlert = lp.msgLoginFail();
            String expectAlert = "Warning: No match for E-Mail Address and/or Password.";
            Assert.assertEquals(actualAlert,expectAlert,"It is pass");

        }catch (Exception e){
            Assert.fail();
        }
        logger.info("Finished TC_LF_002");
    }

    @Test(priority = 3)
    public void TC_LF_005(){
        logger.info("Start TC_LF_005");
        try{
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.clickLogin();
            String actualAlert = lp.msgLoginFail();
            String expectAlert = "Warning: No match for E-Mail Address and/or Password.";

            Assert.assertEquals(actualAlert,expectAlert,"It is pass");
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("Finished TC_LF_005");
    }

    @Test(priority = 4)
    public void TC_LF_006(){
        logger.info("Start TC_LF_006");
        try{
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();
            LoginPage lp = new LoginPage(driver);
            lp.clickForgotPassword();
            ForgotPaswordPage fgp =new ForgotPaswordPage(driver);

            Assert.assertTrue(fgp.isForgotPasswordPage(), "Forgot Your Password page");
        }catch (Exception e){
            Assert.fail();
        }
    }

    @Test(priority = 5, groups = "Master")
    public void TC_LF_008(){
        logger.info("Start TC_LF_008");
        try{
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage lp = new LoginPage(driver);
            String actualEmail = lp.getTextEmail();
            String expectedEmail = "E-Mail Address";
            Assert.assertEquals(actualEmail, expectedEmail, "Fail Email");

            String actualPassword = lp.getTextPassword();
            String expectedPassword = "Password";
            Assert.assertEquals(actualPassword, expectedPassword, "Fail password");

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("Finished TC_LF_008");
    }

}
