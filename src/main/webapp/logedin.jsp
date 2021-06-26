<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="org.jss.entity.*" %>
<c:import url="include/header.jsp"><c:param name="title" value="Logged admin"/></c:import>
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
		<div class="col-lg-6">	
	<h1><b>Successfully logged in!!!!</b></h1>	
		<br/>
  <br/>	
		</div>
	</div>
</div>

<div style="padding: 50px;" class="container mtb">
<h1>Choose your operation</h1>
<br/>
<br/>

<div class="row">

<br/>
<div class="col-md-6 col-xs-6">
<a href="${pageContext.request.contextPath}/admin?page=adminrud">
    <button style="float: center; width:50% ; height:auto; padding:3px" class="btn btn-outline-dark btn-lg">Update / Delete your information</button>
</a>
<br/>
<br/>
<br/>
<a href="${pageContext.request.contextPath}/operation?page=bookin">
    <button style="float: center; width:50%; height:auto; padding:3px" class="btn btn-outline-dark btn-lg">Insert Book Information</button>
</a>
<br/>
<br/>
<br/>

<a href="${pageContext.request.contextPath}/operation?page=bookrud">
    <button style="float: center; width:50%; height:auto; padding:3px" class="btn btn-outline-dark btn-lg">Read / Update / Delete Book Information</button>
</a>
<br/>
<br/>
<br/>
<a href="${pageContext.request.contextPath}/operation?page=issue">
    <button style="float: center; width:50%; height:auto; padding:3px" class="btn btn-outline-dark btn-lg">Insert Borrowing Information</button>
</a>
<br/>
<br/>
<br/>
<a href="${pageContext.request.contextPath}/operation?page=issuerud">
    <button style="float: center; width:50%; height:auto; padding:3px" class="btn btn-outline-dark btn-lg">Read / Update / Delete Borrowing Information</button>
</a>
<br/>
<br/>
<br/>
</div>
<br/>
<div class="col-md-6 col-xs-6">
			<img src="assets/img/9.jpg" alt="" style="float:right;height:300px;padding:10px" class="responsive">
			<br/>
            <br/>
			<img src="assets/img/2.jpg" alt="" style="float:right;height:300px;padding:10px" class="responsive">
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