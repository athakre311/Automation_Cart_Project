package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountDropMenu;

    @FindBy(xpath = "//li//a[contains(@href,'account/login')]")
    private WebElement loginOption;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(@href,'account/register')]")
    private WebElement registerOption;

    @FindBy(xpath="//div[@id='search']//input")
    private WebElement searchBox;

    @FindBy(xpath="//span//button")
    private WebElement searchButton;



    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccount(){
        myAccountDropMenu.click();
    }

    public void selectLoginOption(){
        loginOption.click();
    }

    public void selectRegisterOption(){
        registerOption.click();
    }

    public void EnterTextInsearchBox(String str){
        searchBox.sendKeys(str);
    }

    public void clickSearchButton(){
        searchButton.click();
    }



}
