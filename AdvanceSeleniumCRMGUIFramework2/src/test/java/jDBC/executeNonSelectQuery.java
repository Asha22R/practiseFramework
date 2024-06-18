package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class executeNonSelectQuery {

	public static void main(String[] args) throws SQLException {
		// step1: Load/register the database driver
		Driver d = new Driver();//[get driver refrence from my SQl jar]
		DriverManager.registerDriver(d);

		//step2: get a connection to database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
		System.out.println("Connection is set");

		//Step3: Create SQL statement
		Statement st = connection.createStatement();

		//Step4: execute select query and get result
		int resObj = st.executeUpdate("insert into employee values(9, 'Vignesh', 40000, 'Trainer') ");
		System.out.println(resObj);
		

		//Step5: close the connection
		connection.close();


	}

}
