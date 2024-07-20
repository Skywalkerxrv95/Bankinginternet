package com.bankinternet.testcases;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bankinternet.pageobjects.Com_Deleteacc;

public class TC_Deleteacc extends Baseclass {

	@Test
	public void Deleteacc() throws InterruptedException {
		
		Com_Deleteacc dt=new Com_Deleteacc(driver);
		dt.clickDeleteCustomer();
		Thread.sleep(2000);
		dt.dcustId("2323");
		dt.accsubmit();
		
		SoftAssert sa=new SoftAssert();
		
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			sa.assertTrue(false);
			logger.warn("test pass");
			
		}
		else {
			sa.assertTrue(true);
			logger.info("test fail");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
				
		}
		
		
		
	}
	public boolean isAlertPresent() 
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
	
}
