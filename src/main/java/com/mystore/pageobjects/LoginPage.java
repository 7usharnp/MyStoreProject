package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String username,String pwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		signInBtn.click();
		return new HomePage();
		
	}
	
	public AddressPage login1(String username,String pwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		signInBtn.click();
		return new AddressPage();
		
	}
	
	public AccountCreationPage createNewAccount(String email) {
		emailForNewAccount.sendKeys(email);
		createNewAccountBtn.click();
		return new AccountCreationPage();
	}

}
