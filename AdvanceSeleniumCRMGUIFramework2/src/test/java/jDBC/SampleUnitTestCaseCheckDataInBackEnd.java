package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCaseCheckDataInBackEnd {

	@Test
	public void checkTest() throws SQLException {
		String	expecName = "Asha R";
		boolean flag = false;
		// step1: Load/register the database driver
		Driver d = new Driver();//[get driver refrence from my SQl jar]
		DriverManager.registerDriver(d);

		//step2: get a connection to database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
		System.out.println("Connection is set");

		//Step3: Create SQL statement
		Statement st = connection.createStatement();

		//Step4: execute select query and get result
		ResultSet resObj = st.executeQuery("select * from employee");
		while(resObj.next()) {
		String accName = resObj.getString(2);
		if(accName.equals(expecName)) {
			flag= true;
			System.out.println(expecName+" Employee is available");
		}
		}
		if(flag==false) {
			System.out.println(expecName+" Employee is not available");
			Assert.fail();
		}

		//Step5: close the connection
		connection.close();

	}
}


