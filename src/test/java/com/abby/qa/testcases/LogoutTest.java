package com.abby.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogoutTest {

    @Test
    public void verifyLogout(){
        System.out.println("Hello");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/");
    }

}
