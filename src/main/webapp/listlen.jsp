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
					<th>Book ID</th>
					<th>UserID</th>
					<th>Date if Issue</th>
					<th>Due Date</th>
				</thead>
				<%!String deleteURL;%>
				<%
					List<lending> listlen = (List) request.getAttribute("listlen");
					String updateURL;
					for (int i = 0; i < listlen.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listlen.get(i).getB_id() + "</td>");
						out.print("<td>" + listlen.get(i).getUs_id() + "</td>");
						out.print("<td>" + listlen.get(i).getDay_out() + "</td>");
						out.print("<td>" + listlen.get(i).getDue_date() + "</td>");
						updateURL = request.getContextPath() + "/operation?page=issueu" + "&b_id="
								+ listlen.get(i).getB_id() + "&us_id=" + listlen.get(i).getUs_id() + "&day_out="
								+ listlen.get(i).getDay_out() + "&due_date=" + listlen.get(i).getDue_date();
						deleteURL = request.getContextPath() + "/operation?page=issued" + "&b_id="
								+ listlen.get(i).getB_id() + "&us_id=" + listlen.get(i).getUs_id();
						out.print("<td><a class=\"btn btn-outline-danger\" href=" + updateURL + "> Update </a> |");
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