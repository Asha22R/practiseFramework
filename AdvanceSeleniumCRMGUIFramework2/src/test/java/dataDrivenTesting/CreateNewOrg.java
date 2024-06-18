package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrg {

	public static void main(String[] args) throws IOException {
		// read data from properties
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\commondata1.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			driver= new ChromeDriver();
		}else if (browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			driver= new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		//read test Script data from excel file
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys("PESCE");
		driver.findElement(By.name("website")).sendKeys("pesce.com");
		WebElement sel = driver.findElement(By.xpath("//select[@name=\"industry\"]"));
		Select s = new Select(sel);
		s.selectByValue("Education");
		Select s1 = new Select(driver.findElement(By.xpath("//select[@name=\"accounttype\"]")));
		s1.selectByValue("Other");
		driver.findElement(By.id("phone")).sendKeys("9876545677");
		driver.findElement(By.id("email1")).sendKeys("ashartnp1@gmail.com");
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")));
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}

}
