<%@page import="java.util.ArrayList"%>
<%@page import="lms.vo.SSubject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Professor ${profId} 's Enroll List</h2>
	<% 
		ArrayList<SSubject> listP = (ArrayList<SSubject>) request.getAttribute("listP");
		if(!listP.isEmpty()) { %>
			<table border="1">
				<tr><th>Subject ID</th><th>Title</th><th>MAX</th><th>Current</th>
				<form action="detailP.do" method="put">
				<% for(int i = 0; i < listP.size(); i++){
					SSubject sub = listP.get(i);	%>
					
					<tr><td><input type="submit" name="subject" value="<%=sub.getId()%>"></td>
						<td><%=sub.getName() %></td>
						<td><%=sub.getCount() %></td>
						<td><%=sub.getNumber() %></td>
					</tr>
				<%	}
			}else {
				out.print("<h3>No subject!!!</h3>");
			}
		%>	</form>
			</table>
			
	<hr><br>
	<%@ include file="/result/homeP.jsp" %>
</body>
</html>