package comm.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class InsertIntoDatabase {
	
	private static Statement statement=null;
	private static ResultSet rs=null;
	private static Connection con=null;
	
	 public ArrayList<ArrayList<String>> return_corpus_words()
     {
		
		 ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
		
		 
			String selectQuery="Select * from English_corpus order by document_id asc";
			  try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bristy","bristy420");
				statement=con.createStatement();


	            rs=statement.executeQuery(selectQuery);
	            int i=0;
	            while(rs.next())
				{
	            	 ArrayList<String>arr=new ArrayList<String>();
	            	
	            	String[] ss=rs.getString(2).split(" ");
	            	for(String sss:ss)
	            	{
	            		arr.add(sss);
	            		 
	            	}
	            	//System.out.println(">>>>>strings word>>>>"+i);
	            	
	            	
	            	for(int j=0;j<arr.size();j++)
	            	{
	            		listOfLists.add(i,arr);
	 
	                }
	            //	System.out.println(listOfLists.get(i));
	            	i++;
				}
	            
	           
			}
				catch (Exception e1) {
					e1.printStackTrace();
				}

     	
     	return listOfLists;
     	
     }
	
	
	 public ArrayList<ArrayList<String>> return_bangla_corpus_words()
	 {
		 

		 ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
		
		 
			String selectQuery="Select * from bangla_corpus order by document_id asc";
			  try {
				  con=ConnectDB.getConnection("myproject");
				statement=con.createStatement();
                 

	            rs=statement.executeQuery(selectQuery);
	            int i=0;
	            while(rs.next())
				{
	            	 ArrayList<String>arr=new ArrayList<String>();
	            	
	            	String[] ss=rs.getString(2).split(" ");
	            	for(String sss:ss)
	            	{
	            		arr.add(sss);
	            		 
	            	}
	            	
	            	for(int j=0;j<arr.size();j++)
	            	{
	            		listOfLists.add(i,arr);
	 
	                }
	            	//System.out.println(listOfLists.get(i));
	            	i++;
				}
	            
	           
			}
				catch (Exception e1) {
					e1.printStackTrace();
				}

     	
     	return listOfLists;
		 
		 
		 
	 }
	
	

}
