package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ModifyPersonalDetailsPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.UniformStoreLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import junit.framework.Assert;

public class ModifyPersonalDetails_UFM_005 {

	// making changes again
	private WebDriver driver;
	private String baseUrl;
	private UniformStoreLoginPOM storeLogin;
	private MyAccountPOM myAccount;
	private ModifyPersonalDetailsPOM modifyPersonalDetails;
	private static Properties properties;
	private ScreenShot screenShot;

	// Hello 
	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		storeLogin = new UniformStoreLoginPOM(driver);
		myAccount = new MyAccountPOM(driver);
		modifyPersonalDetails = new ModifyPersonalDetailsPOM(driver);
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
		Thread.sleep(3000);
		System.out.println("Tryng the guthub push!");
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority=1)
	public void uniformLogin() {
		storeLogin.accountLogin();
		storeLogin.sendUserName("yash0002@gmail.com");
		storeLogin.sendUserPassword("welcome1231");
		storeLogin.submit();
		System.out.println("<--- Login Successfull --->");

	}

	@Test(priority=2)
	public void editingAccountInfo() {		
		System.out.println("<--- landed on edit Account page --->");
		myAccount.editAccount();
		System.out.println("<--- clicked on edit account information link --->");
		modifyPersonalDetails.editfirstName("yashu1");
		modifyPersonalDetails.editlastName("verma1");
		modifyPersonalDetails.editEmail("yash0003@gmail.com");
		modifyPersonalDetails.editTelephone("999999999");
		modifyPersonalDetails.continueBtn();
		System.out.println("<--- Account updated --->");
	}
	
	@Test(priority=3)
	public void AssertingSuccessMessage() {	
		String expectedsuccessMessage = "Success: Your account has been successfully updated.";
		Assert.assertEquals(expectedsuccessMessage, modifyPersonalDetails.updateSuccess());
		System.out.println(modifyPersonalDetails.updateSuccess() + " -- message printed");
		screenShot.captureScreenShot("UFM_005");

	}
}
