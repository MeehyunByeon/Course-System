<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>All Subject List</h2><br>
	<% 
		ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
		if(!list.isEmpty()) { %>
			<table border="1">
				<tr><th>ID</th><th>PASSWORD</th><th>NAME</th>
				
				<% for(int i = 0; i < list.size(); i++){
					MemberVO member = list.get(i);	%>
					
					<tr><td><%=member.getId() %></td>
						<td><%=member.getPwd() %></td>
						<td><%=member.getName() %></td>
					</tr>
				<%	}
			}else {
				out.print("<h3>No Subjects!!!</h3>");
			}
		%>
			</table>
			
	<%@ include file="homeS.jsp" %>
</body>
</html>