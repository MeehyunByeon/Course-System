<%@page import="lms.vo.Enroll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Student Enroll Result</h3><br><br>
	
	<h2>Enroll SUCCESS</h2><br>
	<h3>Student ID : ${studid }</h3><br><br>
	<h3>Subject ID : ${eid }</h3><br><br>
	<h3>TITLE : ${ename }</h3><br><br>

	<p></p>
	<%@ include file="/result/homeS.jsp" %>
</body>
</html>