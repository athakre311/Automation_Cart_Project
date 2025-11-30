package com.abby.qa.testcases;

import com.abby.qa.base.Base;
import com.abby.qa.pages.AE_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AE_LoginTest extends Base {

    public WebDriver driver;
    AE_HomePage aE_HomePage;
    @BeforeMethod
    public void setup(){
        driver = inisalizeBrowserOpenUrl("Chrome");
        aE_HomePage = new AE_HomePage(driver);
    }

    @AfterMethod
    public void teardown01(){
        driver.close();
    }

    @Test
    public void aELoginTest01(){
        System.out.println("Hello");
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'

//        3. Verify that home page is visible successfully
//          String str = driver.findElement(By.xpath("//li//a[@href='/']")).getAttribute("style");
        String str = aE_HomePage.getHomePageAttri();
                System.out.println(str);
//        4. Click on 'Signup / Login' button
//        5. Verify 'Login to your account' is visible
//        6. Enter correct email address and password
//        7. Click 'login' button
//        8. Verify that 'Logged in as username' is visible
//        9. Click 'Delete Account' button
//        10. Verify that 'ACCOUNT DELETED!' is visible
    }
}
