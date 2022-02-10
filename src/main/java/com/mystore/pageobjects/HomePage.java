package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyList() {
	 boolean isDisplayed=	myWishList.isDisplayed();
	 return isDisplayed;
	}
	
	public String getTitle() {
	   String  Title =getDriver().getTitle();
	   return Title;
	}
	public boolean validateOrderHistory() throws Throwable {
		return orderHistory.isDisplayed();
	}
}
