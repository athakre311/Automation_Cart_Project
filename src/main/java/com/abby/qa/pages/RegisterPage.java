package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement inputFirstname;

    @FindBy(id = "input-lastname")
    private WebElement inputLastname;

    @FindBy(id = "input-email")
    private WebElement inputEmaile;

    @FindBy(id = "input-telephone")
    private WebElement inputTelephone;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    @FindBy(id = "input-confirm")
    private WebElement subscribeLable;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement actualErrorMassage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement getEmailExistErrorMassage;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstname(String f){
        inputFirstname.sendKeys(f);
    }

    public void enterLastname(String laststName){
        inputLastname.sendKeys(laststName);
    }

    public void enterEmail(String email){
        inputEmaile.sendKeys(email);
    }

    public void enterTelephone(String telephone){
        inputTelephone.sendKeys(telephone);
    }

    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String confPassword){
        confirmPassword.sendKeys(confPassword);
    }

    public void clickOnSubscribeLable(){
        subscribeLable.click();
    }

    public void clickPrivacyPolicyCheckbox(){
        privacyPolicyCheckbox.click();
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public String getActualErrorMassage(){
        return actualErrorMassage.getText();
    }

    public String getEmailExistErrorMassage(){
        return getEmailExistErrorMassage.getText();
    }



}
