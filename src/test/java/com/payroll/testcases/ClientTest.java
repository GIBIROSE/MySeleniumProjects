package com.payroll.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payroll.baseclass.BaseClass;
import com.payroll.pageobjects.Clients;
import com.payroll.pageobjects.HomePage;
import com.payroll.pageobjects.LoginPage;
import com.payroll.utilities.Log;

public class ClientTest extends BaseClass {

	public Clients client;
	public HomePage home;

	
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke"})
	public void launching(String browser) {
		launchApp(browser);
	}
	
	

	@Test(priority = 8, groups = { "smoke" })
	public void verifyClientSearch() throws InterruptedException {
		Log.startTestCase(" PAYROLL APPLICATION: client search button TC: ");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickClient();
		Clients client = new Clients();
		boolean result = client.searchDisplay();
		Assert.assertTrue(result);

	}

	@Test(priority = 9)
	public void verifySearchByName() throws Exception {
		Log.startTestCase(" PAYROLL APPLICATION TC search clients : ");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickClient();
		Clients client = new Clients();
		boolean result = client.searchClients();
		Assert.assertTrue(result);

	}

	@Test(priority = 10)
	public void verifySearchByID() throws Exception {
		Log.startTestCase(" PAYROLL APPLICATION  TC:  search by ID");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickClient();
		Clients client = new Clients();
		boolean result = client.searchClientByID();
		Assert.assertTrue(result);

	}

	@Test(priority = 11)
	public void verifyResetBtn() throws Exception {
		Log.startTestCase(" PAYROLL APPLICATION CLIENT TC: Reset btn verify ");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickClient();
		Clients client = new Clients();
		String expected=client.resetEnbledVerify();
		String actual="samantha";
		Assert.assertEquals(actual,expected);
	}

	@Test(priority = 12, groups = { "smoke" })
	public void verifyCreateClient() throws Exception {
		Log.startTestCase(" PAYROLL APPLICATION CLIENT TC: create client ");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickClient();
		Clients client = new Clients();
		client.createClientStep();
		boolean actual = client.createClientStep();
		boolean expected = true;
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 13)
	public void viewExistingUserVerify() {
		Log.startTestCase(" PAYROLL APPLICATION CLIENT TC: view details of existing client ");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickClient();
		Clients client = new Clients();
		boolean expected = client.viewExistngClient();
		boolean actual = true;
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 14)
	public void verifyEditExistingClient() {
		Log.startTestCase(" PAYROLL APPLICATION CLIENT TC: edit details of existing client ");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickClient();
		Clients client = new Clients();
		boolean expected = client.editExistingClient();
		boolean actual = true;
		Assert.assertEquals(actual, expected);

	}

	@AfterMethod
	public void closeBrowser() {
		getDriver().close();
	}

}
