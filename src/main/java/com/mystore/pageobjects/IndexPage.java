package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	Action action= new Action();

	
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	//driver we got from the base class and after calling pageFactory init method all webelement of indexpage got loaded.
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
	    signInBtn.click();    
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		boolean status= myStoreLogo.isDisplayed();
		return status;
		
	}
	
	public String getMyStoreTitle() {
		String Mytitle = getDriver().getTitle();
		return Mytitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		searchProductBox.sendKeys(productName);
		searchButton.click();
		return new SearchResultPage();
	}
	
	
	
	
}
