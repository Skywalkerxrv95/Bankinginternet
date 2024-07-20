package com.bankinternet.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.bankinternet.pageobjects.Com_EditCustomerobjects;
import com.bankinternet.utilities.XLUtiis;

public class TC_EditCustomer_003 extends Baseclass {

	@Test(dataProvider = "dp")
	public void EditCustomer(String name ,String cgender, String dd,String mm,String yy,String caddress,String ccity,
			String cstate,String cpinno,String ctelephoneno,String cemailid) throws InterruptedException {
		

		
		
		Com_EditCustomerobjects ad=new Com_EditCustomerobjects(driver);
		ad.clickEditCustomer();
		ad.custId();
		ad.accsubmit();
		
		
		try {
			ad.custName(name);
			ad.custgender(cgender);
			ad.custdob(dd,mm,yy);
			Thread.sleep(5000);
			ad.custaddress(caddress);
			ad.custcity(ccity);
			ad.custstate(cstate);
			ad.custpinno(cpinno);
			ad.custtelephoneno(ctelephoneno);
			ad.custemailid(cemailid);
			
			ad.custsubmit();
			
			
			SoftAssert sa=new SoftAssert();
			
			if (isAlertPresent()==true) {
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				sa.assertTrue(false);
				logger.warn("test fail");
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[2]")).click();
			}
			else {
				sa.assertTrue(true);
				logger.info("test fail");
				Thread.sleep(3000);
				driver.switchTo().alert().accept();//close logout alert
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[2]")).click();
				driver.switchTo().defaultContent();
					
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	      String sheetName = "Sheet3";
		  
	    XLUtiis xlutis = new XLUtiis(filePath,sheetName);
	    List<List<String>> data = xlutis.readData();
	    xlutis.close();

	    int rows = data.size() - 1; 
	    int columns = xlutis.getNumberofColoums();

	    Object[][] excelData = new Object[rows][columns];

	    for (int i = 1; i <= rows; i++) { 
	      for (int j = 0; j < columns; j++) {
	        excelData[i - 1][j] = data.get(i).get(j);
	      }
	    }

	    return excelData;
	  }

	
}
