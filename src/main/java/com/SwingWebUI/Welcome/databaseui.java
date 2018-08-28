package com.SwingWebUI.Welcome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class databaseui {

	public static void main(String[] args) throws Exception {
		creatTable ();
		post();
	}
	
	public static void post() throws Exception {
	   final  String var1 ="khalid";
	   final String var2="dave";
	   try {
		   Connection con = getConnection();
		PreparedStatement posted = con.prepareStatement("INSERT INTO tablename(first, last ) VALUES ('"+var1+"','"+var2+"')");
           posted.executeLargeUpdate();
	   } catch  (Exception e){System.out.println(e);}
	   finally {
			System.out.println("psot Complete.");
			};
	}
	
	public static void creatTable () throws Exception {
		try{
			Connection con =getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS tablename(id int(10) NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();
			
	        } catch (Exception e){System.out.println(e);}
		      finally {
			System.out.println("Function Complete.");
			};
		}
	
	public static Connection getConnection()  throws Exception {
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/results";
			String user="root";
			String password="root";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("connected");
			return conn;
		    } catch(Exception e ) { System.out.println(e);
		    }
		return null;
	}
}
