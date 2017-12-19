<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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

<h3>c:redirect 태그</h3>
<p> 
특정 페이지로 다시 요청하라고 클라이언트에게 응답하는 태그이다.<br>
<%-- 
<c:redirect url="요청 URL"/>
 --%>
</p>

<%-- 오류가 발생했을 때 오류 내용을 출력하기 위해
     error.jsp로 리다이렉트 하는것 보다,
     포워드 하는 것이 더 바람직 하다. --%>
<c:if test="${empty param.name}">
    <jsp:forward page="error.jsp"/>
</c:if>

${param.name}님 환영합니다.
 
</body>
</html>
 
