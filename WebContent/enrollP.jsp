<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Enroll</h1>
	<form action="enroll.do" method="post">
		ID : <input type="text" name="id" /> <br>
		Title : <input type="text" name="name" /> <br>
		# of student : <input type="text" name="count" /> <br>
		<input type="hidden" name="job" value="prof">
		<input type="submit" value="Enroll">
	</form>
</body>
</html>