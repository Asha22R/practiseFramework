package practise.org;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustry {

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
		String orgname = wb.getSheet("org").getRow(4).getCell(2).toString()+ranInt;
		String industry = wb.getSheet("org").getRow(4).getCell(3).toString();
		String type = wb.getSheet("org").getRow(4).getCell(4).toString();
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		Select s = new Select(driver.findElement(By.name("industry")));
		s.selectByValue("Energy");
		Select s1 = new Select(driver.findElement(By.name("accounttype")));
		s1.selectByValue("Press");
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		
		// verify the dropdown industry and type info
		
		String actindustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if(actindustry.equals(industry)) {
			System.out.println(industry +" is verified");
		}else {
			System.out.println(industry +" is not verified");
		}
		String acttype = driver.findElement(By.id("dtlview_Type")).getText();
		if(acttype.equals(type)) {
			System.out.println(type +" is verified");
		}else {
			System.out.println(type +" is not verified");
		}
		driver.close();
	}
}
