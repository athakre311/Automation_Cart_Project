package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    @FindBy  (xpath ="//button//span[text()='Add to Cart']")
    private WebElement addToCart;

    @FindBy  (xpath ="//a[text()='shopping cart']")
    private WebElement  shoppingCart;
    
    @FindBy  (xpath ="//button[@data-original-title='Add to Wish List']")
    private WebElement wishListIcon;
    
    @FindBy  (xpath ="//div[contains(@class,'success')]")
    private WebElement WishListAddsuccessMessage;
    
    @FindBy  (xpath ="//a[contains(@href,'wishlist')]")
    private WebElement WishListLink;
    
    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCart(){
        addToCart.click();
    }

    public void clickShoppingCart(){
        shoppingCart.click();
    }
    
    public void clickWishListIcon(){
    	wishListIcon.click();
    }
    
    public void clickWishListLink(){
    	 WishListLink.click();
    }
    
    public String getWishListAddsuccessMessage(){
    	return WishListAddsuccessMessage.getText();
    }

}
