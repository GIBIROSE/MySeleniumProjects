package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.actiondriver.Action;

public class ResetPassword {

	WebDriver driver;
	Action action = new Action();

	/** page constructor **/

	public ResetPassword() {
		//this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='/payrollapp/site/request-password-reset']")
	WebElement resetClick;

	@FindBy(xpath = "//h1[normalize-space()='Password reset']")
	WebElement resetLink;

	public String resetVerify() {
		resetClick.click();
		resetLink.getText();
		String output = resetLink.getText();
		return output;
	}

}
