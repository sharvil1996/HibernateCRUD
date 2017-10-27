<%@page import="bean.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CityDAO"%>
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
		UserBean user = (UserBean) request.getAttribute("userBean");
		if (user != null) {
	%>
	<form action="UserUpdateServlet">
	<input type="hidden" name="userId" value="<%=user.getUserId()%>">
		<table>
			<tr>
				<td>Enter User Name</td>
				<td><input type="text" name="userName"
					value="<%=user.getUserName()%>"></td>
			</tr>
			<tr>
				<td>Select City</td>
				<td><select name="cityName">
						<option value="0" selected="selected">Select City</option>
						<%
							CityDAO cityDAO = new CityDAO();

								List<CityBean> cityList = cityDAO.listCity();

								for (int i = 0; i < cityList.size(); i++) {
									CityBean citybean = cityList.get(i);
									if (user.getCity().getCityId() == (citybean.getCityId())) {
						%>
						<option value="<%=citybean.getCityId()%>" selected="selected"><%=citybean.getCityName()%></option>
						<%
							} else {
						%>
						<option value="<%=citybean.getCityId()%>"><%=citybean.getCityName()%></option>
						<%
							}
								}
						%>
				</select></td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" name="submit" value="Submit" /></td>
			</tr>
		</table>
		<%
			}
		%>
	</form>
</body>
</html>