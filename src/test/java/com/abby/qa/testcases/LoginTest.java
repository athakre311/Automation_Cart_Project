package com.abby.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abby.qa.base.Base;
import com.abby.qa.utils.Utilities;

public class LoginTest extends Base{
	
	public LoginTest() {
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = inisalizeBrowserOpenUrl(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority=1)
	public void loginWithValidCredentials() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//li//a[contains(@href,'account/login')]")).click();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//li//a[contains(@href,'edit')]")).isDisplayed());
	}
	
	@Test (priority=2)
	public void loginWithInvalidCredentials() {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//li//a[contains(@href,'account/login')]")).click();
		driver.findElement(By.id("input-email")).sendKeys(Utilities.getTimeStamp());
		System.out.println(driver.findElement(By.id("input-email")).getAttribute("value"));
		driver.findElement(By.id("input-password")).sendKeys("1q2345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualErrorMassage = driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
		String expectedErrorMassage = "Warning: No match for E-Mail Address and/or Password";
		
		Assert.assertTrue(actualErrorMassage.contains(expectedErrorMassage), "Invalid error massage");
		

	}

}
