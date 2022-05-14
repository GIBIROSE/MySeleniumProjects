
package com.payroll.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.actiondriver.Action;
import com.payroll.baseclass.BaseClass;
import com.payroll.utilities.ExcelLibrary;

public class Clients extends BaseClass {

	public Action action;

	public Clients() {
		PageFactory.initElements(getDriver(), this);

	}

	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement clientBtn;

	@FindBy(xpath = "//a[@href='/payrollapp/client/create']")
	WebElement createClient;

	@FindBy(id = "clientsearch-client_name")
	WebElement clientNameSearchBox;

	@FindBy(id = "clientsearch-id")
	WebElement clientIDSearchBox;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement resetBtn;

	@FindBy(xpath = "/a[@data-sort='id']")
	WebElement clientIDSort;

	@FindBy(xpath = "//a[@data-sort='client_name']")
	WebElement clientNameSort;

	@FindBy(xpath = "//a[@data-sort='your_ref']")
	WebElement clientReference;

	@FindBy(xpath = "//a[@data-sort='client_address']")
	WebElement clientAddress;

	@FindBy(xpath = "//a[@data-sort='postcode']")
	WebElement postcode;

	@FindBy(id = "client-branch_id")
	WebElement txtBranch;

	@FindBy(id = "client-division_id")
	WebElement txtDivision;

	@FindBy(xpath = "//input[@id='client-client_name']")
	WebElement txtCreateClient;

	@FindBy(xpath = "//textarea[@id='client-client_address']")
	WebElement txtAddress;

	@FindBy(xpath = "//input[@id='client-postcode']")
	WebElement txtPostcode;

	@FindBy(xpath = "//input[@id='client-your_ref']")
	WebElement textYourReference;

	@FindBy(xpath = "//input[@id='client-invoice_contact']")
	WebElement txtInvoiceContact;

	@FindBy(xpath = "//input[@id='client-phone']")
	WebElement txtPhone;

	@FindBy(id = "client-fax")
	WebElement txtFax;

	@FindBy(id = "client-email")
	WebElement txtEmail;

	@FindBy(id = "client-company_reg")
	WebElement txtCompanyReg;

	@FindBy(xpath = "//select[@id='client-invoice_order']")
	WebElement txtInvoiceOrder;

	@FindBy(xpath = "//select[@id='client-invoice_delivery_method']")
	WebElement txtInvoiceDeliveryMethod;

	@FindBy(xpath = "//select[@id='client-master_document']")
	WebElement txtMasterDocument;

	@FindBy(id = "client-settilement_days")
	WebElement txtSettlementDays;

	@FindBy(id = "client-vat_rate")
	WebElement txtVatRate;

	@FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
	WebElement saveButton;

	@FindBy(xpath = "//ul[@class='breadcrumb']")
	WebElement savedClientDetails;

	@FindBy(xpath = "//a[@href='/payrollapp/client/invoice?id=755']")
	WebElement viewInvoiceHistory;

	@FindBy(xpath = "//td[normalize-space()='Sam']")
	WebElement searchResultByName;

	@FindBy(xpath = "//td[normalize-space()='3']")
	WebElement searchResultByID;

	@FindBy(xpath = "//a[@href='/payrollapp/client/view?id=1']//span[@class='glyphicon glyphicon-eye-open']")
	WebElement viewOneExistingClient;

	@FindBy(xpath = "//td[normalize-space()='Amalaxaviour']")
	WebElement viewOneUserEnlargedView;

	@FindBy(xpath = "//a[@href='/payrollapp/client/update?id=1']//span[@class='glyphicon glyphicon-pencil']")
	WebElement editOneExistingClient;

	@FindBy(xpath = "//li[normalize-space()='Update']")
	WebElement existingUserEditWindowEnlargedView;

	public boolean editExistingClient() {
		Action action = new Action();
		action.click(getDriver(), editOneExistingClient);
		return existingUserEditWindowEnlargedView.isDisplayed();
	}

	public boolean viewExistngClient() {
		Action action = new Action();
		action.click(getDriver(), viewOneExistingClient);
		return viewOneUserEnlargedView.isDisplayed();
	}

	public boolean searchDisplay() {
		action = new Action();
		return action.isDisplayed(getDriver(), clientNameSearchBox);
	}

	public boolean searchClients() throws Exception {

		ExcelLibrary lib = new ExcelLibrary();
		ArrayList excel = lib.getData("existingclientsearch");
		Action action = new Action();
		action.type(clientNameSearchBox, (String) excel.get(0));
		searchBox.click();
		boolean result = searchResultByName.isDisplayed();
		return result;
	}

	public boolean searchClientByID() throws Exception {

		ExcelLibrary lib = new ExcelLibrary();
		ArrayList excel = lib.getData("clientIDsearch");
		Action action = new Action();
		action.type(clientIDSearchBox, (String) excel.get(0));
		boolean result = searchResultByID.isDisplayed();
		return result;
	}

	public String resetEnbledVerify() throws Exception {

		ExcelLibrary lib = new ExcelLibrary();
		ArrayList excel = lib.getData("resetsearch");
		Action action = new Action();
		action.type(clientIDSearchBox, (String) excel.get(0));

		action.click(getDriver(), resetBtn);
		action.type(clientIDSearchBox, (String) excel.get(0));
		return (String) excel.get(0);
	}

	public boolean createClientStep() throws Exception {
		ExcelLibrary lib = new ExcelLibrary();
		ArrayList excel = lib.getData("clients");
		Action action = new Action();
		action.click(getDriver(), createClient);
		action.click(getDriver(), txtBranch);
		action.selectBySendkeys("Alpha_new", txtBranch);
		action.selectByIndex(txtDivision, 1);
		action.selectByVisibleText("NewAlpha", txtBranch);
		action.type(txtCreateClient, (String) excel.get(0));
		action.type(txtAddress, (String) excel.get(1));
		action.type(txtPostcode, (String) excel.get(2));
		action.type(txtInvoiceContact, (String) excel.get(3));
		action.type(txtPhone, (String) excel.get(4));
		action.type(txtEmail, (String) excel.get(5));
		action.type(txtCompanyReg, (String) excel.get(6));
		action.selectByIndex(txtMasterDocument, 2);
		action.selectByIndex(txtInvoiceOrder, 2);
		action.selectByIndex(txtInvoiceDeliveryMethod, 2);
		action.type(txtSettlementDays, (String) excel.get(7));
		action.selectByIndex(txtVatRate, 3);
		action.explicitWait(getDriver(), saveButton, 10);
		action.JSClick(getDriver(), saveButton);
		boolean actual = savedClientDetails.isDisplayed();
		return actual;

	}

}
