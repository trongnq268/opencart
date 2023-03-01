package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Regression"})
    public void test_account_Registration(){

        logger.debug("Accounting test...");
        logger.info("Start test TC_001_AccountRegistrationTest");
        try{
        HomePage hp = new HomePage(driver);

        hp.clickMyAccount();
        logger.info("Click My account");
        hp.clickRegister();
        logger.info("Click register link");
        AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

        logger.info("Providing customer data");
        regpage.setFirstName(randomeString().toUpperCase());
        regpage.setLastName(randomeString().toUpperCase());
        regpage.setEmail(randomeString()+"@gmail.com");
        regpage.setTelephone(randomeNumber());
        regpage.setPassword("123456");
        regpage.setConfirmPassword("123456");
        regpage.setPrivacyPolicy();
        regpage.clickContinue();

        String confmsg=regpage.getConfirmationMsg();
        logger.info("Validating msg expect");
        Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");

        }catch(Exception e)
        {
            logger.info("Test failed");
            Assert.fail();
        }
    }
}
