<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>page 영역과 request 영역의 비교</h3>
	
	현재 page 영역에 저장된 데이터 : <%= pageContext.getAttribute("pageScope") %> <br>
	
	현재 request 영역에 저장된 데이터 : <%= request.getAttribute("requestScope") %> <br>
</body>
</html>