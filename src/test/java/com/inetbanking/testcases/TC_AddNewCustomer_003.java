package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddNewCustomer;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddNewCustomer_003 extends BaseClass{
	
	
	@Test
	public void addcustomer() throws InterruptedException, IOException {
	
	LoginPage lp=new LoginPage(driver);	
	AddNewCustomer cust=new AddNewCustomer(driver);
	lp.setusername(username);
	logger.info("username is entered");
	lp.setpassword(password);
	logger.info("password is entered");
	lp.clicksubmit();
	
	
	cust.addnewcustomerclick();
	logger.info("Adding new customer information........");
	cust.getname(name);
	
	cust.getgender("male");
	cust.getdob("11", "21", "1995");
	cust.getaddress(address);
	cust.getcity(city);
	cust.getstate(state);
	cust.getpin(pin);
	cust.gettelephonenumber(mobile);
	cust.getemail(Randomaplhabets()+"@gmail.com");
	cust.getpassword(customerpassword);
	cust.getclicksubmit();
	Thread.sleep(3000);
	logger.info("validation started....");
	
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	if(res==true) {
		Assert.assertTrue(true);
		logger.info("New Customer successfully created");
	}
	else {
		
		logger.info("test case failed....");
		captureScreen(driver, "addcustomer");
		Assert.assertTrue(false);
	}
	
	}
		
}
