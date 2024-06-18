package Json;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.mysql.cj.jdbc.Driver;

public class CreateOrgFetchDataFromJSONFile {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		JSONParser parse = new JSONParser();
	    Object obj = parse.parse(new FileReader("C:\\Users\\User\\Desktop\\data\\appCommonData.json"));
	    JSONObject map = (JSONObject)obj;
	    Object browser = map.get("browser");
	    WebDriver driver ;
	    if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(map.get("url").toString());
		driver.findElement(By.name("user_name")).sendKeys(map.get("username").toString());
		driver.findElement(By.name("user_password")).sendKeys(map.get("password").toString());
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		Random random = new Random();
		int  ranInt  =random.nextInt(1000);
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		// read test script data from excel
		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Desktop\\data\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String orgname = wb.getSheet("org").getRow(1).getCell(2).toString()+ranInt;
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		wb.close();
		Thread.sleep(2000);
		driver.close();
	}@Test
	public void getDataFromJson() throws FileNotFoundException, IOException, ParseException {
		JSONParser par = new JSONParser();
		Object obj = par.parse(new FileReader("C:\\\\Users\\\\User\\\\Desktop\\\\data\\\\appCommonData.json"));
		JSONObject map = (JSONObject)obj;
		String val = (String)map.get("url");
		System.out.println(val);
	}
	@Test
	public void readDataFromXML(XmlTest test) {
		System.out.println(test.getParameter("username"));
	}
	@Test
	public void readDataFromDatabase() throws SQLException {
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select * from employee");
		while(res.next()) {
			System.out.println(res.getString(1)+res.getString(2)+res.getString(3));
		}
		st.executeUpdate("insert into employee value(10,'acchu', 5000, 'Student')");
		con.close();
	}
	@Test
	public void getDate() {
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		String date = s.format(d);
		System.out.println(date);
		Calendar cal = s.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,-30);
		System.out.println(s.format(cal.getTime()));
	}
	
}
