<%@page import="lms.vo.SSubject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enroll Class</title>
</head>
<body>
	<h2>Enroll Class</h2><br><br>
	<form action="searchS.do" method="put">
	<h2>INPUT the Subject ID(Number)</h2><br>
		Subject ID : <input type="text" name="subject" /> <br><br>
		<input type="submit" value="SEARCH" /><br><br>
	</form>
	
	<% 
		SSubject subject = (SSubject)request.getAttribute("subject");
		String msg = (String)request.getAttribute("msg");
		if(subject != null && msg == null){
	%>
		<form action="enrollS.do" method="put">
			Subject ID : <input type="text" readonly name="eid" value="${subject.id }"/> <br><br>
			TITLE : <input type="text" readonly name="ename" value="${subject.name }"/> <br><br>
			MAX : <input type="text" readonly name="ecount" value="${subject.count }"/> <br><br>
			Professor : <input type="text" readonly name="eprof" value="${subject.prof }"/> <br><br>
			<input type="submit" value="Enrolment" /><br><br>
			
		</form>
	
	<%} else{ %>
		${msg}<br><br>
	<%} %>
	
	<%@ include file="homeS.jsp" %>
</body>
</html>