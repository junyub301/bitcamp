<%@page import="java.io.PrintWriter"%>
<%@page import="java100.app.listener.ContextLoaderListener"%>
<%@page import="java100.app.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<% BoardDao boardDao = ContextLoaderListener.iocContainer.getBean(BoardDao.class); %> 
    
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page = "/header.jsp"/>

<h1>게시물 삭제</h1>
<jsp:useBean id="count" type="java.lang.Integer" scope="request"></jsp:useBean>
<%
try {
    
    if (count > 0) {
%>

        <p>삭제했습니다.</p>
<%
    } else {
%>
        <p>'${param.no}'의 성적 정보가 없습니다.</p>
<%
    }
} catch (Exception e ) {
    e.printStackTrace();
    out.println(e.getMessage());
}
%>
<p><a href='list' class='btn btn-primary btn-sm'>목록</a></p>

<jsp:include page = "/footer.jsp"/>

</div>
<%@ include file="../jslib.txt" %>
</body>
</html>
    