package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.ExcelReader;

public class DataProviders {
	
	ExcelReader obj = new ExcelReader();
	

	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		//credentials is sheet name inside loaded excel sheet.
		int rows = obj.getRowCount("LoginDetails");
		// Total Columns
		//credentials is sheet name inside loaded excel sheet.
		int column = obj.getColumnCount("LoginDetails");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("LoginDetails", j, i + 2);
			}
		}
		return data;
	}

}
