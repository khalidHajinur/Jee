package com.SwingWebUI.Welcome;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
	request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException 
{

    //set up connection variable
    String jdbcUrl = "jdbc:mysql://localhost:8889/results?useSSL=false";
    String user = "root";
    String pass = "root";
    String driver = "com.mysql.jdbc.Driver";

    try {

        

        

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

        String query = "SELECT * FROM swing";

        // create the java statement
        Statement st = conn.createStatement();
        
        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);
        
        // iterate through the java resultset
        while (rs.next())
        {
          int id = rs.getInt("id");
          String input_text = rs.getString("input_text");
          String radiobutton = rs.getString("radiobutton");
          String result= rs.getString("result");
          
          // print the results
        }
        st.close();

       conn.close();

    } catch (Exception exc) {
        exc.printStackTrace();
    }
   
      try
      {
         Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

        Statement st = conn.createStatement();
        st.executeUpdate("INSERT INTO swing " +
                         "VALUES (default,'BREAKFAST' , 'BLEND','no')");
      }
      catch (SQLException ex)
      {
        System.err.println(ex.getMessage());
      }
      
      try
      {
         Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

        Statement st = conn.createStatement();
        st.executeUpdate("DELETE FROM swing  WHERE ID =18 ");
      }
      catch (SQLException ex)
      {
        System.err.println(ex.getMessage());
      }
    
    }
}