package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    String inputSearchXpath = "//input[@id='input-search']";
    String selectCategorySearchXpath = "//select[@name='category_id']";

    public boolean isInputSearch(WebDriver driver){
        try {
            WebElement inputSearch = driver.findElement(By.xpath(inputSearchXpath));
            return (inputSearch.isDisplayed());
        }catch (Exception e){
            return(false);
        }
    }

    public boolean isSelectCategorySearch(WebDriver driver){
        try {
            WebElement selectCategorySearch = driver.findElement(By.xpath(selectCategorySearchXpath));
            return (selectCategorySearch.isDisplayed());
        }catch (Exception e){
            return(false);
        }
    }
}
