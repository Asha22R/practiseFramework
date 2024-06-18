package pactiseHomePageTest;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Demo1 {
	@BeforeSuite
	public void beforeSuite1() {
		Reporter.log("Before Suite1",true);
	}
	@BeforeSuite
	public void beforeSuite2() {
		Reporter.log("Before Suite2",true);
	}
	@BeforeClass
	public void beforeClass1() {
		Reporter.log("before Class1",true);
	}
	@BeforeClass
	public void beforeClass2() {
		Reporter.log("before Class2",true);
	}
	@BeforeMethod
	public void beforeMethod1() {
		Reporter.log("before method1",true);
	}
	@BeforeMethod
	public void beforeMethod2() {
		Reporter.log("before method2",true);
	}
	
	@Test
	public void test1() {
		Reporter.log("Test1",true);
	}
	@Test
	public void test2() {
		Reporter.log("Test2",true);
	}
	@AfterMethod(dependsOnMethods = "aftermethod2")
	public void aftermethod1() {
		Reporter.log("after method1",true);
	}
	@AfterMethod
	public void aftermethod2() {
		Reporter.log("after method2",true);
	}
		@AfterClass
	public void AfterClass1() {
		Reporter.log("After Class1",true);
	}
	@AfterClass
	public void AfterClass2() {
		Reporter.log("After Class2",true);
	}
	@AfterSuite
	public void afterSuite1() {
		Reporter.log("After Suite1",true);
	}@AfterSuite
	public void afterSuite2() {
		Reporter.log("After Suite2",true);
	}

}
