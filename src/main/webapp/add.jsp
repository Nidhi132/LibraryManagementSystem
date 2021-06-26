<%@include file="include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrow</title>
</head>
<body>
<br/>
<br/>
<br/>
<div style="padding: 20px" class="container mtb">
<div class="row">
<br/>
<br/>
<br/>
<div class="col-md-6 col-xs-6">
<h1>Issue books</h1>
<form action="${pageContext.request.contextPath}/operation" method="post">
<br/>
<br/>
			<table>
				<tr class="form-group">
					<td>BookID </td>
					<td><input type="number" class="form-control" name="b_id" required="required" /></td>
				</tr>

				<tr class="form-group">
					<td>UserID </td>
					<td><input type="text" class="form-control" name="us_id" required="required" /></td>
				</tr>

				<tr class="form-group">
					<td>Due-Date </td>
					<td><input type="date" class="form-control" name="due_date" placeholder="YYYY-MM-DD" required="required" /></td>
				</tr>

			</table>
			<input type="hidden" name="form" value="add">
			<button type="submit" class="btn btn-outline-danger">Submit</button></form>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
</div>
<div class="col-md-6 col-xs-6">
<br/>
<br/>
<img src="assets/img/6.jpg" alt="" style="float:right;height:500px;padding:10px" class="responsive">
<br/>
<br/>
</div>
</div>			
</div>
			
</body>
</html>
<%@include file="include/footer.jsp" %>