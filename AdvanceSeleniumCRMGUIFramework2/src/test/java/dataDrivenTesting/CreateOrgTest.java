package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.exec.TimeoutObserver;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// reading common data from properties
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\data\\commondata1.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
//		System.out.println(browser);
//		System.out.println(url);
//		System.out.println(un);
//		System.out.println(pwd);

		WebDriver driver = null;
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();

		//generate random number
		Random random = new Random();
		int  ranInt  =random.nextInt(1000);
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		// read test script data from excel
		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Desktop\\data\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String orgname = wb.getSheet("org").getRow(1).getCell(2).toString()+ranInt;
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
//		Actions a = new Actions(driver);
//		a.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")));
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		wb.close();
		Thread.sleep(2000);
		driver.close();
	}
}
