package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    String inputSearchXpath = "//input[@id='input-search']";
    String selectCategorySearchXpath = "//select[@name='category_id']";
    String btnSearchXpath = "//input[@id='button-search']";
    String checkboxCss = "#description";

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

    public void inputSearch(WebDriver driver, String productName){
        WebElement inputSearch = driver.findElement(By.xpath(inputSearchXpath));
        inputSearch.sendKeys(productName);
    }

    public void clickBtnSearch(WebDriver driver){
        WebElement btnSearch = driver.findElement(By.xpath(btnSearchXpath));
        btnSearch.click();
    }

    public void clickCheckbox(WebDriver driver){
        Boolean isSelected = driver.findElement(By.cssSelector(checkboxCss)).isSelected();

        if(!isSelected)
        {
            driver.findElement(By.cssSelector(checkboxCss)).click();
        }

    }
}
