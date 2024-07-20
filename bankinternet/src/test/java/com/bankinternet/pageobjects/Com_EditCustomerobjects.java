package com.bankinternet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.bankinternet.utilities.ReadConfig;

public class Com_EditCustomerobjects {

	
WebDriver ldriver;
	
	public Com_EditCustomerobjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement lnkEditCustomer;
	
	@FindBy(how = How.NAME, using = "cusid")
	@CacheLookup
	WebElement txtCustomerId;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement accbtnSubmit;
	

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "gender")
	@CacheLookup
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	
	public void clickEditCustomer() {
		lnkEditCustomer.click();
			
	}
	ReadConfig readconfig=new ReadConfig();
	
	public void custId() {
		txtCustomerId.sendKeys(readconfig.getCustomerId());
		
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		rdGender.click();
	}

	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	public void accsubmit() {
		accbtnSubmit.click();
	}
	
}
