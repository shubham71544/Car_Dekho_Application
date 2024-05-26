<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
  margin: auto;
  
 
 
 }
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
      
	 margin: 250px 520px; 
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background: rgb(238,174,202);
background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(162,148,233,1) 50%);
}
</style>
</head>
<body>

	<div align="center">
		<%
		if (msg != null) {
		%>
		<h4>
			<%=msg%>
		</h4>
		<%
		}
		%>
		<fieldset>
			<legend>Login Page</legend>
			<form action="./login" method="post">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="LOGIN">
			</form>

		</fieldset>
		<a href="http://localhost:8080/cardekhomvc/createAccount">Create
			Account</a>
	</div>

</body>
</html>
