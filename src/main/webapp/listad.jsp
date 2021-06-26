<%@include file="include/header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="org.jss.entity.*"%>
<br/>
<br/>
<br/>
<br/>
<div class="container mtb">
	<div class="row">
		<div style="padding:20px">
			<strong>Listing borrow information</strong>
			<hr />
			
			<table class="table table-striped table-dark">
				<thead>
					<th>Username</th>
					<th>Password</th>
				</thead>
				<%!String deleteURL;%>
				<%
					List<admin> listad = (List) request.getAttribute("listadmin");
					String updateURL;
					for (int i = 0; i < listad.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listad.get(i).getUsername() + "</td>");
						out.print("<td>" + listad.get(i).getPassword() + "</td>");
						updateURL = request.getContextPath() + "/admin?page=adminupd" + "&username="
								+ listad.get(i).getUsername() + "&password=" + listad.get(i).getPassword();
						deleteURL = request.getContextPath() + "/admin?page=admindel" + "&username="
								+ listad.get(i).getUsername();
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
	
	<br/>
<br/>
<a href="${pageContext.request.contextPath}/admin?page=menu">
    <button style="float: center; width:50%; height:auto; padding:3px" class="btn btn-outline-dark btn-lg">Go to Menu</button>
</a>
<br/>
<br/>
</div>
<br/>
<br/>
<br/>

<%@include file="include/footer.jsp"%>