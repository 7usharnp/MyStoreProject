package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;


public class LoginPageTest extends BaseClass{
	IndexPage index ;
	HomePage home;
	LoginPage login;
	@BeforeMethod
	public void setup() {
		launchApp("Chrome");
	}
	
	@Test(dataProviderClass=DataProviders.class,dataProvider = "credentials" ,groups= {"Sanity","Smoke"})
	//@Test
	public void LoginTest(String username,String pwd) {
		Log.startTestCase("LoginTest");
		index = new IndexPage();
		Log.info("Landed on index page");
		login = new LoginPage();
		login =index.clickOnSignIn();
		home = new HomePage();
		Log.info("Clicked on SingIn button.");
		home= login.login(username,pwd);
		Log.info("Entered user name: "+username +" password :"+pwd+" and clicked on login button");
		String ActualTile = home.getTitle();
		Assert.assertEquals(ActualTile, "My account - My Store","Login Unsuccessfull..");
		System.out.println("successfully logged in");
		Log.endTestCase("LoginTest");
	}
	
	/*
	 * @DataProvider(name="getData") public Object[][] getData(){ Object[][] data =
	 * new Object[2][2]; data[0][0]="tusharnangre5446@gmail.com";
	 * data[0][1]="8380802646"; data[1][0]="sandesh682@gmail.com";
	 * data[1][1]="12345"; return data; }
	 * 
	 */
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
