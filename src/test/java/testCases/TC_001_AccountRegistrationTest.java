package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

    HomePage hp = new HomePage();
    AccountRegistrationPage regpage = new AccountRegistrationPage();

    @Test(priority = 1,groups = {"Regression"})
    public void test_account_Registration(){

        logger.debug("Accounting test...");
        logger.info("Start test TC_001_AccountRegistrationTest");
        try{

        hp.clickMyAccount(driver);
        logger.info("Click My account");
        hp.clickRegister(driver);
        logger.info("Click register link");


        logger.info("Providing customer data");
        regpage.setFirstName(driver,randomeString().toUpperCase());
        regpage.setLastName(driver,randomeString().toUpperCase());
        regpage.setEmail(driver,randomeString()+"@gmail.com");
        regpage.setTelephone(driver,randomeNumber());
        regpage.setPassword(driver,"123456");
        regpage.setConfirmPassword(driver,"123456");
        regpage.setPrivacyPolicy(driver);
        regpage.clickContinue(driver);

        String confmsg=regpage.getConfirmationMsg(driver);
        logger.info("Validating msg expect");
        Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");

        }catch(Exception e)
        {
            logger.info("Test failed");
            e.getStackTrace();
            Assert.fail();
        }
    }

    @Test(priority = 2)
    public void TC_RF_004(){
        try{
            hp.clickMyAccount(driver);
            hp.clickRegister(driver);

            regpage.clickContinue(driver);
            String actualTextFirstName = regpage.getTextDangeFirstName(driver);
            String actualTextLastName = regpage.getTextDangeLastName(driver);
            String actualTextEmail = regpage.getTextDangeEmail(driver);
            String actualPasswordConfirm = regpage.getTextDangePasswordConfirm(driver);

            String expectTextFirstName = "First Name must be between 1 and 32 characters!";
            String expectTextLastName = "Last Name must be between 1 and 32 characters!";
            String expectTextEmail = "E-Mail Address does not appear to be valid!";
            String expectPasswordConfirm = "E-Mail Address does not appear to be valid!";

            Assert.assertEquals(actualTextFirstName, expectTextFirstName, "True");
            Assert.assertEquals(actualTextLastName, expectTextLastName, "True");
            Assert.assertEquals(actualTextEmail, expectTextEmail, "True");
            Assert.assertEquals(actualPasswordConfirm, expectPasswordConfirm, "True");
        }catch (Exception e){
            e.getStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
