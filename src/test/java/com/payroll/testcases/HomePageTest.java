package com.payroll.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payroll.baseclass.BaseClass;
import com.payroll.pageobjects.HomePage;
import com.payroll.pageobjects.LoginPage;
import com.payroll.utilities.Log;

public class HomePageTest extends BaseClass {
	

	@Parameters("browser")
	@BeforeMethod(groups= {"smoke"})
	public void launching(String browser) {
		launchApp(browser);
	}
	
	
	

	@Test(priority = 5)
	public void validateHomeScreenMesg() {
		Log.startTestCase("Entered into the homepage");
		LoginPage loginpg = new LoginPage();
		loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		String actual = home.validateAppDetails();
		String expected = "PAYROLL APPLICATION";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 6)
	public void homeValidateLogo() throws InterruptedException {
		LoginPage loginpg = new LoginPage();
		HomePage home = new HomePage();
		loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean expected = true;
		boolean actual = home.validateLogo();
		Assert.assertEquals(actual, expected);

	}

	@AfterMethod
	public void closeBrowser() {
		getDriver().close();
	}
}
