package com.payroll.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.actiondriver.Action;
import com.payroll.baseclass.BaseClass;

public class Payslip extends BaseClass {

	public Payslip() {
		PageFactory.initElements(getDriver(), this);

	}

	@FindBy(xpath = "//div[@class='summary']")
	WebElement paySlipSummary;

	@FindBy(xpath = "//a[@href='/payrollapp/payslip/pdf?id=2780']")
	WebElement paySlipDownloadButton;

	@FindBy(xpath = "//a[@href='/payrollapp/payslip/pdf?id=2781']//span[@class='glyphicon glyphicon-paperclip']")
	WebElement downloadOneWorkerPayslip;

	@FindBy(xpath = "//a[@href='/payrollapp/payslip/index?page=6&per-page=40']")
	WebElement pagination6;

	@FindBy(xpath = "//a[@href='/payrollapp/payslip/index?page=10&per-page=40']")
	WebElement pagination10;

	public boolean verifyPagination() throws Exception {
		Action action = new Action();

		action.JSClick(getDriver(), pagination6);
		action.JSClick(getDriver(), pagination10);
		return pagination6.isEnabled();
	}

	public boolean verifySummaryDetailsPaySlip() {
		boolean output = paySlipDownloadButton.isDisplayed();
		return output;

	}

	public boolean verifyDownloadPaySlipWorker() throws AWTException, InterruptedException {
		downloadOneWorkerPayslip.click();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_S);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		return downloadOneWorkerPayslip.isEnabled();
	}

}
