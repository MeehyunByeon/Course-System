<%@page import="lms.vo.Enroll"%>
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
<h2>Professor ${profId} 's Enroll List_DETAIL<br><br>

<h3>subject_${subject}'s Total Member : ${detailP.size()}</h3><br><br>
	<% 
		ArrayList<Enroll> detailP = (ArrayList<Enroll>) request.getAttribute("detailP");
		if(!detailP.isEmpty()) { %>
			<table border="1">
				<tr><th>Student ID</th><th>Name</th>
				
				<% for(int i = 0; i < detailP.size(); i++){
					Enroll en = detailP.get(i);	%>
					<tr><td><%=en.getStudent() %></td>
						<td><%=en.getName() %></td>
					</tr>
				<%	}
			}else {
				out.print("<h3>No Student!!!</h3>");
			}
		%>
			</table>
			
	<hr><br>
	<%@ include file="/result/homeP.jsp" %>
</body>
</html>