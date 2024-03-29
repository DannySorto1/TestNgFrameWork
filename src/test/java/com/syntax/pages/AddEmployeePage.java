package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddEmployeePage extends BaseClass {

	@FindBy(id = "firstName")
	public WebElement FirstName;

	@FindBy(id = "middleName")
	public WebElement MidName;

	@FindBy(id = "lastName")
	public WebElement LastName;

	@FindBy(id = "employeeId")
	public WebElement EmpId;

	@FindBy(xpath = "//div[@id='location_inputfileddiv']//input")
	public WebElement location;

	@FindBy(xpath = "//div[@id='location_inputfileddiv']//ul")
	public WebElement locationList;

	@FindBy(xpath = "//input[@id='chkLogin']")
	public WebElement createLoginDetails;

	@FindBy(id = "systemUserSaveBtn")
	public WebElement saveBtn;

	@FindBy(xpath = "//span[@id='pim.navbar.employeeName']")
	public WebElement empCheck;

	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}
}
