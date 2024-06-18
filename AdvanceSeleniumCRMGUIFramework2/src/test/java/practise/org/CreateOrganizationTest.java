package practise.org;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganizationTest {
	public static void main(String[] args) throws IOException {
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
		String orgname = wb.getSheet("org").getRow(1).getCell(2).toString()+ranInt;
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
		String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actorgname.equals(orgname)) {
			System.out.println(orgname +" is created");
		}else {
			System.out.println(orgname +" is not created");
		}
		driver.close();
	}

}
