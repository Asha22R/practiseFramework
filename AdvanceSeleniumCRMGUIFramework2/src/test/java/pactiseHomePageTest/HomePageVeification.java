package pactiseHomePageTest;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVeification {
	@Test
	public void HomepageTest(Method mtd) {
		System.out.println(mtd.getName()+" Test Start");

		String expTitle = "Home page";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		String ele = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//hard Assert
		Assert.assertEquals(ele, expTitle);
		driver.close();
		System.out.println(mtd.getName()+"  Test end");
	}

	@Test
	public void VerifyhomepageLogoTest(Method mtd) {
		System.out.println( mtd.getName()+ " Test Start");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		boolean status = driver.findElement(By.xpath("//img[@title=\"vtiger-crm-logo.gif\"]")).isEnabled();
		//Assert.assertEquals(status,true);
		//hard Assert
		Assert.assertTrue(status);
		driver.close();
		System.out.println(mtd.getName()+"  Test end");
	}
}
