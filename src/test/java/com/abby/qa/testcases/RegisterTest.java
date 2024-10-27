package com.abby.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abby.qa.base.Base;
import com.abby.qa.utils.Utilities;

public class RegisterTest extends Base {

	WebDriver driver;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		driver = inisalizeBrowserOpenUrl(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	@Test(priority = 1)
	public void VerifyRegisterWithMandatoryFields() {

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("input-firstname");
		driver.findElement(By.id("input-lastname")).sendKeys("input-lastname");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.getTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("123456789");
		driver.findElement(By.id("input-password")).sendKeys("aaa1234");
		driver.findElement(By.id("input-confirm")).sendKeys("aaa1234");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualErrorMassage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		System.out.println(actualErrorMassage);
		String expectedErrorMassage = "Your Account Has Been Created";
		Assert.assertTrue(actualErrorMassage.contains(expectedErrorMassage), "Error");

	}

	@Test(priority = 2)
	public void VerifyRegisterWithAllFields() {

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("input-firstname");
		driver.findElement(By.id("input-lastname")).sendKeys("input-lastname");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.getTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("123456789");
		driver.findElement(By.id("input-password")).sendKeys("aaa1234");
		driver.findElement(By.id("input-confirm")).sendKeys("aaa1234");

		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualErrorMassage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		System.out.println(actualErrorMassage);
		String expectedErrorMassage = "Your Account Has Been Created";
		Assert.assertTrue(actualErrorMassage.contains(expectedErrorMassage), "Error");

	}
	
	@Test(priority = 2)
	public void VerifyRegisterWithExistingEmail() {

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("input-firstname");
		driver.findElement(By.id("input-lastname")).sendKeys("input-lastname");
		driver.findElement(By.id("input-email")).sendKeys("amotooricap4@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123456789");

		driver.findElement(By.id("input-password")).sendKeys("aaa1234");
		driver.findElement(By.id("input-confirm")).sendKeys("aaa1234");

		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String actualErrorMassage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println(actualErrorMassage);
		String expectedErrorMassage = "Warning: E-Mail Address is already registered";
		Assert.assertTrue(actualErrorMassage.contains(expectedErrorMassage), "Error");

	}

}
