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
import com.training.pom.ChangePasswordPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.UniformStoreLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import junit.framework.Assert;

public class PasswordChange_UFM_006 {

	private WebDriver driver;
	private String baseUrl;
	private UniformStoreLoginPOM storeLogin;
	private ChangePasswordPOM changePassword;
	private static Properties properties;
	private ScreenShot screenShot;

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
		changePassword = new ChangePasswordPOM(driver);
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
		Thread.sleep(3000);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority=1)
	public void uniformLogin() {
		storeLogin.accountLogin();
		storeLogin.sendUserName("yash0003@gmail.com");
		storeLogin.sendUserPassword("welcome1231");
		storeLogin.submit();
		System.out.println("<--- Login Successfull --->");

	}

	@Test(priority=2)
	public void changePassword() {	
		changePassword.changePasswordlink();
		changePassword.password("welcome1232");
		changePassword.confirmPassword("welcome1232");
		changePassword.continueButton();
		
	}
	
	@Test(priority=3)
	public void AssertingSuccessMessage() {	
		String expectedsuccessMessage = "Success: Your password has been successfully updated.";
		Assert.assertEquals(expectedsuccessMessage,changePassword.pswChangeSuccess());
		System.out.println(changePassword.pswChangeSuccess() + " -- message printed");
		screenShot.captureScreenShot("UFM_006");


	}
}
