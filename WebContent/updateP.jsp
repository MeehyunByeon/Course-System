<%@page import="lms.vo.SSubject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Class</title>
</head>
<body>

	<form action="searchP.do" method="put">
	<h2>INPUT the Subject ID(Number)</h2><br>
		Subject ID : <input type="text" name="subject" /> <br><br>
		<input type="submit" value="SEARCH" /><br><br>
	</form>
	
	<% 
		SSubject sub = (SSubject)request.getAttribute("sub");
		String msg = (String)request.getAttribute("msg");
		if(sub != null){
	%>
		<form action="updateP.do" method="put">
			Subject ID : <input type="text" readonly name="id" value="${sub.id }"/> <br><br>
			TITLE : <input type="text" name="upname" value="${sub.name }"/> <br><br>
			MAX : <input type="text" name="upcount" value="${sub.count }"/> <br><br>
			<input type="submit" value="UPDATE" /><br><br>
			
		</form><br><br>
	
	<%} else{ %>
		${msg}
	<%} %>
	
	<%@ include file="/homeP.jsp" %>
</body>
</html>