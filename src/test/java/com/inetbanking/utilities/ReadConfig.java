package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig(){
		try {
			
			pro=new Properties();
			File src=new File("./Configuration/Config.properties");
			
			FileInputStream fis=new FileInputStream(src);
			pro.load(fis);
		
			}
			
			
		
		catch(Exception e){ 
			System.out.println("Exception is found");
		}
	}
		public String getApplicationURL()
		{
			String URL=pro.getProperty("baseurl");
			return URL;
		}
		public String getusername()
		{
			String username=pro.getProperty("username");
			return username;
		}
		public String getpassword()
		{
			String password=pro.getProperty("password");
			return password;
		}
		public String getchromedriver()
		{
			String chromedriver=pro.getProperty("chromedriver");
			return chromedriver;
		}
		public String getiedriver()
		{
			String iedriver=pro.getProperty("iedriver");
			return iedriver;
		}
		public String getname()
		{
			String name=pro.getProperty("name");
			return name;
		}
		public String getaddress()
		{
			String address=pro.getProperty("address");
			return address;
		}
		public String getcity()
		{
			String city=pro.getProperty("city");
			return city;
		}
		public String getstate()
		{
			String state=pro.getProperty("state");
			return state;
		}
		public String getPIN()
		{
			String pin=pro.getProperty("PIN");
			return pin;
		}
		public String getmobile()
		{
			String mobilenumber=pro.getProperty("mobile");
			return mobilenumber;
		}
		public String getcustomerpassword() {
			String cpswd=pro.getProperty("customerpassword");
			return cpswd;
		}
		
		
		
		
		
		
	}


