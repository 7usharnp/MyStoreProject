package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest  extends BaseClass{

	IndexPage index;
	SearchResultPage search;
	AddToCartPage addToCart;
	OrderPage order;
	@BeforeMethod
	public void setup() {
		launchApp("Chrome");
	}
	
	@Test()
	public void ProductAvailabilityTest() {
		index= new IndexPage();
		search = new SearchResultPage();
		search = index.searchProduct("T-Shirt");
		boolean status= search.isProductAvailable();
		Assert.assertTrue(status,"Product is not available");
		
		
	}
	
	@Test()
	public void addToCartTest() throws Throwable {
		index= new IndexPage();
		search = new SearchResultPage();
		search = index.searchProduct("T-Shirt");
		addToCart=new AddToCartPage();			
		addToCart=search.clickOnProduct();
		
		
	}
	
	@Test
	public void proceedToCheckOut() throws Throwable {
		index= new IndexPage();
		search = new SearchResultPage();
		search = index.searchProduct("T-Shirt");
		addToCart=new AddToCartPage();			
		addToCart=search.clickOnProduct();
		order = new OrderPage();
		addToCart.clickOnAddToCart();
		order =addToCart.clickOnCheckOut();
		String Title =order.getPageTitle();
		//Assert.assertEquals(Title, "SHOPPING-CART SUMMARY");
	}
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
