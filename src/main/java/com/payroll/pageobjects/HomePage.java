package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.payroll.actiondriver.Action;

import com.payroll.baseclass.BaseClass;

public class HomePage extends BaseClass {

	// WebDriver driver;

	public HomePage() {

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@href='/payrollapp/site/index']")
	WebElement dashboard;

	@FindBy(xpath = "//h1[normalize-space()='Payroll Application']")
	WebElement appName;

	@FindBy(xpath = "//p[normalize-space()='Welcome to Payroll Application']")
	WebElement welcomeMesg;

	@FindBy(xpath = "//img[@alt='logo']")
	WebElement logoApp;

	@FindBy(xpath = "//div[@class='col-sm-6 page-title'] //h1")
	WebElement titleApp;

	@FindBy(xpath = "//a[@href='/payrollapp/company/index']")
	WebElement companyBtn;

	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement clientBtn;

	@FindBy(xpath = "//a[@href='/payrollapp/worker/index']")
	WebElement workerBtn;

	@FindBy(xpath = "//a[@href='/payrollapp/deduction/index']")
	WebElement deductionBtnClick;

	@FindBy(xpath = "//a[@href='#']")
	WebElement logOutCarolClick;

	@FindBy(xpath = "//a[@href='/payrollapp/report/payslip']")
	WebElement reportBtnClick;

	@FindBy(xpath = "//a[@href='/payrollapp/timesheet/index']")
	WebElement timeSheetBtnClick;

	@FindBy(xpath = "//a[@href='/payrollapp/payslip/index']")
	WebElement paySlipBtnClick;

	public Payslip validatePaySlipClick() {
		Action action = new Action();

		action.isDisplayed(getDriver(), paySlipBtnClick);
		action.click(getDriver(), paySlipBtnClick);
		return new Payslip();

	}

	public Timesheet validateTimeSheetClick() {
		Action action = new Action();

		action.isDisplayed(getDriver(), timeSheetBtnClick);
		action.click(getDriver(), timeSheetBtnClick);
		return new Timesheet();

	}

	public Report validateReportClick() {
		Action action = new Action();

		action.isDisplayed(getDriver(), reportBtnClick);
		action.click(getDriver(), reportBtnClick);
		return new Report();
	}

	public Company validateCompany() {
		Action action = new Action();

		action.isDisplayed(getDriver(), companyBtn);
		action.click(getDriver(), companyBtn);
		return new Company();
	}

	public Logout validateLogOut() {

		Action action = new Action();

		action.isDisplayed(getDriver(), logOutCarolClick);
		action.click(getDriver(), logOutCarolClick);
		return new Logout();

	}

	public boolean validateLogo() {

		Action action = new Action();
		return action.isDisplayed(getDriver(), logoApp);
	}

	public Clients verifyClickClient() {
		Action action = new Action();

		action.isDisplayed(getDriver(), clientBtn);
		action.click(getDriver(), clientBtn);
		return new Clients();

	}

	public Workers verifyClickWorkers() {
		Action action = new Action();
		action.isDisplayed(getDriver(), clientBtn);
		action.click(getDriver(), workerBtn);
		return new Workers();

	}

	public Deduction verifyDeductionClick() {
		Action action = new Action();
		action.isDisplayed(getDriver(), deductionBtnClick);
		action.click(getDriver(), deductionBtnClick);
		return new Deduction();
	}

	public String validateWelcomeMesg() {
		String messageWelcome = welcomeMesg.getText();
		return messageWelcome;
	}

	public String validateAppName() {
		String appNameDashboard = appName.getText();
		return appNameDashboard;
	}

	public String validateAppDetails() {

		String output = appName.getText();
		return output;

	}
}
