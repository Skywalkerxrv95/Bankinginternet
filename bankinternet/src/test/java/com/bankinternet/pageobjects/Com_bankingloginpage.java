package com.bankinternet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Com_bankingloginpage {
	
	public WebDriver ldriver;
	
	public Com_bankingloginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
		

	   @FindBy(name="uid")
	    private WebElement usernameField;

	    @FindBy(name="password")
	    private WebElement passwordField;

	    @FindBy(name="btnLogin")
	    private WebElement loginButton;

	    @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
		@CacheLookup
		WebElement lnkLogout;
	   

	    public void enterUsername(String username) {
	        usernameField.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void clickSubmit()
		{
	    	loginButton.click();
		}
	    
	    public void clickLogout()
		{
			lnkLogout.click();
		}
	
}
