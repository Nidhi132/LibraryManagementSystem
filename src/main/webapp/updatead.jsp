<%@include file="include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update admin</title>
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
<br/>
<div class="col-md-6 col-xs-6">
<h1>Update admin</h1>
<form action="${pageContext.request.contextPath}/admin" method="post">
<br/>
<br/>
			<table>
				<tr>
					<td>UserName </td>
					<td><input type="text" class="form-control" name="username" value="${param.username }" readonly/></td>
				</tr>

					<tr>
					<td>Password </td>
					<td><input type="password" class="form-control" name="password" value="${param.password }" required="required"/></td>
				</tr>

			</table>
			<input type="hidden" name="form" value="adminup">
			<button type="submit" class="btn btn-outline-danger">Submit</button></form>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			</div>
			<div class="col-md-6 col-xs-6">
<br/>
<img src="assets/img/6.jpg" alt="" style="float:right;height:500px;padding:10px" class="responsive">
<br/>
<br/>
</div></div>
</div>			
</body>
</html>
<%@include file="include/footer.jsp" %>