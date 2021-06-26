<%@include file="include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add book</title>
</head>
<body>
<br/>
<br/>
<br/>
<br/>
<div style="padding: 20px" class="container mtb">
<div class="row">
<br/>
<br/>
<br/>
<div class="col-md-6 col-xs-6">
<h1>Add Book</h1>
<form action="${pageContext.request.contextPath}/operation" method="post">
<br/>
<br/>
			<table>
				<tr>
					<td>BookID </td>
					<td><input type="text" class="form-control" name="book_id" required="required" /></td>
				</tr>

				<tr>
					<td>Title </td>
					<td><input type="text" class="form-control" name="title" required="required" /></td>
				</tr>

				<tr>
					<td>Author </td>
					<td><input type="text" class="form-control" name="author" required="required" /></td>
				</tr>

				<tr>
					<td>Publisher </td>
					<td><input type="text" class="form-control" name="publish" required="required" /></td>
				</tr>

				<tr>
					<td>Copies </td>
					<td><input type="number" class="form-control" name="copies" required="required" /></td>
				</tr>

					<tr>
					<td>Category </td>
					<td><select id="category" class="form-control"  name="category">
                    <option value="Programming language">Programming language</option>
                    <option value="Web related">Web related</option>
                    <option value="Data structures">Data structures</option>
                    <option value="General" selected>General</option>
                    </select></td>
				</tr>

			</table>
			<input type="hidden" name="form" value="addbook">
			<button type="submit" class="btn btn-outline-danger">Submit</button></form>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
</div>
<div class="col-md-6 col-xs-6">
<br/>
<br/>
<img src="assets/img/7.jpg" alt="" style="float:right;height:500px;padding:10px" class="responsive">
<br/>
<br/>
</div>
</div>			
</div>			
</body>
</html>
<%@include file="include/footer.jsp" %>