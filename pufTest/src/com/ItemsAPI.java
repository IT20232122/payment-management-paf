package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;





@WebServlet("/ItemsAPI")
public class ItemsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 { 
		 String[] p = param.split("="); 
		 map.put(p[0], p[1]); 
		 } 
		 } 
		catch (Exception e) 
		 { 
		 } 
		return map; 
		}

	
	
	
    
    public ItemsAPI() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Item itemObj = new Item(); 
		String output = itemObj.insertItem(
				request.getParameter("name"), 
				 request.getParameter("address"), 
				 request.getParameter("email"),
				 request.getParameter("type"),
				 request.getParameter("amount"),
				request.getParameter("status")); 				
				response.getWriter().write(output);
		
		//doGet(request, response);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Item itemObj = new Item(); 
		Map paras = getParasMap(request); 
		 String output = itemObj.updateItem(
				 paras.get("hidItemIDSave").toString(), 
		 paras.get("name").toString(), 
		 paras.get("address").toString(),
		 paras.get("email").toString(),
		 paras.get("type").toString(),
		paras.get("amount").toString(), 
		paras.get("status").toString()); 
		response.getWriter().write(output); 
		
		
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Item itemObj = new Item();
		Map paras = getParasMap(request); 
		 String output = itemObj.deleteItem(paras.get("id").toString()); 
		response.getWriter().write(output);
		
		
		
	}

}
