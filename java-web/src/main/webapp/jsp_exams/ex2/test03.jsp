<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html >
<html>
<head>
<% int a = 10;  %>
<meta charset="UTF-8">
<title>JSP 예제</title>
<link rel='stylesheet' href='../common.css'>
</head>
<% int b = 20; %>
<body>
<h1>스크립트릿 테스트2</h1>
<%
out.println(a + b);
%>
<p>스크립트릿이 선언된 그 위치, 그 순서 그대로 자바 소스 파일에 복사된다.</p> 
</body>
</html>
<%
class MyInner {} //ㅋㅋ
%>