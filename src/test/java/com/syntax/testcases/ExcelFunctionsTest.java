package com.syntax.testcases;

import org.apache.commons.math3.analysis.function.Constant;
import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest {

	@Test
	public void excelTest() {

		ExcelUtility obj = new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails");
//		String value = obj.getCellData(1, 0);
//		System.out.println(value);

		// retrive all values from xcell and store intoDataProvider (2D Object Array)

		int row = obj.getRowNum();
		int cols = obj.getColNum(0);

		Object[][] data = new Object[row][cols];

		for (int i = 1; i < row; i++) {
			for (int y = 0; y < cols; y++) {
             //retrieve value from excel
				String value = obj.getCellData(i, y);
				data[i][y] = value;

			}
		}
		System.out.println(data.length);
	}
}
