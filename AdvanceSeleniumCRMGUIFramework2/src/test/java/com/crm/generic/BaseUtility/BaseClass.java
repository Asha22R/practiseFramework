package com.crm.generic.BaseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("Connect to DB, Report config ");
	}
	
	@BeforeClass
	public void configBeforeClass() {
		System.out.println("Launch browser");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("Login");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("Logout");
	}
	@AfterClass
	public void configAfterClass() {
		System.out.println("Close browser");
	}
	@AfterSuite
	public void configAfterSuite() {
		System.out.println("DisConnect to DB, Report config ");
	}

}
