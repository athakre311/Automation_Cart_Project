package com.abby.qa.testcases;

import com.abby.qa.pages.AccountPage;
import com.abby.qa.pages.HomePage;
import com.abby.qa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.abby.qa.base.Base;
import com.abby.qa.utils.Utilities;

public class LoginTest extends Base{
	
	public LoginTest() {
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
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority=1, dataProvider="supplyTestData")
	public void TC_LF_001_loginWithValidCredentials(String email, String password) {
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickonLoginButton();
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getExpectedMassage(),"Edit your account information option is not displayed");
	}

	@DataProvider
	public Object[][] supplyTestData(){
		Object[][] data = {{"amotooricap4@gmail.com","12345"}};
//		Object[][] data = {{"amotooricap4@gmail.com","12345"},{"amotooricap41@gmail.com","123345"},{"amotooricap4@gmail.com","12345"}};
//		Object[][] data = Utilities.getTestDataFromExcel("Sheet1");
		return data;
	}

	@Test (priority=2)
	public void TC_LF_002_loginWithInvalidCredentials() {
		loginPage.enterEmail(Utilities.getTimeStamp());
		loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
		loginPage.clickonLoginButton();
		String actualErrorMassage = loginPage.getwarningMassage();
		Assert.assertTrue(actualErrorMassage.contains(dataprop.getProperty("expectedErrorMassage")), "Invalid error massage");
	}

	@Test (priority=3)
	public void TC_LF_003_loginWithInvalidEmailValidPass() {
		loginPage.enterEmail(Utilities.getTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickonLoginButton();
		String actualErrorMassage = loginPage.getwarningMassage();
		Assert.assertTrue(actualErrorMassage.contains(dataprop.getProperty("expectedErrorMassage")), "Invalid error massage");
	}

	@Test (priority=4)
	public void TC_LF_004_loginWithValidEmailInvalidPass() {
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
		loginPage.clickonLoginButton();
		String actualErrorMassage = loginPage.getwarningMassage();
		Assert.assertTrue(actualErrorMassage.contains(dataprop.getProperty("expectedErrorMassage")), "Invalid error massage");
	}

	@Test (priority=5)
	public void TC_LF_005_loginWithoutCerdentials() {
		loginPage.clickonLoginButton();
		String actualErrorMassage = loginPage.getwarningMassage();
		Assert.assertTrue(actualErrorMassage.contains(dataprop.getProperty("expectedErrorMassage")), "Invalid error massage");
	}

}
