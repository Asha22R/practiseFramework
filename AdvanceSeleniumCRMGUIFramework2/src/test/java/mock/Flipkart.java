package mock;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Samsung",Keys.ENTER);
		List<WebElement> pname = driver.findElements(By.xpath("//div[@class=\"slAVV4\"]//a[@class=\"wjcEIp\"]"));
		List<WebElement> pprice = driver.findElements(By.xpath("//div[@class=\"slAVV4\"]//div[@class=\"Nx9bqj\"]"));
		FileInputStream fis = new FileInputStream("./Screenshot/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Flipkart");
		int rownum = 0;
		for(WebElement e : pname) {
			String text = e.getText();
			for(WebElement e1: pprice) {
				String price = e1.getText();
				System.out.println(text +"\t"+price);
				Row row = sheet.createRow(rownum++);
				row.createCell(0).setCellValue(text);
				row.createCell(1).setCellValue(price);
				}
		}
		FileOutputStream fos = new FileOutputStream("./Screenshot/Book1.xlsx");
		wb.write(fos);
		wb.close();
		driver.quit();
	}

}
