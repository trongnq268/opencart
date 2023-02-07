package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test
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
        regpage.setFirstName("test");
        regpage.setLastName("02");
        regpage.setEmail("test02@gmail.com");
        regpage.setTelephone("0974014022");
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
