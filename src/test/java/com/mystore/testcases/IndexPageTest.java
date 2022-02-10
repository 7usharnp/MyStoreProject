package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser);
	}
	
	/*
	 * @Test(groups="Smoke") public void verifyLogo() { indexPage = new IndexPage();
	 * Assert.assertTrue(indexPage.validateLogo(),"logo not found on page.."); }
	 */
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		indexPage= new IndexPage();
		String ActualTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(ActualTitle, "My Store");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	

}
