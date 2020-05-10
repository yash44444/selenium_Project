package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformStoreLoginPOM {
	@SuppressWarnings("unused")
	private WebDriver driver;

	public UniformStoreLoginPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement login;

	@FindBy(id = "input-email")
	private WebElement userName;

	@FindBy(id = "input-password")
	private WebElement userPassword;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginbtn;

	public void accountLogin() {
		this.myAccount.click();
		this.login.click();
	}

	public void sendUserName(String userName) {
		this.userName.sendKeys(userName);
	}

	public void sendUserPassword(String password) {
		this.userPassword.sendKeys(password);
	}

	public void submit() {
		this.loginbtn.click();

	}
}
