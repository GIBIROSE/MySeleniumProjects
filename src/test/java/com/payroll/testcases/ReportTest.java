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
import com.payroll.pageobjects.Report;
import com.payroll.pageobjects.Workers;
import com.payroll.utilities.Log;

public class ReportTest extends BaseClass {

	@Parameters("browser")
	@BeforeMethod(groups = { "smoke" })
	public void launching(String browser) {
		launchApp(browser);
	}

	@Test(priority = 24, groups = { "sanity" })
	public void verifyClientSearch() throws InterruptedException {
		Log.startTestCase("PAYROLL APPLICATION: VIEW REPORT SUMMARY");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.validateReportClick();
		Report report = new Report();
		boolean result = report.verifyReortSummary();
		Assert.assertTrue(result);

	}

	@Test(priority = 25)
	public void verifyExportPageDetails() {
		Log.startTestCase("LOGIN TO PAYROLL APPLICATION tc2");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.validateReportClick();
		Report report = new Report();
		boolean actual=report.exportPageDataDetails();
		Assert.assertTrue(actual);

	}

	@Test(priority = 26, groups = { "smoke" })
	public void verifyGraphicalData() {
		Log.startTestCase("LOGIN TO PAYROLL APPLICATION tc3");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.validateReportClick();
		Report report = new Report();
		boolean actual = report.performanceGraphical();
		Assert.assertTrue(actual);

	}

	@AfterMethod
	public void closeBrowser() {
		getDriver().close();
	}

}