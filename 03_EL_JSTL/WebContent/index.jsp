<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL/JSTL</h2>
	
	<h3>1. EL(Expression Language)</h3>
	<p>
		EL은 &lt;%= value %&gt;, out.print(value)와 같이 JSP 화면에 표현하고자 하는 코드를 <br>
		\${ value }의 형식으로 표현하여 작성하는 것을 EL이라 한다.
	</p>
	
	<h4>1) EL</h4>
	
	<a href="el.do">View Details</a>
	
	<h4>2) EL(Param)</h4>
	
	<form action="${ pageContext.request.contextPath }/views/el/elParam.jsp" method="post">
		<fieldset>
			<legend>제품 입력</legend>
			<input type="text" name="pName" placeholder="제품명을 입력하세요."><br>
			<input type="number" name="pCount" placeholder="수량을 입력하세요."><br>
			<input type="text" name="option" placeholder="옵션 1"><br>
			<input type="text" name="option" placeholder="옵션 2"><br><br>
			<input type="submit" value="전송">
		</fieldset>
	</form>
	
	<h4>3) EL(연산자)</h4>
	
	<a href="${ pageContext.request.contextPath }/views/el/elOperation.jsp">View Details</a>
	
	<h3>2. JSP Action Tag</h3>
	<p>
		JSP 페이지에서 자바 코드 등의 스크립트 언어를 사용하지 않고 <br>
		HTML 태그 형태로 다른 페이지나 객체에 접근할 수 있도록 태그를 이용해 구혀한 기능을 말한다.
	</p>
	
	<h4>1) 표준 액션 태그 (Standard Action Tag)</h4>
	<p>
		JSP 페이지에서 바로 사용 가능하고 태그 앞에 jsp: 접두어가 붙는다.
	</p>
	
	<a href="${ pageContext.request.contextPath }/views/actiontag/standard/include.jsp">jsp:include</a>
	
	<br>
	
	<a href="${ pageContext.request.contextPath }/views/actiontag/standard/forward.jsp">jsp:forward</a>
	
	<h4>2) 커스텀 액션 태그(Custom Action Tag)</h4>
	<p>
		개발자가 직접 만들어서 사용하는 액션 태그로 라이브러리 형태로 설치해야만 사용이 가능하다. <br>
		커스텀 액션 태그는 모든 태그의 이름 앞에 jsp: 이외의 접두어가 붙는다.
	</p>
	
	<h4>3) JSTL (JSP Standard Tag Library)</h4>
	<p>
		JSP에서 사용하는 커스텀 태그로 <br>
		공통으로 사용하는 코드의 집합을 사용하기 쉽게 태그화하여 표준으로 제공되는 액션 태그를 말한다.
	</p>
	
	<h5>3-1) JSTL Core Library</h5>
	<p>
		변수와 URL, 조건문, 반복문 등의 로직과 관련된 액션 태그를 제공한다.
	</p>
	
	<a href="${ pageContext.request.contextPath }/views/actiontag/jstl/core.jsp">JSTL Core</a>
	
	<h5>3-2) JSTL Formatting Library</h5>
	<p>
		날짜, 시간, 숫자 데이터의 출력 형식을 지정할 때 사용하는 태그를 제공한다.
	</p>
	
	<a href="${ pageContext.request.contextPath }/views/actiontag/jstl/fmt.jsp">JSTL Formatting</a>
	
	<h5>3-3) JSTL Functions Library</h5>
	<p>
		문자열 처리에 관련된 메소드들을 EL 형식에서 사용할 수 있게 하는 라이브러리이다.
	</p>
	
	<a href="${ pageContext.request.contextPath }/views/actiontag/jstl/functions.jsp">JSTL Functions</a>
	
	
	
	
	
	
	
	
	
	
	
	
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	
</body>
</html>