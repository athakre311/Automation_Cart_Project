package com.abby.qa.testcases;

import com.abby.qa.base.Base;
import com.abby.qa.pages.HomePage;
import com.abby.qa.pages.SearchPage;
import com.abby.qa.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Shopping_Cart extends Base {

    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    ShoppingCartPage shoppingCartPage;
    public Shopping_Cart(){
        super();
    }

    @BeforeMethod
    public void setup(){
        driver = inisalizeBrowserOpenUrl(prop.getProperty("browser"));
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }
@AfterMethod
public void tearDown(){
        driver.close();
}
    @Test
    public void TS_010_ShoppingCart(){
        homePage.EnterTextInsearchBox("iMac");
        homePage.clickSearchButton();
        searchPage.clickAddToCart();
        searchPage.clickShoppingCart();
        Assert.assertEquals("Shopping Cart",shoppingCartPage.ShoppingCartPageOption());
    }

}
