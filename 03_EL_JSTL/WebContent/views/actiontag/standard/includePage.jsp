<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String year = "2021";
	// String pName = request.getParameter("pName");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Include Page</h2>
	
	Include Page의 year 변수값 <%= year %><br><br>
	
	pName : ${ param.pName }
</body>
</html>