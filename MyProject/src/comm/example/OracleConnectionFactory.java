package comm.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionFactory {
	
	private Connection connection=null;
	public Connection getOracleConnection()
	{
		//step-1
		try{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		//step-2
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");//right click on the project link and click properties
	//	System.out.println("connection established");
		
		}
		catch(SQLException e)
		{
			
		//	e.printStackTrace();
			System.out.println("connection did not established!!");
		}
		return connection;
		
		
		
	}
}
