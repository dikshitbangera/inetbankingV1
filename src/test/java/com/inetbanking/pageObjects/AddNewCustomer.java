package com.inetbanking.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver ldriver;
	
	public AddNewCustomer(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement addnewcustomer;
	
	@FindBy(name="name")
	WebElement name;
	
	@FindBy(name="rad1")
	WebElement gender;
	
	@FindBy(name="dob")
	WebElement dob;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pinnumber;
	
	@FindBy(name="telephoneno")
	WebElement telephonenumber;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement submit;
	
	public void addnewcustomerclick() {
		addnewcustomer.click();
	}
	
	public void getname(String Fname) {
		name.sendKeys(Fname);
	}
	
	public void getgender(String cgender) {
		gender.click();
	}
	
	public void getdob(String mm, String dd, String yyyy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
	}
	public void getaddress(String caddress) {
		address.sendKeys(caddress);
	}
	public void getcity(String ccity) {
		city.sendKeys(ccity);
	}
	public void getstate(String cstate) {
		state.sendKeys(cstate);
	}
	public void getpin(String cpin) {
		pinnumber.sendKeys(String.valueOf(cpin));
	}
	public void gettelephonenumber(String cnumber) {
		telephonenumber.sendKeys(cnumber);
	}
	public void getemail(String cemail) {
		emailid.sendKeys(cemail);
	}
	
	public void getpassword(String cpassword) {
		password.sendKeys(cpassword);
	}
	public void getclicksubmit() {
		submit.click();
	}
	
	

}
