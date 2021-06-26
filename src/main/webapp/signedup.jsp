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
 <a><b>Successfully signed up!!!!</b></a>
  <a><b>Hurry now and go to login page!!!!</b></a>

  
  <div class="container mtb">
	<div class="row">
		<div style="padding:20px">
			<strong>Listing admins</strong>
			<hr/>
			<table class="table table-striped table-dark">
			<thead>
			<th> Username </th>
			</thead>
			<%
			List<admin> listadmin = (List)request.getAttribute("listadmin");
			for(int i=0;i<listadmin.size(); i++){
				out.print("<tr>");
				
				out.print("<td>"+listadmin.get(i).getUsername()+"</td>");
				
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