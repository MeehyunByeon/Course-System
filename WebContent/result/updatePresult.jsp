<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Class Result</title>
</head>
<body>
<h2>Update Success</h2><br><br>
	<h3>Professor : ${sub.prof }</h3><br><br>
	<h3>Subject ID : ${sub.id }</h3><br><br>
	<h3>TITLE : ${sub.name }</h3><br><br>
	<h3>MAX : ${sub.count }</h3><br><br>
	<%@ include file="/homeP.jsp" %>
</body>
</html>