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
					<th>Book ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Publisher</th>
					<th>Copies</th>
					<th>Category</th>
				</thead>
				<%
					List<book> listbook = (List) request.getAttribute("listbooks");
					String updateURL;
					for (int i = 0; i < listbook.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listbook.get(i).getBook_id() + "</td>");
						out.print("<td>" + listbook.get(i).getTitle() + "</td>");
						out.print("<td>" + listbook.get(i).getAuthor() + "</td>");
						out.print("<td>" + listbook.get(i).getPublish() + "</td>");
						out.print("<td>" + listbook.get(i).getCopies() + "</td>");
						out.print("<td>" + listbook.get(i).getCategory() + "</td>");}
				%>
			</table>
		</div>
	</div>
</div>
<br/>
<br/>
<br/>

<%@include file="include/footer.jsp"%>