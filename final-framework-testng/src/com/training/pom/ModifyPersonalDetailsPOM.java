package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModifyPersonalDetailsPOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
	
	public ModifyPersonalDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-firstname")
	private WebElement editfirstName;
	
	@FindBy(id="input-lastname")
	private WebElement editlastName;
	
	@FindBy(id="input-email")
	private WebElement editEmail;
	
	@FindBy(id="input-telephone")
	private WebElement editTelephone;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement contibueBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement updateSuccess;
	
	
	public void editfirstName(String firstname) {
		this.editfirstName.clear();
		this.editfirstName.sendKeys(firstname);
	}
	
	public void editlastName(String lastname) {	
		this.editlastName.clear();
		this.editlastName.sendKeys(lastname);
	}
	
	public void editEmail(String email) {
		this.editEmail.clear();
		this.editEmail.sendKeys(email);
	}
	
	public void editTelephone(String phone) {
		this.editTelephone.clear();
		this.editTelephone.sendKeys(phone);
	}
	
	public void continueBtn() {
		this.contibueBtn.click();			
	}
	
	public String updateSuccess() {
		String success = this.updateSuccess.getText();	
		return success;
	}
	

}
