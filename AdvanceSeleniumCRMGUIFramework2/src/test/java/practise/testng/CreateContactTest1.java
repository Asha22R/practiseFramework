package practise.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest1 {
	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("Execute configBeforeSuite ");
	}
	
	@BeforeClass
	public void configBeforeClass() {
		System.out.println("Execute configBeforeClass ");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("Execute configBM ");
	}
	@Test
	public void createContact() {
		System.out.println("Execute createContact ");
	}
	@Test
	public void createContactWithDate() {
		System.out.println("Execute createContactWithDate ");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("Execute configAM ");
	}
	@AfterClass
	public void configAfterClass() {
		System.out.println("Execute configAfterClass ");
	}
	@AfterSuite
	public void configAfterSuite() {
		System.out.println("Execute configAfterSuite ");
	}
	

}
