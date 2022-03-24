<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>application 영역과 session 영역의 비교</h3>
	현재 application 영역에 저장된 데이터 : <%= application.getAttribute("userName") %> <br>
	
	현재 session 영역에 저장된 데이터 : <%= session.getAttribute("address") %> <br>
</body>
</html>