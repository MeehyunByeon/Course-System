<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h1>YongIn Course System</h1>
	<h2>LogIn</h2><br>
	<form action="login.do" method="post">
		I 	   D : <input type="text" name="id" /> <br><br>
		PASSWORD : <input type="password" name="pwd" /> <br>
	<hr>
	<input type="radio" name="job" value="prof" checked="checked">
	<label for="prof">Professor</label>
	<input type="radio" name="job" value="student">
	<label for="stud">Student</label><br><br>
	<input type="submit" value="Login">
</form>
</body>
</html>