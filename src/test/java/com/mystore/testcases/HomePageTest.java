package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	IndexPage index;
	HomePage home;
	LoginPage lp;
	

	@BeforeMethod
	public void setup() {
		launchApp("Chrome");
	}
	
	@Test
	public void verifyMyWishListTest() {
		index= new IndexPage();
		lp = new LoginPage();
		lp =index.clickOnSignIn();
		home = new HomePage();
		home =lp.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean status =home.validateMyList();
		Assert.assertTrue(status, "Validate my list not present on the page");
		
		
	}
	
	@Test
	public void VerifyOrderHistoryTest() throws Throwable {
		index = new IndexPage();
		lp = new LoginPage();
		lp =index.clickOnSignIn();
		home =new HomePage();
		home=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean status = home.validateOrderHistory();
		Assert.assertTrue(status, "order history and detail section not present on page");
	}
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
}
