package comm.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class tot {

	private static Statement statement=null;
	private static ResultSet rs=null;
	private static Connection con=null;
	private int rowCount;
	private int rowCountBangla;
	
	public int getRowCount() {
		
		int rowCount = 0;
		String selectQuery="Select count(*) from English_corpus";
		  try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bristy","bristy420");
			
		//	System.out.println("connection established");
			statement=con.createStatement();


	    rs=statement.executeQuery(selectQuery);
	    rs.next();
	     rowCount = rs.getInt(1);
	   // System.out.println(rowCount);

	    
		  }
			catch (Exception e1) {
				e1.printStackTrace();
			}
		
		
		return rowCount;
	}
	
public int getRowCountBangla() {
		
		int rowCountBangla = 0;
		String selectQuery="Select count(*) from bangla_corpus";
		  try {
		   con=ConnectDB.getConnection("myproject");
			statement=con.createStatement();


	    rs=statement.executeQuery(selectQuery);
	    rs.next();
	    rowCountBangla = rs.getInt(1);
	   // System.out.println(rowCount);

	    
		  }
			catch (Exception e1) {
				e1.printStackTrace();
			}
		
		
		return rowCountBangla;
	}
	
	


	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public void setrowCountBangla(int rowCountBangla) {
		this.rowCountBangla = rowCountBangla;
	}	
		
	
}
