<%@page import="lms.vo.SSubject"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Enroll List</title>
</head>
<body>
<h2>Student ${studId} 's Enroll List</h2>
	<% 
		ArrayList<SSubject> listS = (ArrayList<SSubject>) request.getAttribute("listS");
		if(!listS.isEmpty()) { %>
			<table border="1">
			<form action="cancleS.do" method="put">
				<tr><th>Subject ID</th><th>Title</th><th>Professor</th><th>Cancle</th>
				
				<% for(int i = 0; i < listS.size(); i++){
					SSubject sub = listS.get(i);	%>
					
					<tr><td><%=sub.getId() %></td>
						<td><%=sub.getName() %></td>
						<td><%=sub.getProf() %></td>
						<td><input type="submit" value="<%=sub.getId() %>" name="subject"/></td>
					</tr>
				<%	}
			}else {
				out.print("<h3>No subject!!!</h3>");
			}
		%></form>
			</table>
			
	<hr><br>
	<%@ include file="/homeS.jsp" %>
</body>
</html>