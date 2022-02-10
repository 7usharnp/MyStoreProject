package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{

	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;
	
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	@FindBy(id = "cart_title")
	private WebElement cartTitle;
	
	@FindBy(className="cart_quantity_input")
	private WebElement Qty;
	
	@FindBy(id="total_shipping")
	private WebElement shippingCharges;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public int getQuantity() {
		String Quantity= Qty.getAttribute("value");
		System.out.println("Quantity :"+Quantity );
		int qty = Integer.parseInt(Quantity);
		return qty;
	}
	
	public LoginPage clickOnCheckOut() throws Throwable {
		proceedToCheckOut.click();
		return new LoginPage();
	}
	
	public double getShippingCharges() {
		String shippingCharge= shippingCharges.getText();
		String shippingCharges=shippingCharge.replaceAll("[^a-zA-Z0-9]","");
		double finalShippingCharges=Double.parseDouble(shippingCharges);
		return finalShippingCharges/100;
	}
	
	public String getPageTitle() {
		String PageTitle= cartTitle.getText();
		return PageTitle;
	}
	
	public double calculateTotalCharges() {
		OrderPage order = new OrderPage();
		double TotalCharges = order.getUnitPrice()*order.getQuantity()+order.getShippingCharges();
		return TotalCharges;
	}
	
	
}
