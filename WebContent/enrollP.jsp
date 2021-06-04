<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Professor Enroll</h1>
	<form action="enrollP.do" method="put">
		ID : <input type="text" name="subId" /> <br><br>
		TITLE : <input type="text" name="subName" /> <br><br>
		# OF STUDENT : <input type="text" name="subCount" /> <br><br>
		<input type="submit" value="Enroll">
	</form>
	
	<%@ include file="/homeP.jsp" %>
</body>
</html>