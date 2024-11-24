package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    WebDriver driver;

    @FindBy(xpath = "//li//a[contains(@href,'edit')]")
    private WebElement expectedMassage;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }

    public boolean getExpectedMassage()
    {
        expectedMassage.isDisplayed();
        return false;
    }

}
