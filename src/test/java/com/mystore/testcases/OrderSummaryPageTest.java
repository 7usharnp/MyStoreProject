package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;

public class OrderSummaryPageTest extends BaseClass {
	IndexPage index;
	SearchResultPage search;
	AddToCartPage addToCart;
	OrderPage order;
	AddressPage address;
	ShippingPage shipping;
	LoginPage login;
	PaymentPage pay;
	OrderSummaryPage ordersumPage;
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
		shipping.checkTheTerms();
		 pay= new PaymentPage();
		pay = shipping.clickOnProceedToCheckOut();
		ordersumPage = new OrderSummaryPage();
		pay.clickOnPaymentMethod();
		ordersumPage.clickOnconfirmOrderBtn();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
}
