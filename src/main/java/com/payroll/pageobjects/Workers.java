package com.payroll.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.actiondriver.Action;
import com.payroll.baseclass.BaseClass;
import com.payroll.utilities.ExcelLibrary;

public class Workers extends BaseClass {

	Action action = new Action();

	public Workers() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@href='/payrollapp/worker/index']")
	WebElement workersbtn;

	@FindBy(id = "workersearch-first_name")
	WebElement searchFirstName;

	@FindBy(id = "workersearch-last_name")
	WebElement searchLastName;

	@FindBy(id = "workersearch-postcode")
	WebElement searchPostCode;

	@FindBy(id = "workersearch-ni_number")
	WebElement searchNiNumber;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type='reset']")
	WebElement resetBox;

	@FindBy(xpath = "//td[normalize-space()='Manav Ram']")
	WebElement nameWorkerSample1;

	@FindBy(id = "worker-title")
	WebElement createWorkerTitle;

	@FindBy(id = "worker-first_name")
	WebElement createWorkerFirstName;

	@FindBy(xpath = "//input[@id='worker-last_name']")
	WebElement createWorkerLastName;

	@FindBy(id = "worker-phone")
	WebElement createWorkerPhone;

	@FindBy(id = "worker-email")
	WebElement createWorkerEmail;

	@FindBy(id = "worker-gender")
	WebElement createWorkerGender;

	@FindBy(xpath = "//input[@id='worker-dob']")
	WebElement createWorkerDOB;

	@FindBy(id = "worker-address1")
	WebElement createWorkerAddress1;

	@FindBy(id = "worker-postcode")
	WebElement createWorkerPostCode;

	@FindBy(xpath = "//select[@id='worker-branch_id']")
	WebElement createWorkerSelectBranch;

	@FindBy(xpath = "//select[@id='worker-division_id']")
	WebElement createWorkerSelectDivision;

	@FindBy(xpath = "//select[@id='worker-employment_type']")
	WebElement createWorkerSelectEmployementType;

	@FindBy(id = "worker-payslip_method")
	WebElement createWorkerPaySlipMethod;

	@FindBy(xpath = "//select[@id='worker-engage_status']")
	WebElement createWorkerEngageStatus;

	@FindBy(xpath = "//input[@id='worker-ni_number']")
	WebElement createWorkerNiNumber;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement createWorkerNext;

	@FindBy(xpath = "//select[@id='worker-payment_method']")
	WebElement workerBankDetailsPaymentMethod;

	@FindBy(xpath = "//input[@id='worker-ac_name']")
	WebElement workerBankDetailAccountName;

	@FindBy(xpath = "//input[@id='worker-ac_no']")
	WebElement workerBankDetailAccountNumber;

	@FindBy(id = "worker-sort_code")
	WebElement workerBankDetailSortCode;

	@FindBy(id = "worker-start_date")
	WebElement workerBankDetailStartDate;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement workerBankDetailSave;

	@FindBy(xpath = "//td[normalize-space()='1']")
	WebElement workersSearchResults;

	@FindBy(xpath = "//a[@href='/payrollapp/worker/create']")
	WebElement createWorkerSideTab;

	@FindBy(xpath = "//div[@class='col-lg-10 col-sm-8']//h1[contains(text(),'Create Worker')]")
	WebElement createWorkerDisplayTabTop;
	
	
	
	@FindBy(xpath="//div[@class='col-sm-6 breadcrumb-navigation']")
	WebElement createdWorkerDisplayDetails;

	public boolean enterCreateNewWorker() throws Exception {
		Action action = new Action();
		action.click(getDriver(), createWorkerSideTab);
		
		ExcelLibrary lib = new ExcelLibrary();
		ArrayList excel=lib.getData("workerdetails");
		
		
		action.type(createWorkerDOB, "12-10-2000");
		action.selectByIndex(createWorkerTitle, 1);
		action.selectByIndex(createWorkerGender, 1);
		action.selectByIndex(createWorkerSelectBranch, 1);
		action.selectByIndex(createWorkerSelectDivision, 1);
		action.selectByIndex(createWorkerSelectEmployementType, 1);
		action.selectByIndex(createWorkerSelectDivision, 1);
		action.selectByIndex(createWorkerPaySlipMethod, 1);
		action.type(createWorkerFirstName, (String) excel.get(0));
		action.type(createWorkerLastName, (String) excel.get(1));
		action.type(createWorkerEmail, (String) excel.get(2));
		action.type(createWorkerAddress1, (String) excel.get(3));
		action.type(createWorkerPhone, (String) excel.get(4));		
		action.type(createWorkerNiNumber, (String) excel.get(5));
		action.type(createWorkerPostCode, (String) excel.get(6));
		action.click(getDriver(), createWorkerNext);		
		action.selectByIndex(workerBankDetailsPaymentMethod, 1);
		action.type(workerBankDetailAccountNumber, (String) excel.get(7));
		action.type(workerBankDetailAccountName, (String) excel.get(8));
		action.type(workerBankDetailSortCode, (String) excel.get(9));
		action.type(workerBankDetailStartDate, (String) excel.get(10));
		action.click(getDriver(), workerBankDetailSave);
		
		boolean result = createdWorkerDisplayDetails.isDisplayed();
		return result;

	}

	public boolean searchDisplayWorkers() {
		Action action = new Action();
		return action.isDisplayed(getDriver(), searchFirstName);

	}

	public boolean createWorkerVerify() {
		Action action = new Action();
		action.click(getDriver(), createWorkerSideTab);
		boolean result = createWorkerDisplayTabTop.isDisplayed();
		return result;
	}

	public boolean searchFirstName() {
		Action action = new Action();
		action.click(getDriver(), searchFirstName);
		action.type(searchFirstName, "sam");
		action.click(getDriver(), searchBox);
		boolean result = workersSearchResults.isDisplayed();
		return result;
	}

	public boolean searchLastName() {
		Action action = new Action();
		action.click(getDriver(), searchLastName);
		action.click(getDriver(), searchBox);
		boolean result = workersSearchResults.isDisplayed();
		return result;
	}

	public boolean searchNiNumber() {
		Action action = new Action();
		action.click(getDriver(), searchNiNumber);
		action.click(getDriver(), searchBox);
		boolean result = workersSearchResults.isDisplayed();
		return result;
	}

	public boolean searchPostCode() {
		Action action = new Action();
		action.click(getDriver(), searchPostCode);
		action.click(getDriver(), searchBox);
		boolean result = workersSearchResults.isDisplayed();
		return result;
	}

	public boolean verifyResetBtn() {
		action.click(getDriver(), resetBox);
		boolean output = resetBox.isEnabled();
		return output;

	}

}
