package practise.org;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/s?k=iphone+15+pro+max+case&crid=1FW8JP1M18263&sprefix=iphone%2Caps%2C1170&ref=nb_sb_ss_ts-doa-p_1_6");
	 List<WebElement> eles = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		for (WebElement webElement : eles) {
			System.out.println(webElement.findElement(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]")).getText());
			System.out.println(webElement.findElement(By.xpath("//span[@class=\"a-offscreen\"]")));
		}
	}

}
