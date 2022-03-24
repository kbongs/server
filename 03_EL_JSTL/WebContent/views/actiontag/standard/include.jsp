<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp:include 액션 태그</h2>
	<p>
		현재 JSP 페이지에 다른 페이지를 포함하고자 할 때 쓰이는 액션 태그이다.
	</p>
	
	<h3>1) include 지시어 (정적 include 방식)</h3>
	<p>
		다른 페이지를 포함하는 JSP 파일이 컴파일 되기 전에 페이지 삽입된다.
	</p>
	<%-- 
	<%@ include file="includePage.jsp" %>
	
	<!-- include 한 페이지에서 scriptlet으로 선언된 변수를 그대로 사용할 수 있다. -->
	include 한 페이지의 year 변수값 <%= year %> <br><br>
	
	<!-- 현재 페이지와 include 한 페이지의 변수명이 중복되면 Duplicate Local Variable이 발생한다. -->
	<%
		String year = "2022";
	%>
	--%>
	
	<h3>2) include 액션 태그 (동적 include 방식)</h3>
	<p>
		다른 페이지를 포함하는 JSP 파일이 화면에 출력되는 시점(런타임)에 삽입된다.
	</p>
	
	<jsp:include page="includePage.jsp" />
	
	
	<%
		// 중복되는 변수명으로 선언해도 에러가 발생하지 않는다.
		String year = "2022";
	%>
	
	 include.jsp의 year 변수값 <%= year %> <br><br>
	
	<!-- jsp:param 액션 태그를 이용해서 포함되는 페이지로 값을 전달할 수 있다. -->
	<jsp:include page="includePage.jsp">
		<jsp:param name="pName" value="아이폰 12 미니"/>
	</jsp:include>
</body>
</html>