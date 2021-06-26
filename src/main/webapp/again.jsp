<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="org.jss.entity.*" %>
<c:import url="include/header.jsp"><c:param name="title" value="wrong admin"/></c:import>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wrong</title>
</head>
<body>
<div style="padding: 20px">
<br/>
<br/>
<br/>
<br/>
			<br/>
			<br/>
			<br/>
<h1 style="color: solid red">Wrong username/u_id or password</h1>

<br/>
<img src="assets/img/11.jpg" alt="" style="float:right;width:360px;height:360px;padding:10px">
<br/>
			<a style="color=red;">U have entered a wrong username/u_id or password</a>
			<br/>
			<a><b>Please go back and re-enter!!!</b>></a>
			<br/>
			<br/>
			<br/>
			<br/>
</div>			
</body>
</html>
<%@include file="include/footer.jsp" %>