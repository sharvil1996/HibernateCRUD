<%@page import="bean.CityBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		CityBean bean = (CityBean) request.getAttribute("cityBean");
	%>
	<form action="CityUpdateServlet">
		<input type="hidden" name="cityId" value="<%=bean.getCityId()%>">
		<table border="1">

			<tr>
				<td>Enter City Name</td>
				<td><input type="text" name="cityName"
					value="<%=bean.getCityName()%>"></td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" name="submit" value="Submit">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>