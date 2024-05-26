<%@page import="com.jspiders.cardekhomvc.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body {
	background-color: #00DBDE;
background-image: linear-gradient(90deg, #00DBDE 0%, #FC00FF 100%);
	
}
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

#data {
	background-color:black;
	border: 2px solid white;
	width: 500px;
	color: white;
}

#data td {
	border: 1px solid white;
	text-align: center;
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Remove Car Details</legend>
			<form action="./remove" method="post">
				<table>
					<tr>
						<td>Enter Car ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="REMOVE">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3>
			<%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (cars != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>Car Name</th>
				<th>Car Model</th>
				<th>Fuel</th>
				<th>Price</th>
			</tr>
			<%
			for (CarPOJO pojo : cars) {
				%>
				<tr>
					<td><%=pojo.getId()%></td>
					<td><%=pojo.getCarName()%></td>
					<td><%=pojo.getModel()%></td>
					<td><%=pojo.getFuel()%></td>
					<td><%=pojo.getPrice()%></td>
				</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>