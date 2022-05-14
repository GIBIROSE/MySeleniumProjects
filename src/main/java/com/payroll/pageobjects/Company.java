package com.payroll.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Company extends LoginPage {
	
	
	public Company() {
		PageFactory.initElements(getDriver(),this);
	}
	
	
	@FindBy(xpath="//a[@href='/payrollapp/company/index']")
	WebElement companyButton;
	
	@FindBy(xpath="//div[@class='site-error']/h1")
	WebElement errorMesg;
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']//h1[contains(text(),'Forbidden (#403)')]")
	WebElement errorForbiddenErrorMesg;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement alertMesg;
	
	
	public String verifyCompanyDetails() {
		String output=errorForbiddenErrorMesg.getText();
		return output;
	}
	
	
	public boolean limitAccessToCompanyTabDetails() {
		boolean output=alertMesg.isDisplayed();
		return output;
	}

}
