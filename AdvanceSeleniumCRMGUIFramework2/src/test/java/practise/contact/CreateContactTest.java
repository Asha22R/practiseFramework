package practise.contact;

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

public class CreateContactTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
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
		String contact = wb.getSheet("contact").getRow(1).getCell(2).toString()+ranInt;
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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(contact);
		driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();
		String headertext= driver.findElement(By.className("dvHeaderText")).getText();
		if(headertext.contains(contact)) {
			System.out.println(contact+" is created");
		}else {
			System.out.println(contact+" is not created");
		}
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastName.equals(contact)) {
			System.out.println(contact+" is verified");
		}else {
			System.out.println(contact+" is not verifed");
		}
		driver.close();
	}

}
