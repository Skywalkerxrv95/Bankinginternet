package com.bankinternet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Com_Deleteacc {
	
WebDriver ldriver;
	
	public Com_Deleteacc(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[7]/a")
	@CacheLookup
	WebElement lnkDeleteCustomer;
	
	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")
	@CacheLookup
	WebElement CustomerId;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement accbtnSubmit;
	
	public void clickDeleteCustomer() {
		lnkDeleteCustomer.click();
			
	}
	
	
	public void dcustId(String data) {
		CustomerId.sendKeys(String.valueOf(data));
		
	}
	
	public void accsubmit() {
		accbtnSubmit.click();
	}
	
}
