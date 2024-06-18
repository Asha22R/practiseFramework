package practise;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class SampleReportTest {
	ExtentReports report;
	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRMReport");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("browser", "Chrome-121");
	}

	@AfterSuite
	public void configAS() {

	}
	@Test
	public void createContactTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		TakesScreenshot ts = (TakesScreenshot)driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);

		ExtentTest test= report.createTest("CreateContactTest1");

		test.log(Status.INFO,"Login to App");
		test.log(Status.INFO, "Naviagte to contact page");
		test.log(Status.INFO, "Create contact");
		if("HDFbbbC".equals("HDgfFC")) {
			test.log(Status.PASS, "Contact is created");
		}
		else {
			test.addScreenCaptureFromBase64String(src, "ErrorFile");
		}
		report.flush();
		driver.close();
	}
}
