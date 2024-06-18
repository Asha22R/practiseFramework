package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class GetDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		// step1: Load/register the database driver
		Connection connection = null;
		try {
		Driver d = new Driver();//[get driver refrence from my SQl jar]
		DriverManager.registerDriver(d);

		//step2: get a connection to database
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
		System.out.println("Connection is set");
		
		//Step3: Create SQL statement
		Statement st = connection.createStatement();
		
		//Step4: execute select query and get result
		ResultSet resObj = st.executeQuery("select * from employee");
		while(resObj.next()) {
			System.out.println(resObj.getString(1)+"\t"+resObj.getString(2)+"\t"+resObj.getString(3)+"\t"+resObj.getString(4));
		}}
		catch (Exception e) {
			System.out.println("Exception handled");
		}
		
		finally {
			//Step5: close the connection
			connection.close();
		}
		
	}

}
