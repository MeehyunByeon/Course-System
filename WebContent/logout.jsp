<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOut Result</title>
</head>
<body>
<h2>LogOut Result</h2><br>
	<%String sessionId = (String)request.getSession().getAttribute("sessionId"); %>
	<h2>ID - ${sessionId } : LogOut Success</h2><br>
	
	<%session.invalidate();%>
	
	<hr>
	<a href="yongInLMS.jsp">HOME</a>
</body>
</html>