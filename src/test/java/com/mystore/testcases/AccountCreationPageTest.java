package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass{
	IndexPage index;
	LoginPage Login;
	AccountCreationPage account;

	@BeforeMethod
	public void setup() {
		launchApp("Chrome");
	}
	
	@Test
	public void AccountCreateTest() {
		index = new IndexPage();	
		Login = new LoginPage();
		Login = index.clickOnSignIn();
		account = new AccountCreationPage();
		account =Login.createNewAccount("sandesh682@gmail.com");
		boolean status =account.validateAccountCreatePage();
		Assert.assertTrue(status,"Not landed on create account page....");
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
