package pactiseHomePageTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		Random r = new Random();
		int ran = r.nextInt(100);
		//Step1: Create an object to EventFiring WebDriver
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		//Step2: use getScreenshotAs method to get file type of screenshot
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		//store screenshot in local driver
		FileUtils.copyFile(src, new File("./Screenshot/test"+ran+".png"));
		driver.close();
	}

}
