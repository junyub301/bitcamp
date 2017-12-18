<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>JSP 예제</title>
<link rel='stylesheet' href='../common.css'>
</head>
<body>
<h1>EL(Expression Language) 사용법</h1>
OGNL 표기법을 이용하여 자바 객체의 프로퍼티 값을 꺼내는 문법이다.<br>
OGNL(Object Graph Navigation Language) 이란?<br>
점(.)이나 대괄호([]) 등을 이용하여 객체의 변수 값을 쉽게 꺼내게 해주는 문법이다.<br>


<%
java.util.ArrayList<String> names = new java.util.ArrayList<>();
names.add("홍길동");
names.add("임꺽정");
names.add("유관순");
pageContext.setAttribute("name", names);
%>
<h2>List</h2>
name[0] : ${name[0]}<br>
name[1] : ${name[1]}<br>
name[2] : ${name[2]}<br>
name[3] : ${name[3]}<br>


</body>
</html>

