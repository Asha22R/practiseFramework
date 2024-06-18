package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDB {
	public static void main(String[] args) throws SQLException {
		//create project in GUI
		Random r = new Random();
		int n= r.nextInt(100);
		String pName = "facebook"+n;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://106.51.90.215:8084");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(pName);
		driver.findElement(By.name("createdBy")).sendKeys("dummy");
		Select s = new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
		s.selectByVisibleText("On Going");
		driver.findElement(By.xpath("//input[@value=\"Add Project\"]")).click();
		
		// verify the project in db
		boolean flag = false;
		Driver dr = new Driver();
		DriverManager.registerDriver(dr);
		Connection con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("Connection is done");
		Statement st = con.createStatement();
		ResultSet proj = st.executeQuery("select * from project");
		while(proj.next()) {
			String actname = proj.getString(4);
			if(actname.equals(pName)) {
				flag = true;
				System.out.println(pName+" is available in DB ");
				}
		}
		if(flag==false) {
			System.out.println(pName+" is not available in DB ");
		}
		con.close();
	}
}
