package testCases;

import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginAccountPage extends BaseClass {

    @Test
    public void testLoginAccount() {

        logger.info("***Start test LoginAccount...**");
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setEmail(rb.getString("email"));
        lp.setPassword(rb.getString("password"));
        lp.clickLogin();

    }

}
