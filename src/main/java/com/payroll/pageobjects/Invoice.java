package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invoice {

	WebDriver driver;

	public Invoice() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/payrollapp/invoice/index']")
	WebElement invoiceClick;

	@FindBy(xpath = "//div[@class='summary']")
	WebElement invoiceSummaryBtn;

	@FindBy(xpath = "//a[@href='/payrollapp/invoice/generate?id=1216']")
	WebElement downloadPdfClient;
	
	
	
	

}
