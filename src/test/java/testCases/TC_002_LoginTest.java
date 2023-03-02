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

    HomePage homePage = new HomePage();
    LoginPage lp = new LoginPage();
    ForgotPaswordPage fgp =new ForgotPaswordPage();

    @Test(groups = {"Sanity"}, priority = 1)
    public void TC_LF_007() {

        logger.info("***Start test LoginTest...**");
        try {
            homePage.clickMyAccount(driver);
            homePage.clickLogin(driver);

            lp.setEmail(driver,rb.getString("email"));
            lp.setPassword(driver,rb.getString("password"));
            lp.clickLogin(driver);

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetpage = macc.isMyAccountPageExits();
            Assert.assertEquals(targetpage, true);

            macc.clickLogout();
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
        logger.info("Finished TC_002_LoginTest");
    }

    @Test(dataProvider = "TC_002", dataProviderClass = DataProviders.class, priority = 2)
    public void TC_LF_002(String email, String pws){
        logger.info("***Start test TC_LF_002");
        try{
//            HomePage homePage = new HomePage(driver);
//            LoginPage lp = new LoginPage(driver);

            homePage.clickMyAccount(driver);
            homePage.clickLogin(driver);
            lp.setEmail(driver,email);
            lp.setPassword(driver,pws);
            lp.clickLogin(driver);

            Assert.assertTrue(lp.isMsgAlert(driver), "It is Alert");
            String actualAlert = lp.msgLoginFail(driver);
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
            homePage.clickMyAccount(driver);
            homePage.clickLogin(driver);

            lp.clickLogin(driver);
            String actualAlert = lp.msgLoginFail(driver);
            String expectAlert = "Warning: No match for E-Mail Address and/or Password.";

            Assert.assertEquals(actualAlert,expectAlert,"It is pass");
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
        logger.info("Finished TC_LF_005");
    }

    @Test(priority = 4)
    public void TC_LF_006(){
        logger.info("Start TC_LF_006");
        try{
            homePage.clickMyAccount(driver);
            homePage.clickLogin(driver);
            lp.clickForgotPassword(driver);

            Assert.assertTrue(fgp.isForgotPasswordPage(driver), "Forgot Your Password page");
        }catch (Exception e){
            Assert.fail();
        }
    }

    @Test(priority = 5)
    public void TC_LF_008(){
        logger.info("Start TC_LF_008");
        try{
            homePage.clickMyAccount(driver);
            homePage.clickLogin(driver);

            String actualEmail = lp.getTextEmail(driver);
            String expectedEmail = "E-Mail Address";
            Assert.assertEquals(actualEmail, expectedEmail, "Fail Email");

            String actualPassword = lp.getTextPassword(driver);
            String expectedPassword = "Password";
            Assert.assertEquals(actualPassword, expectedPassword, "Fail password");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        logger.info("Finished TC_LF_008");
    }

    @Test(priority = 6, groups = "Master")
    public void TC_LF_009(){
        try{
            homePage.clickMyAccount(driver);
            homePage.clickLogin(driver);

            lp.setEmail(driver,rb.getString("email"));
            lp.setPassword(driver,rb.getString("password"));
            lp.clickLogin(driver);

            lp.backPage(driver);

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetpage = macc.isMyAccountPageExits();
            Assert.assertEquals(targetpage, true);

            macc.clickLogout();


        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}
