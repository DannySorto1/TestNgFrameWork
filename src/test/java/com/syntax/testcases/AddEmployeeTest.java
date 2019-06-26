package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommondMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class AddEmployeeTest extends BaseClass {

	@Test(dataProvider = "Employee Data")
	public void AddEmployee(String fName, String mName, String lName, String location) {

		LoginPage login = new LoginPage();
		HomePage home = new HomePage();
		AddEmployeePage newEmp = new AddEmployeePage();
		// login orangeHRM
		login.Login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		// naviagte to Add Employee
		CommondMethods.click(home.Pim);
		CommondMethods.click(home.AddEmp);
		// employee details
		CommondMethods.sendText(newEmp.FirstName, fName);
		CommondMethods.sendText(newEmp.MidName, mName);
		CommondMethods.sendText(newEmp.LastName, lName);
		CommondMethods.click(newEmp.location);
		CommondMethods.selectList(newEmp.locationList, location);
		CommondMethods.click(newEmp.saveBtn);

		// verify employee is added
		CommondMethods.waitForElementBeClickable(newEmp.empCheck, 20);
		String veriText = newEmp.empCheck.getText();
		System.out.println(veriText);
		Assert.assertEquals(veriText, fName + " " + lName);

		// 1 identify list
		// 2 get all children with li tags
		// loop through each li tag and get text
		// if text is matching then we click
		// break

//		List<WebElement> listLocations = newEmp.locationList.findElements(By.tagName("li"));
//
//		for (WebElement li : listLocations) {
//			String liText = li.getText().trim();
//
//			if (liText.equals("HQ")) {
//				li.click();
//				break;
//			}
//		}

	}

	@DataProvider(name = "Employee Data")
	public Object[][] getEmpData() {
		ExcelUtility obj = new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails");

		int rows = obj.getRowNum();
		int cols = obj.getColNum(0);

		Object[][] data = new Object[rows - 1][cols];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; i++) {

				String value = obj.getCellData(i, j);
				data[i - 1][j] = value;

			}
		}
		return data;
	}
	
//	@DataProvider(name = "Employee Data")
//	public Object[][] getEmpData() {
//
//		ExcelUtility obj = new ExcelUtility();
//		obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails");
//
//		int rows = obj.getRowNum();// 13
//		int cols = obj.getColNum(0);// 4
//
//		Object[][] data = new Object[rows - 1][cols];// new Object[12][4]
//
//		for (int i = 1; i < rows; i++) {
//			for (int j = 0; j < cols; j++) {
//				String value = obj.getCellData(i, j);
//				// at first iteration data[1][0]
//
//				// at last iteration data[12][3]
//				data[i - 1][j] = value;// data[0][0];
//			}
//		}
//		return data;
//
//	}

	@DataProvider(name = "employee details")
	public Object[][] getData() {

		Object[][] data = new Object[3][4];
		// 1 set
		data[0][0] = "John";
		data[0][1] = "Snow";
		data[0][2] = "White";
		data[0][3] = "German Regional HQ";
		// 2 set
		data[1][0] = "Jane";
		data[1][1] = "Rain";
		data[1][2] = "Yellow";
		data[1][3] = "London Office";
		// 3 set
		data[2][0] = "Arya";
		data[2][1] = "Sunny";
		data[2][2] = "Blue";
		data[2][3] = "Texas R&D";
		return data;

	}

}
