package com.abby.qa.testcases;

import com.abby.qa.base.Base;
import com.abby.qa.pages.AccountPage;
import com.abby.qa.pages.HomePage;
import com.abby.qa.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends Base {

    public HomePageTest() {
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

    @Test(priority=1)
    public void TC_LF_001_loginWithValidCredentials() {
        loginPage.enterEmail(prop.getProperty("validEmail"));
        loginPage.enterPassword(prop.getProperty("validPassword"));
        loginPage.clickonLoginButton();
        homePage.clickLogo();
    }
}
