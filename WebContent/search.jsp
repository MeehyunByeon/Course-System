<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="search.do" method="put">
	<h2>교과목 번호 입력/조회</h2>
		Subject ID : <input type="text" name="subject" /> <br>
		<input type="submit" value="SEARCH" />
	</form>
	
	<% 
		String result = (String)request.getAttribute("result");
		if(result != null && result.equals("true")){
	%>
		<form action=".do" method="post">
			Subject : <input type="text" readonly name="subject" value="${subject }"/> <br>
			<input type="submit" value="Enrolment" />
		</form>
	
	<%} else if(result != null && result.equals("false")){ 
			out.print("No Subject");
	}
	%>
	
	<%@ include file="homeS.jsp" %>
</body>
</html>