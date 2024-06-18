package mock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbaddi {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.prokabaddi.com/");
		System.out.println(driver.findElement(By.xpath("//p[text()='Bengaluru Bulls']")).getText());
		List<WebElement> list = driver.findElements(By.xpath("//p[text()='Bengaluru Bulls']/../../../..//ul/li"));
		for (WebElement webElement : list) {
			System.out.println(webElement.findElement(By.tagName("p")).getText());
		}
		System.out.println(driver.findElement(By.xpath("//p[text()='Bengaluru Bulls']/../../../..//div[@class=\"table-data points\"]/p")).getText());
		driver.quit();
	}

}
