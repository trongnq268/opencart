package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.SearchPage;
import testBase.BaseClass;

public class TC_005_Search extends BaseClass {

    HomePage homePage = new HomePage();
    SearchPage  searchPage = new SearchPage();
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

            String expectTextSearchNoData = "There is no product that matches the search criteria";
            String actualTextSearchNoData = homePage.getTextSearchNoData(driver);
            Assert.assertEquals(expectTextSearchNoData, actualTextSearchNoData);

        }catch (Exception e){
            e.getStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void TC_SF_003(){
        try{
            homePage.btnSearch(driver);

            String expectTextSearchNoData = "There is no product that matches the search criteria";
            String actualTextSearchNoData = homePage.getTextSearchNoData(driver);
            Assert.assertEquals(expectTextSearchNoData, actualTextSearchNoData);

        }catch(Exception e){
            e.getStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void TC_SF_005(){
        try{
            homePage.inputSearch(driver,rb.getString("searchListProducts"));
            homePage.btnSearch(driver);

            int coutProduct = homePage.productLayout(driver);
            Assert.assertTrue(coutProduct >= 2);

        }catch (Exception e){
            e.getStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void TC_SF_006(){
        try{
            homePage.btnSearch(driver);
            boolean InputSearch = searchPage.isInputSearch(driver);
            boolean CategoriesSearch = searchPage.isSelectCategorySearch(driver);

            Assert.assertTrue(InputSearch);
            Assert.assertTrue(CategoriesSearch);

        }catch (Exception e){
            e.getStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void TC_SF_007(){
        try{
            homePage.btnSearch(driver);

            searchPage.inputSearch(driver, rb.getString("searchData"));
            searchPage.clickBtnSearch(driver);

            boolean searchData = homePage.isSearchData(driver);
            Assert.assertTrue(searchData);
        }catch (Exception e) {
            e.getStackTrace();
            Assert.fail();
        }
    }



}
