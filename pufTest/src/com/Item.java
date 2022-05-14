package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class Item 
{ 
private Connection connect() 
 { 
 Connection con = null; 
 try
 { 
 Class.forName("com.mysql.jdbc.Driver"); 
 con = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3307/paymentproject", "root", ""); 
 } 
 catch (Exception e) 
 { 
 e.printStackTrace(); 
 } 
 return con; 
 } 
public String readItems() 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting to the database for reading."; 
 } 
 // Prepare the html table to be displayed
 output = "<table border='1'><tr><th>name</th> <th>address</th><th>email</th> <th>type</th><th> amount</th> <th>status</th><th>Update</th><th>Remove</th></tr>"; 
 String query = "select * from payment"; 
 Statement stmt = con.createStatement(); 
 ResultSet rs = stmt.executeQuery(query); 
 // iterate through the rows in the result set
 while (rs.next()) 
 { 
 String id = Integer.toString(rs.getInt("id")); 
 String name = rs.getString("name");
 String address = rs.getString("address"); 
 String email = rs.getString("email");
 String type = rs.getString("type");
 String amount = Double.toString(rs.getDouble("amount")); 
 String status = rs.getString("status");

 // Add into the html table
output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + id+ "'>" + name + "</td>"; 
 output += "<td>" + address + "</td>"; 
 output += "<td>" + email + "</td>"; 
 output += "<td>" + type + "</td>"; 
 output += "<td>" + amount + "</td>"; 
 output += "<td>" + status + "</td>"; 
  
 // buttons
output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-id='"+ id + "'></td>"+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='"+ id + "'>" + "</td></tr>"; 
 } 
 con.close(); 
 // Complete the html table
 output += "</table>"; 
 } 
 catch (Exception e) 
 { 
 output = "Error while reading the items."; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
public String insertItem(String name, String address, String email ,String type,String amount, String status) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting to the database for inserting."; 
 } 
 // create a prepared statement
 String query = " insert into payment (id, name, address,email,type,amount,status)"+"values (?,?,?,?,?,?,?)"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setInt(1, 0); 
		 preparedStmt.setString(2, name); 
		 preparedStmt.setString(3, address); 
		 preparedStmt.setString(4, email);
		 preparedStmt.setString(5, type);
		 preparedStmt.setString(6, amount);
		 preparedStmt.setString(7, status);
		  
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 String newItems = readItems(); 
		 output = "{\"status\":\"success\", \"data\": \"" + 
		 newItems + "\"}"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "{\"status\":\"error\", \"data\":  \"Error while inserting the item.\"}"; System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		public String updateItem(String id,String name, String address, String email, String type,String amount,String status) 
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 { 
		 return "Error while connecting to the database for updating."; 
		 } 
		 // create a prepared statement
		 String query = "update payment set name=?,address=?,email=?,type=?,amount=?,status=? WHERE id=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setString(1, name); 
		 preparedStmt.setString(2, address); 
		 preparedStmt.setString(3,email); 
		 preparedStmt.setString(4,type);
		 preparedStmt.setString(5,amount);
		 preparedStmt.setString(6,status);
		 preparedStmt.setInt(7, Integer.parseInt(id)); 
		// execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 String newItems = readItems(); 
		 output = "{\"status\":\"success\", \"data\": \"" + 
		 newItems + "\"}"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}"; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		public String deleteItem(String id) 
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 { 
		 return "Error while connecting to the database for deleting."; 
		 } 
		 // create a prepared statement
		 String query = "delete from payment where id=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(id)); 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 String newItems = readItems(); 
		 output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}"; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		}


