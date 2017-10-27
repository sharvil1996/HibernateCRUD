<%@page import="bean.UserBean"%>
<%@page import="bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<UserBean> list = (ArrayList<UserBean>) request.getAttribute("userBean");
		if (list != null) {
	%>
	<table border="1" width="50%" align="center">
		<tr>
			<td align="center"><b>User ID</b></td>
			<td align="center"><b>User Name</b></td>
			<td align="center"><b>City Name</b></td>
			<td align="center"><b>Delete</b></td>
			<td align="center"><b>Edit</b></td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
					UserBean userBean = list.get(i);
		%>
		<tr>
			<td align="center"><%=userBean.getUserId()%></td>
			<td align="center"><%=userBean.getUserName()%></td>
			<td align="center"><%=userBean.getCity().getCityName()%></td>
			<td align="center"><a
				href="UserDeleteServlet?userId=<%=userBean.getUserId()%>">Delete</a></td>
			<td align="center"><a
				href="UserEditServlet?userId=<%=userBean.getUserId()%>">Edit</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} else {
	%>
	<h3>No Users Present</h3>
	<%
		}
	%>
</body>
</html>