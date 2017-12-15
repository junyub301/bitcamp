<%@page import="java.io.PrintWriter"%>
<%@page import="java100.app.domain.Board"%>
<%@page import="java100.app.listener.ContextLoaderListener"%>
<%@page import="java100.app.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<% BoardDao boardDao = ContextLoaderListener.iocContainer.getBean(BoardDao.class); %> 


<!DOCTYPE html>
<html>
<head>
<title>게시물관리</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page = "/header.jsp"/>

<h1>게시물 변경</h1>
<%
try {
    PrintWriter out2 = new PrintWriter(out);
    Board board = new Board();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("contents"));
    board.setNo(Integer.parseInt(request.getParameter("no")));


    // executeUpdate()의 리턴값은 변경된 레코드들의 개수이다.
    // 만약 해당 번호와 일치하는 데이터를 찾지 못해 변경할게 없다면 0을 리턴한다.
    if (boardDao.update(board) > 0 ) { 
%>

        <p>변경하였습니다..</p>
<%
    } else { %>
        <p>'<%=board.getNo() %>'의 성적 정보가 없습니다.</p>
<%
}

} catch (Exception e ) {
    e.printStackTrace();%>
    <%=e.getMessage()%>
    <%}
%>
<p><a href='list.jsp' class='btn btn-primary btn-sm'>목록</a></p>

<jsp:include page = "/footer.jsp"/>

</div>
<%@ include file="../jslib.txt" %>
</body>
</html>

