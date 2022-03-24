<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러가 발생했습니다. 관리자에게 문의해 주세요.</h1>
	<%= exception %><br>
	<%= exception.getMessage() %><br>
	<%= exception.getClass().getName() %><br>
</body>
</html>