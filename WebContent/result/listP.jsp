<%@page import="java.util.ArrayList"%>
<%@page import="lms.vo.SSubject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Professor Enroll List</title>
</head>
<body>
<h2>Professor ${profId} 's Enroll List</h2>
	<% 
		ArrayList<SSubject> listP = (ArrayList<SSubject>) request.getAttribute("listP");
		if(!listP.isEmpty()) { %>
			<table border="1">
			<form action="cancleP.do" method="put">
				<tr><th>Subject ID</th><th>Title</th><th>MAX</th><th>Cancle</th>
				<% for(int i = 0; i < listP.size(); i++){
					SSubject sub = listP.get(i);	%>
					<tr><td><%=sub.getId() %></td>
						<td><%=sub.getName() %></td>
						<td><%=sub.getCount() %></td>
						<td><input type="submit" value="<%=sub.getId() %>"name="subject" /></td>
					</tr>
				<%	}
			}else out.print("<h3>No subject!!!</h3>");
		%></form>
			</table>
			
	<hr><br>
	<h2>Enroll List CURRENT</h2>
	<h3>click -> class member detail</h3>
	<% 
		ArrayList<SSubject> listCP = (ArrayList<SSubject>) request.getAttribute("listCP");
		if(!listCP.isEmpty()) { %>
			<table border="1">
				<tr><th>Subject ID</th><th>Title</th><th>MAX</th><th>Current</th>
				<form action="detailP.do" method="put">
				<% for(int i = 0; i < listCP.size(); i++){
					SSubject sub = listCP.get(i);	%>
					
					<tr><td><input type="submit" name="subject" value="<%=sub.getId()%>"></td>
						<td><%=sub.getName() %></td>
						<td><%=sub.getCount() %></td>
						<td><%=sub.getNumber() %></td>
					</tr>
				<%	}
			}else out.print("<h3>Not Exist!!!</h3>");
		%>	</form>
			</table>
	<hr><br>
	<%@ include file="/homeP.jsp" %>
</body>
</html>