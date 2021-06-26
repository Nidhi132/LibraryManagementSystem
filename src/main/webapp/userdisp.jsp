<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="org.jss.entity.*" %>
<c:import url="include/header.jsp"><c:param name="title" value="List admins"/></c:import>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<br/>
<br/>
<br/>
  <br/>
  <br/>
  <br/>
  <div class="container mtb">
	<div class="row">
		<div style="padding:20px">
			<strong>After deletion users table</strong>
			<hr/>
			<table class="table table-striped table-dark">
			<thead>
			<th> UserID </th>
			<th> Name </th>
			<th> Address </th>
			</thead>
			<%
			List<User> listuser = (List)request.getAttribute("listuser");
			for(int i=0;i<listuser.size(); i++){
				out.print("<tr>");
				
				out.print("<td>"+listuser.get(i).getU_id()+"</td>");
				
				out.print("<td>"+listuser.get(i).getName()+"</td>");
				
				out.print("<td>"+listuser.get(i).getAddress()+"</td>");
				
				out.print("</tr>");
			}
			
			%>
			</table>
		</div>
	</div>
</div>
</body>
</html>
<c:import url="include/footer.jsp"></c:import>