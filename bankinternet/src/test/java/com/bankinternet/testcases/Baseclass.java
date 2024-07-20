package com.bankinternet.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bankinternet.pageobjects.Com_bankingloginpage;
import com.bankinternet.utilities.ReadConfig;

public class Baseclass {
	
	ReadConfig readconfig=new ReadConfig();

	public String baseURL=readconfig.getApplicationUrl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	
	public void setup() throws InterruptedException {
		
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		

		/*
		 * if(br.equals("chrome")) {
		 * System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		 * driver=new ChromeDriver(); } else if (br.equals("firefox")) {
		 * System.setProperty("webdriver.edge.driver",readconfig.getEdgepath());
		 * driver=new EdgeDriver(); }
		 */
		System.setProperty("webdriver.edge.driver",readconfig.getEdgepath());
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("url id open");
		Com_bankingloginpage lp=new Com_bankingloginpage(driver);
		lp.enterUsername(readconfig.getUsername());
		logger.info("Entered username");
		lp.enterPassword(readconfig.getPassword());
		logger.info("Entered password");
		lp.clickSubmit();
		Thread.sleep(1000);
		
	}
	
	
	
	/*
	 * public void setup() throws InterruptedException {
	 * logger=Logger.getLogger("banking");
	 * PropertyConfigurator.configure("Log4j.properties");
	 * 
	 * System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
	 * driver=new EdgeDriver();
	 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 * driver.get(baseURL); driver.manage().window().maximize();
	 * 
	 * logger.info("url id open"); Com_bankingloginpage lp=new
	 * Com_bankingloginpage(driver); lp.enterUsername("mngr577367");
	 * logger.info("Entered username"); lp.enterPassword("eqApebu");
	 * logger.info("Entered password"); lp.clickSubmit(); Thread.sleep(1000);
	 * 
	 * }
	 */
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target =new File("./Screenshots"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}






}
