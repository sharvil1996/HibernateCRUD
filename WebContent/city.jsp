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
		//ArrayList<CityBean> list = (ArrayList<CityBean>) new CityDAO().listCity();
		ArrayList<CityBean> list = (ArrayList<CityBean>) request.getAttribute("cityBean");
		if (list != null) {
	%>
	<table border="1" width="50%" align="center">
		<tr>
			<td align="center"><b>City ID</b></td>
			<td align="center"><b>City Name</b></td>
			<td align="center"><b>Delete</b></td>
			<td align="center"><b>Edit</b></td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
					CityBean cityBean = list.get(i);
		%>
		<tr>
			<td align="center"><%=cityBean.getCityId()%></td>
			<td align="center" class="containsName"><span class="cityname"><%=cityBean.getCityName()%></span>
				<input type="text" class="citynamebox" style="text-align:center; display: none;" value="<%=cityBean.getCityName()%>"/></td>
			<td align="center"><span class="deletebutton"
				cityid="<%=cityBean.getCityId()%>"
				style="color: blue; text-decoration: underline; cursor: pointer;">Delete</span></td>
			<td align="center"><span class="editbutton"
				style="color: blue; text-decoration: underline; cursor: pointer;">Edit</span>
				<span class="updatebutton"
				cityid="<%=cityBean.getCityId()%>"
				style="color: blue; text-decoration: underline; cursor: pointer;display:none;">Update</span>
				<span class="cancelbutton"
				style="color: blue; text-decoration: underline; cursor: pointer;display:none;padding-left:10px;">Cancel</span>
			</td>
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
	<script src="jq.js"></script>
	<script src="code.js"></script>
</body>
</html>