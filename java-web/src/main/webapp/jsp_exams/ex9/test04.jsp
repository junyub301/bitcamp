<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>JSP 예제</title>
<link rel='stylesheet' href='../common.css'>
</head>
<body>
<h1>JSTL(JSP Standard Tag Library) 사용법</h1>
특정 자바 코드를 생성하는 태그이다.<br>


<h2>Core 라이브러리</h2>

<h3>c:set 태그</h3>
<p>
보관소에 저장된 객체의 값을 변경할 수 있다.<br>
&lt;c:set target="객체주소" 
          var="변수명" 
          value="값" 
          scope="page|request|session|application"/><br>
&lt;c:set var="변수명" scope="page|request|session|application">값&lt;/c:set><br>
</p>

<jsp:useBean id="member" class="domain.Member" scope="request"/>
이름: ${requestScope.member.name}<br>
나이: ${requestScope.member.age}<br>
재직: ${requestScope.member.working}<br>
<hr>

<c:set target="${member}" property="name" value="홍길동"/>
<c:set target="${member}" property="age" value="20"/>
<c:set target="${member}" property="working" value="true"/>

이름: ${requestScope.member.name}<br>
나이: ${requestScope.member.age}<br>
재직: ${requestScope.member.working}<br>
<hr>
</body>
</html>
 
