package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPOM {
	@SuppressWarnings("unused")
	private WebDriver driver;

	public MyAccountPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[contains(text(),'Edit your')]")
	private WebElement editInfo;

	public void editAccount() {
		this.editInfo.click();
	}

}
