<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="org.jss.entity.*" %>
<c:import url="include/header.jsp"><c:param name="title" value="Logged user"/></c:import>
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
			
	<a><b>Successfully logged in!!!!</b></a>	
			
			
		 <br/>
  <br/>
  <br/> 
		</div>
	</div>
</div>

<div class="container mtb">
	<div class="row">
		<div style="padding:20px">
			<strong>Your Information</strong>
			<hr />
			<table class="table table-striped table-dark">
				<thead>
					<th>User ID</th>
					<th>Name</th>
					<th>Age</th>
					<th>Phone number</th>
					<th>Address</th>
					<th>Password</th>
				</thead>
				<%!String deleteURL;%>
				<%
					List<User> listuser = (List) request.getAttribute("listuser");
					String updateURL;
					for (int i = 0; i < listuser.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listuser.get(i).getU_id() + "</td>");
						out.print("<td>" + listuser.get(i).getName() + "</td>");
						out.print("<td>" + listuser.get(i).getAge() + "</td>");
						out.print("<td>" + listuser.get(i).getPhone() + "</td>");
						out.print("<td>" + listuser.get(i).getAddress() + "</td>");
						out.print("<td>" + listuser.get(i).getPassword() + "</td>");
						updateURL = request.getContextPath() + "/usercon?page=userupd" + "&u_id="
								+ listuser.get(i).getU_id() + "&name=" + listuser.get(i).getName() + "&age="
								+ listuser.get(i).getAge() + "&phone=" + listuser.get(i).getPhone() +"&address="
								+ listuser.get(i).getAddress() + "&password=" + listuser.get(i).getPassword();
						deleteURL = request.getContextPath() + "/usercon?page=userdel" + "&u_id="
								+ listuser.get(i).getU_id();
						out.print("<td><a class=\"btn btn-outline-danger\" href=" + updateURL + "> Update </a>   |  ");
				%>
				<a class="btn btn-outline-danger" href="<%=deleteURL%>"
					onclick="if(!confirm('Are you sure to delete the user?')) return false"> Delete </a>
				</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</div>
<br/>
<br/>
<div class="container mtb">
	<div class="row">
		<div style="padding:20px">
			<strong>Listing borrow information</strong>
			<hr />
			<table class="table table-striped table-dark">
				<thead>
					<th>Book ID</th>
					<th>Date if Issue</th>
					<th>Due Date</th>
				</thead>
				<%
					List<lending> listlen = (List) request.getAttribute("listlen");
					for (int i = 0; i < listlen.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listlen.get(i).getB_id() + "</td>");
						out.print("<td>" + listlen.get(i).getDay_out() + "</td>");
						out.print("<td>" + listlen.get(i).getDue_date() + "</td>");
				%>
				<%
					}
				%>
			</table>
		</div>
	</div>
</div>
<br/>
<br/>
<br/>
<br/>
</body>
</html>
<c:import url="include/footer.jsp"></c:import>