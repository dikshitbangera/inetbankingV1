package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLSUtils;

import junit.framework.Assert;

public class TC_LoginPageTestDTT_002 extends BaseClass {

	@Test(dataProvider="logintest")
	public void loginDDT(String uname,String pwd) throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(uname);
		logger.info("Username entered");
		lp.setpassword(pwd);
		logger.info("password entered");
		lp.clicksubmit();
		logger.info("Submit button clicked");
		
		Thread.sleep(3000);
		
		if(isAlert()==true) {
			captureScreen(driver, uname);
			driver.switchTo().alert().accept();
			logger.warn("Login Failed");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}
		
		public boolean isAlert() {
			try {
			driver.switchTo().alert();
			return true;
			}
			catch(Exception e) 
			{
				return false;
			}
		
		
	}
	
	
	
	

	@DataProvider(name="logintest")
	String[][] getdata() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int row= XLSUtils.getRowCount(path, "Sheet1");
		int col=XLSUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[row][col];
		for(int i=1;i<=row;i++) {
			for(int j=0;j<col;j++) {
				logindata[i-1][j]=XLSUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
		
	}
	
}
