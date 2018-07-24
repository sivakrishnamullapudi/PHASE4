<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updated balance</title>
</head>
<body>

<h1>Updated Balance</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Mobile number</th><th>Name</th><th>Balance</th> 
  
   <tr>  
   <td>${customer.mobileNo}</td>  
   <td>${customer.name}</td>  
   <td>${customer.wallet}</td>  
 
  

   </tr>  
  
   </table>  
   <br/>  
   <a href="indexpage">Home</a>
  
</body>
</html>