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
			<strong>Listing books</strong>
			<hr />
			<table class="table table-striped table-dark">
				<thead>
				<tr>
					<th scope="col">Book ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author</th>
					<th scope="col">Publisher</th>
					<th scope="col">Copies</th>
					<th scope="col">Category</th></tr>
				</thead>
				<tbody>
				<%!String deleteURL;%>
				<%
					List<book> listbook = (List) request.getAttribute("listbooks");
					String updateURL;
					for (int i = 0; i < listbook.size(); i++) {
						out.print("<tr>");
						out.print("<td scope=\"row\">" + listbook.get(i).getBook_id() + "</td>");
						out.print("<td>" + listbook.get(i).getTitle() + "</td>");
						out.print("<td>" + listbook.get(i).getAuthor() + "</td>");
						out.print("<td>" + listbook.get(i).getPublish() + "</td>");
						out.print("<td>" + listbook.get(i).getCopies() + "</td>");
						out.print("<td>" + listbook.get(i).getCategory() + "</td>");
						updateURL = request.getContextPath() + "/operation?page=booku" + "&book_id="
								+ listbook.get(i).getBook_id() + "&title=" + listbook.get(i).getTitle() + "&author="
								+ listbook.get(i).getAuthor() + "&publish=" + listbook.get(i).getPublish() +"&copies=" + listbook.get(i).getCopies() + "&category=" + listbook.get(i).getCategory();
						deleteURL = request.getContextPath() + "/operation?page=bookd" + "&book_id="
								+ listbook.get(i).getBook_id();
						out.print("<td><a class=\"btn btn-outline-danger\" href=" + updateURL + "> Update </a>   |  ");
				%>
				<a class="btn btn-outline-danger" href="<%=deleteURL%>"
					onclick="if(!confirm('Are you sure to delete the user?')) return false"> Delete </a>
				</td>
				</tr>
				<%
					}
				%>
				</tbody>
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