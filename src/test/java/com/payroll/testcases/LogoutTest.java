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
import com.payroll.pageobjects.Logout;
import com.payroll.utilities.Log;

public class LogoutTest extends BaseClass {

	@Parameters("browser")
	@BeforeMethod(groups= {"smoke"})
	public void launching(String browser) {
		launchApp(browser);
	}

	@Test(priority = 27, groups = {"smoke" })
	public void logoutVerify() {
		Log.startTestCase("PAYROLL APPLICATION: verify Logout");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.validateLogOut();
		Logout out = new Logout();
		String actual = out.verifyLogOutFeature();
		String expected = "https://www.qabible.in/payrollapp/site/login";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 28)
	public void logoutFullProfileLinkVerify() {

		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.validateLogOut();
		Logout out = new Logout();
		String actual = out.verifyFullProfileViewErrorFeature();
		System.out.println(actual);
		String expected = "You are not allowed to perform this action.";
		Assert.assertEquals(actual, expected);

	}

	@AfterMethod
	public void closeBrowser() {
		getDriver().close();
	}

}