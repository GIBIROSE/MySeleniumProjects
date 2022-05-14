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
import com.payroll.pageobjects.Workers;
import com.payroll.utilities.Log;

public class WorkersTest extends BaseClass {

	@Parameters("browser")
	@BeforeMethod(groups= {"smoke"})
	public void launching(String browser) {
		launchApp(browser);
	}

	@Test(priority = 1)
	public void verifyClientSearch() throws InterruptedException {
		Log.startTestCase("PAYROLL APPLICATION: verify summary of workers list");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickWorkers();
		Workers work = new Workers();
		boolean result = work.searchDisplayWorkers();
		Assert.assertTrue(result);
	}

	@Test(priority = 2)
	public void verifyFirstNameSearchBtn() {
		Log.startTestCase("PAYROLL APPLICATION: verify search with first name possible");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickWorkers();
		Workers work = new Workers();
		boolean result = work.searchFirstName();
		Assert.assertTrue(result);

	}

	@Test(priority = 3)
	public void verifyCreateWorkerPossible() {
		Log.startTestCase("PAYROLL APPLICATION: verify create worker page comes or not");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickWorkers();
		Workers work = new Workers();
		boolean result = work.createWorkerVerify();
		Assert.assertTrue(result);

	}

	@Test(priority = 18)
	public void createNewWorker1() throws Exception {
		Log.startTestCase("PAYROLL APPLICATION: verif we can create new worker");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyClickWorkers();
		Workers work = new Workers();
		boolean result = work.enterCreateNewWorker();
		Assert.assertTrue(result);

	}
	@AfterMethod
	public void closeBrowser() {
		getDriver().close();
	}

}
