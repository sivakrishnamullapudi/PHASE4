<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2><u>Enter User Details</u></h2>
		<table>
		
			<form:form action="transferamt" method="post"  modelAttribute="customer">
			
				<tr>
					<td>SourceMobileNo:</td>
					<td><form:input path="mobileNo" size="10" /></td>
				</tr>
				
				<tr>
					<td>TargetMobileNo:</td>
					<td><form:input path="name" size="10" /></td>
				</tr>

				<tr>
					<td>TransferAmount:</td>
					<td><form:input path="wallet.balance" size="30" /></td>
				</tr>
					<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</form:form>
		</table>
		 <a href="indexpage">Home</a>
</body>
</html>