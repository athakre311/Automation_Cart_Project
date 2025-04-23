package com.abby.qa.testcases;

import com.abby.qa.base.Base;
import com.abby.qa.pages.AccountPage;
import com.abby.qa.pages.HomePage;
import com.abby.qa.pages.LoginPage;
import com.abby.qa.utils.Utilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCart extends Base{


	 // Hello Abby
	public AddToCart() {
		super();
	}
	
	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;

	@BeforeMethod
	public void setup() {
		driver = inisalizeBrowserOpenUrl(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		loginPage = new LoginPage(driver);
	}
	
//	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	public void login01() {
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickonLoginButton();
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getExpectedMassage(),"Edit your account information option is not displayed");
	}


}
