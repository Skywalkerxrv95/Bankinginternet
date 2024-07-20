package com.bankinternet.testcases;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.NoAlertPresentException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bankinternet.pageobjects.Com_bankingloginpage;
import com.bankinternet.utilities.XLUtiis;

public class TC_Com_login_001 extends Baseclass {
	
	
	
	@Test(dataProvider = "dp")
	public void loginTest(String usr, String pwd) throws InterruptedException {
	
		logger.info("url id open");
		Com_bankingloginpage lp=new Com_bankingloginpage(driver);
		lp.enterUsername(usr);
		logger.info("Entered username");
		lp.enterPassword(pwd);
		logger.info("Entered password");
		lp.clickSubmit();
		Thread.sleep(1000);

		SoftAssert sa=new SoftAssert();
		
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			sa.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			sa.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	  @DataProvider
	  public Object[][] dp() throws IOException {
		  
		  String filePath = "./test.xlsx";
	      String sheetName = "Sheet1";
		  
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
