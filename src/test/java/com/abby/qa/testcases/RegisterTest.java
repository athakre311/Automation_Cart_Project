package com.abby.qa.testcases;

import com.abby.qa.pages.HomePage;
import com.abby.qa.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abby.qa.base.Base;
import com.abby.qa.utils.Utilities;

public class RegisterTest extends Base {

	public WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = inisalizeBrowserOpenUrl(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectRegisterOption();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void VerifyRegisterWithMandatoryFields() {
		registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.getTimeStamp());
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickPrivacyPolicyCheckbox();
		registerPage.clickOnSubmitButton();
		String actualErrorMassage = registerPage.getActualErrorMassage();

		System.out.println(actualErrorMassage+">>>");
		String expectedErrorMassage = "Your Account Has Been Created";
		Assert.assertTrue(actualErrorMassage.contains(expectedErrorMassage), "Error");

	}

	@Test(priority = 2)
	public void VerifyRegisterWithAllFields() {

		registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.getTimeStamp());
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnSubscribeLable();
		registerPage.clickPrivacyPolicyCheckbox();
		registerPage.clickOnSubmitButton();

		String actualErrorMassage = registerPage.getActualErrorMassage();

		System.out.println(actualErrorMassage+">>>");
		String expectedErrorMassage = "Your Account Has Been Created";
		Assert.assertTrue(actualErrorMassage.contains(expectedErrorMassage), "Error");

	}
	
	@Test(priority = 3)
	public void VerifyRegisterWithExistingEmail() {

		registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("validEmail"));
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnSubscribeLable();
		registerPage.clickPrivacyPolicyCheckbox();
		registerPage.clickOnSubmitButton();

		String actualErrorMassage = registerPage.getEmailExistErrorMassage();
		System.out.println(actualErrorMassage+">>>");
		String expectedErrorMassage = "Warning: E-Mail Address is already registered";
		Assert.assertTrue(actualErrorMassage.contains(expectedErrorMassage), "Error");
	}

}
