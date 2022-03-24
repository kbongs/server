<%@page import="java.util.Date"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 내장 객체</h2>
	
	<h3>request 객체</h3>
	
	<h4>헤더와 관련된 메소드</h4>
	
	<table border="1">
		<tr>
			<th>헤더 이름</th>
			<th>헤더 값</th>
		</tr>
		
	<% 
		Enumeration<String> headerNames = request.getHeaderNames();
		
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
	%>
		<tr>
			<td><%= headerName %></td>
			<td><%= request.getHeader(headerName) %></td>
		</tr>
	<%
			// System.out.println(headerName + " : " + request.getHeader(headerName));
		}
	%>
	</table>
	
	<h4>URL / URI, 요청 방식과 관련된 메소드</h4>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>값</th>
		</tr>
		<tr>
			<td>서버 도메인명</td>
			<td><%= request.getServerName() %></td>
		</tr>
		<tr>
			<td>서버 포트 번호</td>
			<td><%= request.getServerPort() %></td>
		</tr>
		<tr>
			<td>서버 URL</td>
			<td><%= request.getRequestURL() %></td>
		</tr>
		<tr>
			<td>서버 URI</td>
			<td><%= request.getRequestURI() %></td>
		</tr>
		<tr>
			<td>요청 쿼리</td>
			<td><%= request.getQueryString() %></td>
		</tr>
		<tr>
			<td>클라이언트의 IP 주소</td>
			<td><%= request.getRemoteAddr() %></td>
		</tr>
		<tr>
			<td>프로토콜</td>
			<td><%= request.getProtocol() %></td>
		</tr>
		<tr>
			<td>요청방식</td>
			<td><%= request.getMethod() %></td>
		</tr>
		<tr>
			<td>웹 애플리케이션 경로</td>
			<td><%= request.getContextPath() %></td>
		</tr>
	</table>
	
	<h3>response 객체</h3>
	<p>
		sendRedirect(String url) <br>
		지정한 URL로 요청을 재전송한다. (브라우저에 표시되는 URL이 변경된다.) <br>
		브라우저에 표시되는 주소가 바뀌는 방식을 리다이렉트 방식이라고 한다. <br>
		리다이렉트 방식은 이동할 페이지로 요청과 응답 객체를 새로 생성하여 전송하므로 이전 요청과 응답 정보가 유지되지 않는다.
	</p>
	
	<a href="redirect.jsp">redirect 테스트</a>	
	
	<h3>pageContext 객체</h3>
	<p>
		forward(String url) <br>
		지정한 URL로 현재 페이지의 요청과 응답에 관한 제어권을 영구적으로 넘긴다.<br>
		브라우저에 표시되는 주소가 바뀌지 않는 방식을 포워딩 방식이라고 한다.<br>
		포워딩 방식은 현재 페이지의 요청과 응답의 정보에 대한 제어권만 다른 페이지로 넘어가므로 요청 정보와 응답 정보가 유지된다.
	</p>
	
	<a href="forward.jsp">forward 테스트</a>
	
	<h3>session 객체</h3>
	
	isNew() : <%= session.isNew() %> <br>
	생성 시간 : <%= new Date(session.getCreationTime()) %> <br>
	최종 접속 시간 : <%= new Date(session.getLastAccessedTime()) %> <br>
	세션 ID : <%= session.getId() %>
	
	<h3>application 객체</h3>
	<table border="1">
		<tr>
			<td>JSP 버전</td>
			<td><%= application.getMajorVersion() %>.<%= application.getMinorVersion() %></td>
		</tr>
		<tr>
			<td>컨테이너 정보</td>
			<td><%= application.getServerInfo() %></td>
		</tr>
		<tr>
			<td>웹 애플리케이션의 실제 파일시스템 경로</td>
			<td><%= application.getRealPath("/") %></td>
		</tr>
	</table>
	
	<h3>config 객체</h3>
	
	<table border="1">
		<tr>
			<th>초기 파라미터 이름</th>
			<th>초기 파라미터 값</th>
		</tr>
	<%
		Enumeration<String> initParamNames = config.getInitParameterNames();
		
		while(initParamNames.hasMoreElements()) {
			String initParamName = initParamNames.nextElement();
	%>		
		<tr>
			<td><%= initParamName %></td>
			<td><%= config.getInitParameter(initParamName) %></td>
		</tr>
	<%		
		}
	%>
		
	</table>
	
	
	
	
	
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	
</body>
</html>