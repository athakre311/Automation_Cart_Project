package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "input-email")
    private WebElement emailInputBox;

    @FindBy(id = "input-password")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    private WebElement warningMassage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email){
        emailInputBox.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInputBox.sendKeys(password);
    }

    public void clickonLoginButton(){
        loginButton.click();
    }

    public String getwarningMassage(){
        return warningMassage.getText();
    }
}
