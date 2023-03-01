package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_LoginTest extends BaseClass {



    @Test(groups = {"Sanity"})
    public void testLoginAccount() {

        logger.info("***Start test LoginTest...**");
        try {
            HomePage homePage = new HomePage(driver);
            LoginPage lp = new LoginPage(driver);

            homePage.clickMyAccount();
            homePage.clickLogin();

            lp.setEmail(rb.getString("email"));
            lp.setPassword(rb.getString("password"));
            lp.clickLogin();

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetpage = macc.isMyAccountPageExits();
            Assert.assertEquals(targetpage, true);
        }
        catch (Exception e){
            Assert.fail();
        }
        logger.info("Finished TC_002_LoginTest");
    }

    @Test(dataProvider = "TS_002", dataProviderClass = DataProviders.class)
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
            String expectAlert = " Warning: No match for E-Mail Address and/or Password.";

            Assert.assertEquals(actualAlert,expectAlert,"It is pass");

        }catch (Exception e){
            Assert.fail();
        }
        logger.info("Finished TC_LF_002");
    }



}
