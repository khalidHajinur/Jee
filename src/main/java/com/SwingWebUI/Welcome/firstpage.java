package com.SwingWebUI.Welcome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = "/wel.do")
public class firstpage extends HttpServlet  {
	
	
				private InputServlet  inputserv = new InputServlet();
				private inputval  checkin = new inputval();
				
				
	
				protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws IOException, ServletException {
					
					 String jdbcUrl ="jdbc:mysql://localhost:8889/results?useSSL=false";
					    String user ="root";
					    String pass ="root";
					    String driver ="com.mysql.jdbc.Driver";
					    

					  
					    
					    
					request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);
				}
				protected void doPost(HttpServletRequest request, HttpServletResponse response)
						throws IOException, ServletException 
				{
			       
					String jdbcUrl = "jdbc:mysql://localhost:8889/results?useSSL=false";
				    String user = "root";
				    String pass = "root";
				    String driver = "com.mysql.jdbc.Driver";
					String input = request.getParameter("name"); 
					String radiobutton = request.getParameter("radiobutton"); 
					String original = input.toLowerCase();
					String Treverse = "";
					String pal="Palindrone";
					String notpal="Not Palindrone";
					

					int length = original.length();
					String stringlength= Integer.toString(length);

					
					boolean inputvalemp = checkin.validateAdd(input);
					try {

				        

				        

				        Class.forName(driver);

				        Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

				        String query = "SELECT * FROM swing where input_text ='"+original+"' AND radiobutton ='"+radiobutton+"'";

				        // create the java statement
				        Statement st = conn.createStatement();
				        
				        // execute the query, and get a java resultset
				        ResultSet rs = st.executeQuery(query);
				        
				        String input_text = null;
				        String result = null;          
				        String radiobuttons = null;
						// iterate through the java resultset
				        while (rs.next())
				        {
				          int id = rs.getInt("id");
				           input_text = rs.getString("input_text");
				          radiobuttons = rs.getString("radiobutton");
				           result= rs.getString("result");
				          
				          // print the results
				        }


				    String checkinput = input_text;
					

					if(!inputvalemp && "reverse".equals(radiobutton) && input_text == null) {
						try {
							Thread.sleep((long)(Math.random() * 1000));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						for (int i = length - 1; i >= 0; i--) {
							Treverse = Treverse + original.charAt(i);
						}
						  try {

						        Class.forName(driver);

						       
						       

						    } catch (Exception exc) {
						        exc.printStackTrace();
						    }
						   
						      try
						      {
						    	  
						          conn = DriverManager.getConnection(jdbcUrl, user, pass);

						         st = conn.createStatement();
						        st.executeUpdate("INSERT INTO swing " +
						                         "VALUES (default,'"+original+"' , 'reverse','"+Treverse+"')");
						      }
						      catch (SQLException ex)
						      {
						        System.err.println(ex.getMessage());
						      }
						      
						   

				    request.setAttribute("input", Treverse);
				    
					request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);
					
					}
					
					else if(!inputvalemp && "count".equals(radiobutton)&& input_text == null) {
						try {
							Thread.sleep((long)(Math.random() * 1000));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  try {

						        Class.forName(driver);

						       
						       

						    } catch (Exception exc) {
						        exc.printStackTrace();
						    }
						   
						      try
						      {
						    	  
						          conn = DriverManager.getConnection(jdbcUrl, user, pass);

						         st = conn.createStatement();
						        st.executeUpdate("INSERT INTO swing " +
						                         "VALUES (default,'"+original+"' , 'count','"+stringlength+"')");
						      }
						      catch (SQLException ex)
						      {
						        System.err.println(ex.getMessage());
						      }

				    request.setAttribute("input", stringlength);
					
					request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);
					
					}
					else if(!inputvalemp && "palindrome".equals(radiobutton)&& input_text == null) {
						try {
							Thread.sleep((long)(Math.random() * 1000));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						for (int i = length - 1; i >= 0; i--) {
							Treverse = Treverse + original.charAt(i);
							String Inputname = Treverse.toUpperCase();
						}
						if (original.equals(Treverse)) 
						{
							try {

						        Class.forName(driver);

						       
						       

						    } catch (Exception exc) {
						        exc.printStackTrace();
						    }
						   
						      try
						      {
						    	  
						          conn = DriverManager.getConnection(jdbcUrl, user, pass);

						         st = conn.createStatement();
						        st.executeUpdate("INSERT INTO swing " +
						                         "VALUES (default,'"+original+"' , 'palindrome','palindrome')");
						      }
						      catch (SQLException ex)
						      {
						        System.err.println(ex.getMessage());
						      }
						      
							
							request.setAttribute("input", pal);
							request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);

							
						}
						else
						{
							try {

						        Class.forName(driver);

						       
						       

						    } catch (Exception exc) {
						        exc.printStackTrace();
						    }
						   
						      try
						      {
						    	  
						          conn = DriverManager.getConnection(jdbcUrl, user, pass);

						         st = conn.createStatement();
						        st.executeUpdate("INSERT INTO swing " +
						                         "VALUES (default,'"+original+"' , 'palindrome','not palindrome')");
						      }
						      catch (SQLException ex)
						      {
						        System.err.println(ex.getMessage());
						      }
						      

							request.setAttribute("input", notpal);
							request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);

						}
						

						
					}
					else if (inputvalemp)
					{
						request.setAttribute("errorMessage", "Invalid Input types  Details");
						request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);
	
					}
					else if (!inputvalemp && input_text.equals(original) && "reverse".equals(radiobuttons) )
						
					{

						try {

					        Class.forName(driver);

					       
					       

					    } catch (Exception exc) {
					        exc.printStackTrace();
					    }
					   
					      String result2 = null;
						try
					      {
					    	  

							 String query2 = "SELECT * FROM swing where input_text ='"+original+"' AND radiobutton ='"+radiobutton+"'";
						   // create the java statement
				        Statement sts = conn.createStatement();
				        
				        // execute the query, and get a java resultset
				        ResultSet rss = st.executeQuery(query2);
					   
					       result2 = null;
					
					    	  
					    	
					    	  rss = sts.executeQuery(query2);

					   
					        while (rss.next())
					        {
					          int id = rss.getInt("id");
					           input_text = rss.getString("input_text");
					          radiobuttons = rss.getString("radiobutton");
					           result2= rss.getString("result");
					          
					          // print the results
					        }

					      }
					      catch (SQLException ex)
					      {
					        System.err.println(ex.getMessage());
					      }
						request.setAttribute("input", result2 +  "   results from the database ");
						request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);
	
					}
				
					else if (!inputvalemp && input_text.equals(original) && "count".equals(radiobuttons) )
					{
						
						try {

					        Class.forName(driver);

					       
					       

					    } catch (Exception exc) {
					        exc.printStackTrace();
					    }
					   
					      String result2 = null;
						try
					      {
					    	  

						String query2 = "SELECT * FROM swing where input_text ='"+original+"' AND radiobutton ='"+radiobutton+"'";
						   // create the java statement
				        Statement sts = conn.createStatement();
				        
				        // execute the query, and get a java resultset
				        ResultSet rss = st.executeQuery(query2);
					   
					       result2 = null;
					
					    	  
					    	
					    	  rss = sts.executeQuery(query2);


					   
					        if (rss.next())
					        {
					          int id = rss.getInt("id");
					           input_text = rss.getString("input_text");
					           radiobuttons = rss.getString("radiobutton");
					           result2= rss.getString("result");
					          
					          // print the results
					        }
					       
					      }
					      catch (SQLException ex)
					      {
					        System.err.println(ex.getMessage());
					      }
					      
						request.setAttribute("input", result2 +  " result from the database ");
						request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);
	
					}
					else if (!inputvalemp && input_text.equals(original) && "palindrome".equals(radiobuttons) )
						
					{
					      String result2 = null;


						try {

					        Class.forName(driver);

					       
					       

					    } catch (Exception exc) {
					        exc.printStackTrace();
					    }
					   
					   //   String result = null;
						try
					      {
					    	  

							 String query2 = "SELECT * FROM swing where input_text ='"+original+"' AND radiobutton ='"+radiobutton+"'";
						   // create the java statement
				        Statement sts = conn.createStatement();
				        
				        // execute the query, and get a java resultset
				        ResultSet rss = st.executeQuery(query2);
					   
					      // result2 = null;
					
					       result2 = null;

					    	
					    	  rss = sts.executeQuery(query2);

					   
					        while (rss.next())
					        {
					          int id = rss.getInt("id");
					           input_text = rss.getString("input_text");
					          radiobuttons = rss.getString("radiobutton");
					          result2= rss.getString("result");
					          
					          // print the results
					        }

					      }
					      catch (SQLException ex)
					      {
					        System.err.println(ex.getMessage());
					      }
						request.setAttribute("input", result2 +  "  this is from the database");
						request.getRequestDispatcher("/WEB-INF/views/firstpage.jsp").forward(request, response);
	
					}
					
				
					
					
			
			}catch (Exception exc) {
		        exc.printStackTrace();
		    }
		   

				
				}
}

