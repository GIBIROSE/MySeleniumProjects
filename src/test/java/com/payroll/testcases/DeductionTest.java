package com.payroll.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payroll.baseclass.BaseClass;
import com.payroll.pageobjects.Deduction;
import com.payroll.pageobjects.HomePage;
import com.payroll.pageobjects.LoginPage;

public class DeductionTest  extends BaseClass{

	@Parameters("browser")
	@BeforeMethod(groups= {"smoke"})
	public void launching(String browser) {
		launchApp(browser);
	}

	@Test(priority=19,groups= {"smoke"})
	public void verifyClientSearch() throws InterruptedException {
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyDeductionClick();
        Deduction ded=new Deduction();		
		boolean result = ded.deductionVerifyViewAllWorkers();
		Assert.assertTrue(result);
	}

	
	@Test(priority=20)
	public void verifyDeductionWorkersEyeBtn() throws InterruptedException {
		
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyDeductionClick();
        Deduction ded=new Deduction();		
		boolean result = ded.existingWorkerView();
		Assert.assertTrue(result);}
		
	
	@Test(priority=21,groups= {"sanity"})
	public void verifyAddDeductionPage() throws Exception {
		
		LoginPage pg = new LoginPage();
		pg.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage home = new HomePage();
		home.verifyDeductionClick();
        Deduction ded=new Deduction();		
		boolean result=ded.addDeduction();
		Assert.assertTrue(result);
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		getDriver().close();}
	
	
	
	
	
}
