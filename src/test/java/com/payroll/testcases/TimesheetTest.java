package com.payroll.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payroll.baseclass.BaseClass;
import com.payroll.pageobjects.HomePage;
import com.payroll.pageobjects.LoginPage;
import com.payroll.pageobjects.Report;
import com.payroll.pageobjects.Timesheet;
import com.payroll.utilities.Log;

public class TimesheetTest extends BaseClass {

	@Parameters("browser")
	@BeforeMethod(groups = { "smoke" })
	public void launching(String browser) {
		launchApp(browser);
	}

	@Test
	public void generatePaySlipUpload() {

		Log.startTestCase(" PAYROLL APPLICATION Timesheet upload using sendkeys");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.validateTimeSheetClick();
		Timesheet sheet = new Timesheet();
		String actual = sheet.uploadFies();
		String expected = "CREATE TIMESHEET";
		Assert.assertEquals(actual, expected);
	}

	/*@Test
	public void timeshtFinal() throws Exception {
		Log.startTestCase(" PAYROLL APPLICATION  verify  create timesheet ");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.validateTimeSheetClick();
		Timesheet sheet = new Timesheet();
		sheet.createTimesheet();
	}*/

	@Test(priority = 22)
	public void validateTimeSheetApprove() throws InterruptedException {
		Log.startTestCase("PAYROLL APPLICATION tc: approve timesheets");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.validateTimeSheetClick();
		Timesheet sheet = new Timesheet();
		String actual = sheet.verifyApproveTimeSheets();
		String expected = "Approved";
		Assert.assertEquals(actual, expected);
	}

	/*@Test(priority = 23)
	public void generatePaySlipValidate() {

		Log.startTestCase(" PAYROLL APPLICATION Payslip generation");
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.validateTimeSheetClick();
		Timesheet sheet = new Timesheet();
		sheet.verifyGeneratePaySlip();

	}*/

	@AfterMethod
	public void closeBrowser() {
		getDriver().close();
	}
}
