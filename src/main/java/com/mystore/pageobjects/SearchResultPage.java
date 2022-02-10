package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {

	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable()  {
		boolean isDisplayed = productResult.isDisplayed();
		return isDisplayed;
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		productResult.click();
		return new AddToCartPage();
	}
}
