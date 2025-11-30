package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_HomePage {

    WebDriver driver;

    @FindBy (xpath="//li//a[@href='/']")
    WebElement ele;

    public AE_HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageAttri(){
        return ele.getAttribute("style");
    }
}
