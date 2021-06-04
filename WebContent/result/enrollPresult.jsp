<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>enrollP.jsp</title>
</head>
<body>
	<h2>Enroll SUCCESS</h2><br>
	<h3>Professor ID : ${profId }</h3><br> 
	<h3>Subject ID : ${sid }</h3><br> 
	<h3>TITLE : ${name }</h3><br>
	<h3>Number of Student : ${count }</h3>
	
	<p></p>
	<%@ include file="/homeP.jsp" %>
</body>
</html>