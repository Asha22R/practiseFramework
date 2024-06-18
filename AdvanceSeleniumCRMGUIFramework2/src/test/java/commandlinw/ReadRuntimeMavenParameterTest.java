package commandlinw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {
@Test 
public 
void runtimeParameterTest()
{
	String url = System.getProperty("url");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(System.getProperty("un"));
	driver.findElement(By.name("user_password")).sendKeys(System.getProperty("pwd"));
	driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
}
}
