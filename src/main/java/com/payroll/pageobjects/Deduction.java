package com.payroll.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.actiondriver.Action;
import com.payroll.baseclass.BaseClass;
import com.payroll.utilities.ExcelLibrary;

public class Deduction extends BaseClass {

	public Deduction() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@href='/payrollapp/deduction/index']")
	WebElement deductionBtn;

	@FindBy(xpath = "//a[@href='/payrollapp/deduction/view?id=5578']//span[@class='glyphicon glyphicon-eye-open']")
	WebElement deductionViewOneUserEyeBtn;

	@FindBy(xpath = "//a[@href='/payrollapp/deduction/create']")
	WebElement addDeductionSideTab;

	@FindBy(id = "select2-deduction-worker_id-container")
	WebElement addDeductionWorker1;

	@FindBy(xpath = "//span[@id='select2-deduction-worker_id-container']")
	WebElement addDeductionWorker;

	@FindBy(xpath = "//select[@id='deduction-type']")
	WebElement addDeductionType;

	@FindBy(id = "deduction-amount")
	WebElement addDeductionAmount;

	@FindBy(xpath = "//input[@id='deduction-effective_from']")
	WebElement addDeductionEffectiveFrom;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addDeductionSaveButton;

	@FindBy(xpath = "//div[@class='summary']")
	WebElement summaryDetductionDetailsShow1to20;

	@FindBy(xpath = "//ul[@class='breadcrumb']")
	WebElement detailedViewOneUser;

	@FindBy(xpath = "//th[normalize-space()='Worker']")
	WebElement addDeductionSavedDetailsPage;

	public boolean addDeduction() throws Exception {
		Action action = new Action();
		action.click(getDriver(), addDeductionSideTab);
		action.explicitWait(getDriver(), addDeductionSideTab, 10);
		action.explicitWait(getDriver(), addDeductionWorker, 10);
		action.selectByIndex(addDeductionWorker, 1);
		action.selectByIndex(addDeductionType, 1);
		ExcelLibrary lib = new ExcelLibrary();
		ArrayList excel = lib.getData("adddeduction");
		action.type(addDeductionAmount, (String) excel.get(0));
		// action.type(addDeductionWorker, (String) excel.get(1));
		action.JSClick(getDriver(), addDeductionSaveButton);
		boolean result = addDeductionSavedDetailsPage.isDisplayed();
		return result;
	}

	public boolean deductionVerifyViewAllWorkers() {
		Action action = new Action();
		action.click(getDriver(), deductionBtn);
		boolean result = summaryDetductionDetailsShow1to20.isDisplayed();
		return result;
	}

	public boolean existingWorkerView() {
		Action action = new Action();
		action.click(getDriver(), deductionViewOneUserEyeBtn);
		boolean result = detailedViewOneUser.isDisplayed();
		return result;
	}

}
