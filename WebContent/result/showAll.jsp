<%@page import="lms.vo.SSubject"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>All Class List</h2><br>
	<% 
		ArrayList<SSubject> all = (ArrayList<SSubject>) request.getAttribute("all");
		if(!all.isEmpty()) { %>
			<table border="1">
				<tr><th>Subject ID</th><th>Title</th><th>Professor</th><th>Max</th>
				
				<% for(int i = 0; i < all.size(); i++){
					SSubject sub = all.get(i);	%>
					
					<tr><td><%=sub.getId() %></td>
						<td><%=sub.getName() %></td>
						<td><%=sub.getProf() %></td>
						<td><%=sub.getCount() %></td>
					</tr>
				<%	}
			}else {
				out.print("<h3>No Class!!!</h3>");
			}
		%>
			</table>
			<hr><br>
			
		<h2>CURRENT</h2><br>
		<% 
		ArrayList<SSubject> detail = (ArrayList<SSubject>) request.getAttribute("detail");
		if(!detail.isEmpty()) { %>
			<table border="1">
				<tr><th>Subject ID</th><th>Title</th><th>Professor</th><th>Max</th><th>Current</th>
				
				<% for(int i = 0; i < detail.size(); i++){
					SSubject sub = detail.get(i);	%>
					
					<tr><td><%=sub.getId() %></td>
						<td><%=sub.getName() %></td>
						<td><%=sub.getProf() %></td>
						<td><%=sub.getCount() %></td>
						<td><%=sub.getCurrent() %></td>
					</tr>
				<%	}
			}else {
				out.print("<h3>No Class!!!</h3>");
			}
		%>
			</table>
			<hr><br>
			
		<% String who = (String)request.getAttribute("session");
			if(who.length() > 1){ %>
				<a href="studMenu.jsp">MENU</a>
		<% } else{%>
			<a href="profMenu.jsp">MENU</a>
		<%}%>
</body>
</html>