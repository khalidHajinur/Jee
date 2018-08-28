/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.SwingWebUI.Welcome.Input;
import com.SwingWebUI.Welcome.People;

/**
 * @author khalidhaji
 *
 */
public class ReadQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadQuery(String dbname, String uname, String pwd) {
		String url="jdbc:mysql://localhost:3306/results";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doRead() {
		String query ="SELECT * from tablename";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public String getHTMLTable() {
		String table ="";
		
		table+="<table border=1>";
		
		try {
			while(this.results.next()) {
				
				People person = new People("Khalid", "Hajinur");
				person.setName(this.results.getString("first"));
				person.setSurName(this.results.getString("last"));
				
				table+="<tr>";
				table+="<td>";
				person.getName();
				table+="</td>";
				table+="<td>";
				person.getSurName();
				table+="</td>";
				table+="<td>";
				table+= "<a href =update?first="+ person.getName()+ "> update</a><a href =delete?first="+ person.getName()+"> delete</a> ";
				table+="</td>";
				table+="</tr>";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table+="</table>";
		
		return table;
		
	}
	
	

}
