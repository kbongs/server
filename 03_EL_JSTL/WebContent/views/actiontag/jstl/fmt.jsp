<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL Formatting Library</h2>
	
	톰켓 서버의 Locale 정보 : ${ pageContext.response.locale } <br>
	
	<%-- 
	<fmt:setLocale value="en_us"/>
	--%>
	
	setLocale 후 톰켓 서버의 Locale 정보 : ${ pageContext.response.locale } <br>
	
	<h3>1. formatNumber</h3>
	<p>
		숫자의 데이터 포맷을 지정할 때 사용하는 태그이다. <br>
		표현하고 하는 숫자의 형식을 통화 기호, % 등 원하는 형식으로 지정할 수 있다.
	</p>
	
	<!-- groupingUsed : 숫자 단위의 구분자(,) 표시 여부 지정 (default: true) -->
	숫자 그대로 출력 : <fmt:formatNumber value="123456789" groupingUsed="false"/> <br>
	숫자 그대로 출력 : <fmt:formatNumber value="123456789" groupingUsed="true"/> <br><br>
	
	<!-- 
		pattern : 화면에 표시할 데이터의 스타일을 지정한다. #, 0 기호를 사용하여 지정하고 초과된 부분은 반올림 된다. 
				  부족한 부분에 대해서는 #은 표시하지 않지만 0은 0으로 표시한다.
	-->
	#을 이용하여 출력 : <fmt:formatNumber value="1.23" pattern="#.###" /> <br>
	0을 이용하여 출력 : <fmt:formatNumber value="1.23" pattern="0.000" /> <br><br>
	
	<!-- type : number(일반 숫자, 기본값), percent(백분율), currency(통화) -->
	number : <fmt:formatNumber type="number" value="50000"/> <br>
	currency : <fmt:formatNumber type="currency" value="50000"/> <br>
	currency : <fmt:formatNumber type="currency" value="50000" currencySymbol="$"/> <br>
	percent : <fmt:formatNumber type="percent" value="0.75"/>
	
	<h3>2. formatDate</h3>
	<p>
		날짜와 시간의 데이터 포맷을 지정할 때 사용하는 태그이다. <br>
		value 속성에는 java.util.Date 객체를 사용해야 한다.
	</p>
	
	<c:set var="now" value="<%= new Date() %>"/>
	<fmt:formatDate value="${ now }"/> <!-- type 생략 가능 (기본값 : date) -->
	
	<ul>
		<li>날짜 : <fmt:formatDate type="date" value="${ now }"/></li>
		<li>시간 : <fmt:formatDate type="time" value="${ now }"/></li>
		<li>둘 다 : <fmt:formatDate type="both" value="${ now }"/></li>
		<li>[short] : <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${ now }"/></li>
		<li>[medium] : <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${ now }"/></li>
		<li>[long] : <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ now }"/></li>
		<li>[full] : <fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${ now }"/></li>
		<li>내 패턴 : <fmt:formatDate type="both" pattern="yyyy-MM-dd(E) HH:mm:ss(a)" value="${ now }"/> </li>
	</ul>	
		
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
</body>
</html>