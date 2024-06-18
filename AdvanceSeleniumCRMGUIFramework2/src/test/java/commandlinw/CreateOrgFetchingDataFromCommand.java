package commandlinw;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrgFetchingDataFromCommand {
	@Test
	public void login() throws EncryptedDocumentException, IOException, InterruptedException {
	WebDriver driver;
	String Browser = System.getProperty("browser");
	if (Browser.equals("chrome")) {
		driver = new ChromeDriver();
	}else if (Browser.equals("firefox")) {
		driver = new FirefoxDriver();
	}else if (Browser.equals("edge")) {
		driver = new EdgeDriver();
	}else {
		driver = new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(System.getProperty("url"));
	driver.findElement(By.name("user_name")).sendKeys(System.getProperty("un"));
	driver.findElement(By.name("user_password")).sendKeys(System.getProperty("pwd"));
	driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
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
	wb.close();
	Thread.sleep(2000);
	driver.close();
	
	}

}
