package com.abby.qa.testcases;

import com.abby.qa.pages.HomePage;
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
	
	WebDriver driver;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		driver = inisalizeBrowserOpenUrl(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority=1, dataProvider="supplyTestData")
	public void TC_LF_001_loginWithValidCredentials(String email, String password) {
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//li//a[contains(@href,'edit')]")).isDisplayed());
	}

	@DataProvider
	public Object[][] supplyTestData(){
		Object[][] data = {{"amotooricap9@gmail.com","123445"},{"amotooricap41@gmail.com","123345"},{"amotooricap4@gmail.com","12345"}};
//		Object[][] data = Utilities.getTestDataFromExcel("Sheet1");
		return data;
	}
	
	@Test (priority=2)
	public void TC_LF_002_loginWithInvalidCredentials() {
		driver.findElement(By.id("input-email")).sendKeys(Utilities.getTimeStamp());
		System.out.println(driver.findElement(By.id("input-email")).getAttribute("value"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualErrorMassage = driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
		Assert.assertTrue(actualErrorMassage.contains(dataprop.getProperty("expectedErrorMassage")), "Invalid error massage");
	}

	@Test (priority=2)
	public void TC_LF_003_loginWithInvalidEmailValidPass() {
		driver.findElement(By.id("input-email")).sendKeys(Utilities.getTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualErrorMassage = driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
		Assert.assertTrue(actualErrorMassage.contains(dataprop.getProperty("expectedErrorMassage")), "Invalid error massage");
	}

}
