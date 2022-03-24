<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입</h2>
	
	<hr>
	
	<form action="enrollResult.jsp" method="POST">
		<label>아이디 : <input type="text" name="userId"></label> <br>
		<label>패스워드 : <input type="password" name="password"></label> <br>
		<label>이름 : <input type="text" name="userName"></label> <br>
		
		<br><br>
		
		<input type="submit" value="회원 가입">
	</form>
</body>
</html>