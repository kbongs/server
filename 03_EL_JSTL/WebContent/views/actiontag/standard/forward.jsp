<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp:forward 액션 태그</h2>
	<p>
		현재 페이지의 요청과 응답에 대한 처리권을 다른 페이지로 넘기는 액션 태그이다.
	</p>
	
	<!-- 포워딩 전에 응답 객체 쓴 내용은 forwarding 되면서 버퍼가 지워져서 아무런 효과가 없다.-->
	<script>alert('안녕하세요.');</script>
	
	<jsp:forward page="forwardPage.jsp" />
	
	<%-- 
	<jsp:forward page="forwardPage.jsp"></jsp:forward>	
	--%>
</body>
</html>