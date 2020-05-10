package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
	
	public ChangePasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement changePasswordlink;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement pswChangeSuccess;
	
	public void changePasswordlink() {
		this.changePasswordlink.click();
	}
	
	public void password(String psw) {
		this.password.sendKeys(psw); 
	}
	
	public void confirmPassword(String confirmpsw) {
		this.confirmPassword.sendKeys(confirmpsw); 
	}
	
	public void continueButton() {
		this.continueButton.click();; 
	}
	
	public String pswChangeSuccess() {
		String pswMessage=this.pswChangeSuccess.getText(); 
		return pswMessage;
	}
}
