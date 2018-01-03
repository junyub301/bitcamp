<%@page import="java.io.PrintWriter"%>
<%@page import="java100.app.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page = "../header.jsp"/>

<h1>회원목록</h1>

<div class="toolbar">
<form action="list" method="get" class="searchbox">
<input type="text" name="word">
<button>검색</button>
</form>
<a href='form' class='btn btn-primary btn-sm'>추가</a>
</div>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>이름</th><th>이메일</th><th>등록일</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="member">
      <tr>
        <td>${member.no}</td>
        <td><a href='${member.no}'>${member.name}</a></td>
        <td>${member.email}</td>
        <td>${member.createdDate}</td>
      </tr> 
</c:forEach>
</tbody>
</table>

<jsp:include page = "../footer.jsp"/>

</div>
<jsp:include page = "../jslib.jsp"/>
</body>
</html>
    