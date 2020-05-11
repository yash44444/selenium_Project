package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.OrderConfirmationPOM;
import com.training.pom.UniformStoreLoginPOM;
import com.training.pom.OrderHistoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderHistory_UFM_004 {

	private WebDriver driver;
	private String baseUrl;
	private UniformStoreLoginPOM storeLogin;
	private OrderHistoryPOM order_History;
	private OrderConfirmationPOM orderConfirmation;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		System.out.println("Hello1234");
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		storeLogin = new UniformStoreLoginPOM(driver);
		order_History = new OrderHistoryPOM(driver);
		orderConfirmation = new OrderConfirmationPOM(driver);
		screenShot = new ScreenShot(driver);

		driver.get(baseUrl);
		Thread.sleep(2000);
		System.out.println("Hello1234");
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
	public void viewOrderHistory() {
		order_History.orderHistory();
		System.out.println("<--- Clicked on Order History --->");
		order_History.viewButton();
		System.out.println("<--- Clicked on view button --->");
		
	}
	
	@Test(priority=3)
	public void validateOrderHistory() {
		String Actual = "Order Information";
		Assert.assertEquals(Actual, orderConfirmation.confirmationPage());
		System.out.println("<--- landed on order information page.TC completed --->");
		screenShot.captureScreenShot("UFM_004");
		System.out.println("Screenshot captured!");
	}
}
