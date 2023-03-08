package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_005_Search extends BaseClass {

    HomePage homePage = new HomePage();

    @Test
    public void TC_SF_001(){
        try{
            homePage.inputSearch(driver,rb.getString("searchData"));
            homePage.btnSearch(driver);

            boolean searchData = homePage.isSearchData(driver);
            Assert.assertTrue(searchData);

        }catch (Exception e){
            e.getStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void TC_SF_002(){
        try{
            homePage.inputSearch(driver, rb.getString("searchNoData"));
            homePage.btnSearch(driver);

            
        }catch (Exception e){
            e.getStackTrace();
            Assert.fail();
        }
    }

}
