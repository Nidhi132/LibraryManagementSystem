<%@include file="include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update borrow info</title>
</head>
<body>
<br/>
<br/>
<br/>
<br/>
<div style="padding: 20px" class="container mtb">
<div class="row">

<br/>
<div class="col-md-6 col-xs-6">
<h1>Update borrow info</h1>
<form action="${pageContext.request.contextPath}/operation" method="post">
<br/>
<br/>
			<table>
				<tr>
					<td>BookID </td>
					<td><input type="number" class="form-control" name="b_id" value="${param.b_id }" readonly /></td>
				</tr>

				<tr>
					<td>UserID </td>
					<td><input type="text" class="form-control" name="us_id" value="${param.us_id }"   required="required" /></td>
				</tr>

				<tr>
					<td>Date of Issuing </td>
					<td><input type="date" class="form-control" name="day_out" value="${param.date_out }"  required="required" /></td>
				</tr>

				<tr>
					<td>Due-Date </td>
					<td><input type="date" class="form-control" name="due_date" value="${param.due_date }"   required="required" /></td>
				</tr>

			</table>
			<input type="hidden" name="form" value="update">
			<button type="submit" class="btn btn-outline-danger">Submit</button></form>
			<br/>
			<br/>
			<br/>
			<br/>
			</div>
			<div class="col-md-6 col-xs-6">
<br/>
<img src="assets/img/8.jpg" alt="" style="float:right;height:500px;padding:10px" class="responsive">
<br/>
</div></div>
</div>			
</body>
</html>
<%@include file="include/footer.jsp" %>