package com.abby.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abby.qa.base.Base;

public class SearchTest extends Base {

	WebDriver driver;
	
	public SearchTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = inisalizeBrowserOpenUrl(prop.getProperty("browser"));
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(priority = 1)
	public void VerifySearchWithValidProducts() {

		driver.findElement(By.xpath("//div[@id='search']/input")).sendKeys("iphone");
		driver.findElement(By.xpath("//span/button")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h4//a[contains(@href,'search=iphone')]")).isDisplayed(),
				"Error");
	}

	@Test(priority = 2)
	public void VerifySearchWithInalidProducts() {

		driver.findElement(By.xpath("//div[@id='search']/input")).sendKeys("Abhi");
		driver.findElement(By.xpath("//span/button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h2/following-sibling::p[1]")).getText(),
				"There is no product that matches the search criteria.", "Error");
	}
	
	@Test(priority = 3)
	public void VerifySearchWithoutdProducts() {

	
		driver.findElement(By.xpath("//span/button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h2/following-sibling::p[1]")).getText(),
				"There is no product that matches the search criteria.", "Error");
	}

}
