<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>LogOut Result</h2><br>
	<h2>ID - ${id } : LogOut Success</h2><br>
	<%
		session.invalidate();
	%>
	<p>
	<%@ include file="yongInLMS.jsp" %>
</body>
</html>