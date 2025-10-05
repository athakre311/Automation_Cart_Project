package com.abby.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abby.qa.base.Base;
import com.abby.qa.pages.HomePage;
import com.abby.qa.pages.LoginPage;
import com.abby.qa.pages.SearchPage;

public class WishList extends Base{
	
	public WebDriver driver;
	
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	@BeforeMethod
	public void setup() {
		driver = inisalizeBrowserOpenUrl(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		loginPage = new LoginPage(driver);
		searchPage = new SearchPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyWishList() {
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickonLoginButton();
		homePage.EnterTextInsearchBox("apple");
		homePage.clickSearchButton();
		searchPage.clickWishListIcon();
		String str1 = searchPage.getWishListAddsuccessMessage();
		String str2 = "Success: You have added Apple Cinema 30\" to your wish list!";
		Assert.assertTrue(str1.contains(str2));
		searchPage.clickWishListLink();
		System.out.println("hello");
	}

}
