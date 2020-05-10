package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderHistoryPOM {
	@SuppressWarnings("unused")
	private WebDriver driver;

	public OrderHistoryPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'YASHU VERMA')]")
	private WebElement accountDropdown;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[contains(text(),'Order History')]")
	private WebElement orderHistory;
		
	@FindBy(xpath = "//a[@class='btn btn-info']")
	private WebElement view;
	
	public void orderHistory() {
		this.accountDropdown.click();
		this.orderHistory.click();

	}

	public void viewButton() {
		this.view.click();
	}

}
