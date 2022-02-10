package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass{
	
	IndexPage index;
	SearchResultPage search;
	AddToCartPage addToCart;
	OrderPage order;
	AddressPage address;
	LoginPage login;
	
	@BeforeMethod
	public void setup() {
		launchApp("Chrome");
	}
	
	@Test
	public void verifyTotalPriceTest() throws Throwable {
		index= new IndexPage();
		search = new SearchResultPage();
		search = index.searchProduct("T-Shirt");
		addToCart=new AddToCartPage();			
		addToCart=search.clickOnProduct();
		order = new OrderPage();
		addToCart.clickOnAddToCart();
		order =addToCart.clickOnCheckOut();
		double calculatedPrice =order.calculateTotalCharges();
		double expectedPrice = order.getTotalPrice();
		Assert.assertEquals(calculatedPrice, expectedPrice);

	}
	
	@Test
	public void proceedToCheckoutTest() throws Throwable {
		index= new IndexPage();
		search = new SearchResultPage();
		search = index.searchProduct("T-Shirt");
		addToCart=new AddToCartPage();			
		addToCart=search.clickOnProduct();
		order = new OrderPage();
		addToCart.clickOnAddToCart();
		address = new AddressPage();
		order =addToCart.clickOnCheckOut();		
		login = new LoginPage();
		login = order.clickOnCheckOut();
		address = new AddressPage();
		address =login.login1(prop.getProperty("username"), prop.getProperty("password"));
		boolean status= address.varifyAddressPage();
		Assert.assertTrue(status, "Not landed on Address page");
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
