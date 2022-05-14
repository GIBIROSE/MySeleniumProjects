package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.payroll.actiondriver.Action;
import com.payroll.baseclass.BaseClass;

public class Logout extends BaseClass {

	public Logout() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@href='/payrollapp/user/profile']")
	WebElement viewProfileLink;

	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement viewProfileLinkErrorMessg;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement logoutBtn;

	@FindBy(xpath = "//a[@href='/payrollapp/site/logout']")
	WebElement logOutLinkClick;

	public String verifyLogOutFeature() {

		Action action = new Action();
		action.click(getDriver(), logOutLinkClick);
		return getDriver().getCurrentUrl();

	}

	public String verifyFullProfileViewErrorFeature() {
		Action action = new Action();
		action.click(getDriver(), viewProfileLink);
		String result = viewProfileLinkErrorMessg.getText();
		return result;
	}

}
