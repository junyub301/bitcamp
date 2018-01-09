<%@page import="java.io.PrintWriter"%>
<%@page import="java100.app.domain.Book"%>
<%@page import="java.util.List"%>
<%@page import="java100.app.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html>
<html>
<head>
<title>게시물관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page = "../header.jsp"/> 

<h1>게시물 목록</h1>

<div class="toolbar">
<form action="list" method="get" class="searchbox">
<input type="text" name="words">
<button>검색</button>
</form>
<a href='form' class='btn btn-primary btn-sm'>추가</a>
</div>


<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>도서사진</th><th>도서명</th><th>출판사</th><th>가격</th>
</tr>
</thead>
<tbody>


<c:forEach items="${list}" var="book">
    <c:set var="title" value="${fn:length(book.title) == 0 ? 
    '(제목이 없습니다.)' : book.title }"/>
      <tr>
       <td>${book.no}</td>
       <%--
       <td><a href='${book.no}'>${fn:substring(title, 0, 20)}
        ${(fn:length(title) > 20) ? '...' : ''}</a></td>
        --%>
        <td><img src="${contextPath}/download/${book.photo}" width="130px" height="auto"> </td>
        <td><a href='${book.no}'><span class="d-inline-block text-truncate" 
              style="max-width: 300px;">${title }</span></a> </td>
       <td>${book.publisher}</td><td>${book.price}</td>
      </tr>
</c:forEach>

</tbody>
</table>

<jsp:include page="../paging.jsp"/>

<jsp:include page = "../footer.jsp"/>

</div>
<jsp:include page = "../jslib.jsp"/>
</body>
</html>
    