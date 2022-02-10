package com.mystore.testcases;

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
import com.mystore.pageobjects.ShippingPage;

public class AddressPageTest extends BaseClass {
	
	IndexPage index;
	SearchResultPage search;
	AddToCartPage addToCart;
	OrderPage order;
	AddressPage address;
	ShippingPage shipping;
	LoginPage login;
	
	@BeforeMethod
	public void setup() {
		launchApp("Chrome");
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
		shipping = new ShippingPage();
		address.clickOnCheckOut();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
}
