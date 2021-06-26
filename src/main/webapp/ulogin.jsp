<%@include file="include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
<h1>Login</h1>

<form action="${pageContext.request.contextPath}/usercon" method="post">
<br/>
<br/>
			<table>
				<tr>
					<td>UserID </td>
					<td><input type="text" class="form-control" name="u_id" required="required" /></td>
				</tr>

					<tr>
					<td>Password </td>
					<td><input type="password" class="form-control" name="password" required="required"/></td>
				</tr>

			</table>
			<input type="hidden" name="form" value="userlogin">
			<button type="submit" class="btn btn-outline-danger">Submit</button></form>
			<br/>
			<br/>
			<br/>
			<br/>
			</div>
		<div class="col-md-6 col-xs-6">
<br/>
<img src="assets/img/9.jpg" alt="" style="float:right;height:300px;padding:10px" class="responsive">
<br/>
<br/>
</div></div>	
</div>
</body>
</html>
<%@include file="include/footer.jsp" %>