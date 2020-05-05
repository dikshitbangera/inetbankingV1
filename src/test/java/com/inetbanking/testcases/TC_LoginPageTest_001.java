package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginPageTest_001 extends BaseClass {
	
	
	@Test
	public void loginTestTitle() throws IOException {
		
		
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		
		logger.info("username is entered");
		
		lp.setpassword(password);
		
		logger.info("password is entered");
		
		lp.clicksubmit();
		
		logger.info("submit button is clicked");
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Assert is passed");
			
		}
		else {
			
			captureScreen(driver,"loginTestTitle");
			Assert.assertTrue(false);
			logger.info("Assert is failed");
		}
		
		
		
	}
	
	@Test
	public void loginTest2() throws IOException {
		

//		logger.info("URL is opened");
//		
//		LoginPage lp=new LoginPage(driver);
//		lp.setusername(username);
//		
//		logger.info("username is entered");
//		
//		lp.setpassword(password);
//		
//		logger.info("password is entered");
//		
//		lp.clicksubmit();
//		
//		logger.info("submit button is clicked");
		
		
		if(driver.getTitle().equals("Guru100 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Assert is passed");
			
		}
		else {
			captureScreen(driver,"loginTest2");
			
			Assert.assertTrue(false);
			logger.info("Assert is failed");
		}
		
		
	}
	
	
}
