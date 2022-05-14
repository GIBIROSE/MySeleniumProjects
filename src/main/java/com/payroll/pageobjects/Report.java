package com.payroll.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.actiondriver.Action;
import com.payroll.baseclass.BaseClass;

public class Report extends BaseClass {

	public Report() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[normalize-space()='Report']")
	WebElement reportClick;

	@FindBy(xpath = "//span[@class='select2-selection__placeholder']")
	WebElement selectWorkerID;

	@FindBy(xpath = "ratesearch-created_at_range")
	WebElement selectTimeSheetDateRange;

	@FindBy(xpath = "//div[@class='summary']")
	WebElement summaryReport;

	@FindBy(xpath = "//button[@id='w3']")
	WebElement exportPageDataBtn;

	@FindBy(xpath = "//a[normalize-space()='Excel']")
	WebElement exportPageDataExcel;

	@FindBy(xpath = "//a[normalize-space()='PDF']")
	WebElement exportPageDataPDF;

	@FindBy(xpath = "//a[@href='/payrollapp/report/perfomance']")
	WebElement companyPerformanceClick;

	@FindBy(xpath = "(//*[name()='rect'])[9]")
	WebElement graphPerformance;

	@FindBy(xpath = "//li[normalize-space()='Perfomance']")
	WebElement performanceGraph;

	@FindBy(xpath = "//a[@href='/payrollapp/report/deduction']")
	WebElement deductionHistoryClick;

	@FindBy(id = "select2-deductionsearch-worker_id-container")
	WebElement deductionHistorySelectWorker;

	@FindBy(xpath = "//span[@role='presentation']")
	WebElement deductionDownArrow;

	@FindBy(xpath = "//input[@role='textbox']")
	WebElement workerTxtBox;

	@FindBy(xpath = "//li[@id='select2-deductionsearch-worker_id-result-uxpn-3']")
	WebElement workerDeductioBtn;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	WebElement allElements;

	@FindBy(id = "invoicesearch-client_name")
	WebElement invoiceClientName;

	@FindBy(id = "invoicesearch-client_id")
	WebElement invoiceClientNumber;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	WebElement invoiceSearch;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;

	public boolean verifyReortSummary() {
		summaryReport.isDisplayed();
		return summaryReport.isDisplayed();
	}

	public boolean exportPageDataDetails() {
		Action action = new Action();
		action.click(getDriver(), exportPageDataBtn);
		action.click(getDriver(), exportPageDataExcel);
		action.click(getDriver(), exportPageDataPDF);
		return exportPageDataExcel.isEnabled();

	}

	public boolean performanceGraphical() {
		Action action = new Action();
		action.click(getDriver(), companyPerformanceClick);
		return performanceGraph.isDisplayed();
	}

}
