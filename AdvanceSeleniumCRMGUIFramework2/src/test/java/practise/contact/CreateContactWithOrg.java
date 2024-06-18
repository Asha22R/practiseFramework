package practise.contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrg {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\data\\commondata1.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		//generate random number
		Random random = new Random();
		int  ranInt  =random.nextInt(1000);

		// read test script data from excel
		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Desktop\\data\\map.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String orgname = wb.getSheet("contact").getRow(7).getCell(2).toString()+ranInt;
		String contactLastName = wb.getSheet("contact").getRow(7).getCell(3).toString()+ranInt;
		WebDriver driver = null;
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}else
		{
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		
		// verify the header msg expected result and org info
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgname)) {
			System.out.println(orgname +" is created");
		}else {
			System.out.println(orgname +" is not created");
		}
		// creation of the contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();
		
		// switch to child window
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> i1 = allwh.iterator();
		while(i1.hasNext()) {
			String windowId = i1.next();
			driver.switchTo().window(windowId);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("module=Accounts")) {
				break;
			}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@class=\"lvtCol\"]/../../tr[2]/td/a")).click();
		
		// switch to parent window
		Set<String> allwh1 = driver.getWindowHandles();
		Iterator<String> it1 = allwh1.iterator();
		while(it1.hasNext()) {
			String windowId = it1.next();
			driver.switchTo().window(windowId);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("module=Contacts&action/")) {
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();
		String headertext= driver.findElement(By.className("dvHeaderText")).getText();
		if(headertext.contains(contactLastName)) {
			System.out.println(contactLastName+" is created");
		}else {
			System.out.println(contactLastName+" is not created");
		}
		driver.quit();
		wb.close();

	}

}
