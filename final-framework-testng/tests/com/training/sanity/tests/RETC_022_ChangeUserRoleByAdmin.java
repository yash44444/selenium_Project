package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AllUserLinksPOM;
import com.training.pom.LoginRegUserPOM;
import com.training.pom.UsersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_022_ChangeUserRoleByAdmin {

	private WebDriver driver;
	private String baseUrl;
	private LoginRegUserPOM loginRegUserPOM;
	private UsersPOM usersPOM;
	private AllUserLinksPOM allUserLinksPOM;
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
		loginRegUserPOM = new LoginRegUserPOM(driver);
		usersPOM = new UsersPOM(driver);
		allUserLinksPOM = new AllUserLinksPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		Thread.sleep(10000);
	}

	/*
	 * @AfterClass public void tearDown() throws Exception { Thread.sleep(1000);
	 * driver.quit(); }
	 */

	@Test(priority = 0)
	public void adminLoginTest() throws InterruptedException {
		loginRegUserPOM.clickSignInLink();
		Thread.sleep(4000);
		loginRegUserPOM.sendUserName("admin");
		loginRegUserPOM.sendPwd("admin@123");
		loginRegUserPOM.clickSignInBtn();
		Thread.sleep(4000);
		screenShot.captureScreenShot("TC22_login");
	}

	@Test(priority = 1)
	public void clickUsersLinkTest() throws InterruptedException {
		usersPOM.clickUsersLink();
		Thread.sleep(4000);
		screenShot.captureScreenShot("TC22_userslink");
	}

	@Test(priority = 2)
	public void changeUserRoleTest() throws InterruptedException {
		allUserLinksPOM.clickAllUsersLink();
		allUserLinksPOM.clickCheckbox();
		allUserLinksPOM.clickListbox();
		allUserLinksPOM.changeRoleShopManager();
		allUserLinksPOM.clickChangeBtn();
		Thread.sleep(10000);
		screenShot.captureScreenShot("TC22_rolechanged");
	}

}
