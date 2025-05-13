package com.abby.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
    WebDriver driver;

    @Test
    public void demo001(){
        System.out.println("Hello");
        driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/");
    }
}
