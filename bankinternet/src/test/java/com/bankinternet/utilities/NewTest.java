package com.bankinternet.utilities;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class NewTest {
	
	  @Test(dataProvider = "dp") public void testexceldata(String n, String s) {
	  System.out.println(n + " " + s); 
	  }
	 
  
  @Test(dataProvider = "dp")
  public void testexceldata1(String y, String n, String s) {
    System.out.println(y+" "+n + " " + s);
  }

  @DataProvider
  public Object[][] dp() throws IOException {
	  
	  String filePath = "./test.xlsx";
      String sheetName = "Sheet2";
	  
    XLUtiis xlutis = new XLUtiis(filePath,sheetName);
    List<List<String>> data = xlutis.readData();
    xlutis.close();

    int rows = data.size() - 1; // Assuming the first row is header
    int columns = xlutis.getNumberofColoums();

    Object[][] excelData = new Object[rows][columns];

    for (int i = 1; i <= rows; i++) { // Start from 1 to skip header
      for (int j = 0; j < columns; j++) {
        excelData[i - 1][j] = data.get(i).get(j);
      }
    }

    return excelData;
  }
}
