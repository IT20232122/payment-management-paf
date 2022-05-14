<%@page import="com.Item"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
      
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Managment System</title>

	<!-- links -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
	<link rel="stylesheet" href="View/docs.min.css">
	<script src="Components/jquery.min.js" type="text/javascript"></script>
	<script src="Components/items.js" type="text/javascript"></script>
	
<style >
	body{
    background-color: #0a140b;
    background-image:url("background.jpg");
    background-repeat: no-repeat;
 	 background-size: auto;
 	 min-height: 100%;
 	 background-size: cover;
 	 background-position: center center;
	}
	
	
	
	input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
.col-6 {
  	background-color: rgba(255,255,255,0.13);   
    top: 50%;
    position: center center;
    border-radius: 10px;
    backdrop-filter: blur(10px);
    border: 2px solid rgba(255,255,255,0.1);
    box-shadow: 0 0 40px rgba(8,7,16,0.6);
    
}
	</style>

	

</head>
<body>

	<div class="container"><div class="row"><div class="col-6"> 
    	<h1>Payment Management System</h1>
    		<form id="formItem" name="formItem">
    	
    			
    			Monthly Payment :
    				<input class="input--style-2" type = "text" id = "mpayment"/> <br>
		    	Previous Payments :
		    	    <input class="input--style-2" type = "text" id = "ppayment"/> <br>
		    	    Total Payment :
		    	    <span id = "tpay" ></span><br>
		    	Total Payment :   
		    		<input id="unifee" name="unifee" type="text" class="form-control form-control-sm"><br>
		    
		    	
		    	
		    	<button class="btn btn-primary" type="button" onClick = "tpayment()"   >Total Payment</button><br>
				
		    
		        Current Payment :
    				<input class="input--style-2" type = "text" id = "cpayment"/> <br>
    			Rest of Payment :
		    	    <span id = "restpay" ></span><br>
    			Rest of Payment :   
		    		<input id="restpayment" name="restpayment" type="text" class="form-control form-control-sm"><br>
		        
		        
				<input id="btnSave" name="btnSave" type="button"  onClick = "calc()" value="Calculate" class="btn btn-primary">
				
				<br><br>
			     <div class="p-t-30">
                    <a href = "items.jsp"><button class="btn btn-primary" type = "button">Next</button></a><br><br>
                    </div>
                    		</th>
                    		<td>&nbsp&nbsp&nbsp</td>
                    		<th>
     
    			</div>
    		</div>
     	</div>
     </div> 
   
<script>
    function tpayment()
    {    
    	mpayment = document.getElementById("mpayment").value;
    	ppayment = document.getElementById("ppayment").value;
    	
    	var a = parseInt(mpayment);
    	var b = parseInt(ppayment);
  		
   	
  		document.getElementById("tpay").innerHTML =a+b; 
  		document.getElementById("unifee").value = document.getElementById("tpay").textContent;
  		
  		
  		
    }
    function calc()
	{    
    	cpayment = document.getElementById("cpayment").value;
    	tpayment = document.getElementById("unifee").value;
    	
    	document.getElementById("restpay").innerHTML = tpayment - cpayment;
    	document.getElementById("restpayment").value = document.getElementById("restpay").textContent;
    	
  		
  		
	}
  </script>
  
  
</body>
</html>>