package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver;

    @FindBy  (xpath ="(//li//a[contains(@href,'cart')])[3]")
    private WebElement ShoppingCartPage;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String ShoppingCartPageOption(){
        return ShoppingCartPage.getText();
    }

}
