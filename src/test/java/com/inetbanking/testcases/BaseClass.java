package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig read=new ReadConfig();
	
 
	public String baseurl=read.getApplicationURL();
	public String username=read.getusername();
	public String password=read.getpassword();
	public static WebDriver driver;
	public String name=read.getname();
	public String address=read.getaddress();
	public String city=read.getcity();
	public String state=read.getstate();
	public String pin=read.getPIN();
	public String mobile=read.getmobile();
	public String customerpassword=read.getcustomerpassword();
	
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",read.getchromedriver());
		driver=new ChromeDriver();
		
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

		driver = new ChromeDriver(capability);
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",read.getiedriver());
			driver=new InternetExplorerDriver();
		}
		
		
		
		
		logger=Logger.getLogger("ebanking");
		DOMConfigurator.configure("log4j.xml");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseurl);
		
	}
	
	@AfterClass
	public void teardown() {
		driver.close();;
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String Randomaplhabets() {
		String randomalpha=RandomStringUtils.randomAlphabetic(8);
		
		return randomalpha;
	}
	
}
