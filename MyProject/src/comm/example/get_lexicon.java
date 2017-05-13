package comm.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class get_lexicon {
	
	
	private static Statement statement=null;
	private static ResultSet rs=null;
	private static Connection con=null;
	
	public ArrayList<String> get_pos_lexicon(){
            ArrayList<String>pos_arr=new ArrayList<String>();
	        String selectQuery="Select * from pos_lexicon order by id asc";
	
	        String selectQueryNeg="Select * from neg_lexicon order by id asc";
	  try {
	   Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bristy","bristy420");
		
		//System.out.println("connection established");
		statement=con.createStatement();


      rs=statement.executeQuery(selectQuery);
      
      while(rs.next())
		{
    
      
      	pos_arr.add(rs.getString(2));
      	
		}
      
	  }
		catch (Exception e1) {
			e1.printStackTrace();
		}
	return pos_arr;

	  }
	
	
	public ArrayList<String> get_neg_lexicon()
	   {
		 ArrayList<String>neg_arr=new ArrayList<String>();
	String selectQuery="Select * from neg_lexicon order by id asc";
	  try {
	   Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bristy","bristy420");
		
		//System.out.println("connection established");
		statement=con.createStatement();


     rs=statement.executeQuery(selectQuery);
     
     while(rs.next())
		{
   
     
     	neg_arr.add(rs.getString(2));
     	
		}
     
	  }
		catch (Exception e1) {
			e1.printStackTrace();
		}
	return neg_arr;

	  }
	
	
	public ArrayList<String> get_bangla_pos_lexicon(){
        ArrayList<String>pos_arr=new ArrayList<String>();
        String selectQuery="Select * from pos_lexicon order by id asc";

        String selectQueryNeg="Select * from neg_lexicon order by id asc";
  try {
   //Class.forName("oracle.jdbc.driver.OracleDriver");
	//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bristy","bristy420");
	con=ConnectDB.getConnection("myproject");
	//System.out.println("connection established");
	statement=con.createStatement();


  rs=statement.executeQuery(selectQuery);
  
  while(rs.next())
	{

  
  	pos_arr.add(rs.getString(2));
  	
	}
  
  }
	catch (Exception e1) {
		e1.printStackTrace();
	}
return pos_arr;

  }


public ArrayList<String> get_bangla_neg_lexicon()
   {
	 ArrayList<String>neg_arr=new ArrayList<String>();
String selectQuery="Select * from neg_lexicon order by id asc";
  try {
      
	  
	  con=ConnectDB.getConnection("myproject");
	statement=con.createStatement();


 rs=statement.executeQuery(selectQuery);
 
 while(rs.next())
	{

 
 	neg_arr.add(rs.getString(2));
 	
	}
 
  }
	catch (Exception e1) {
		e1.printStackTrace();
	}
return neg_arr;

  }
	
	
	
}
