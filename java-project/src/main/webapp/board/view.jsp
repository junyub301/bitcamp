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
<title>게시판관리</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>

<%
out.flush();

RequestDispatcher rd = request.getRequestDispatcher("/header");
rd.include(request, response);
%>

<h1>게시판 정보</h1>
<%
try {
    PrintWriter out2 = new PrintWriter(out);
    int no = Integer.parseInt(request.getParameter("no"));
    Board board = boardDao.selectOne(no);
    if (board != null) {
        out.println("<form action='update.jsp' method='post'>");
        
        out.println("<div class='form-group row'>");
        out.println("<label for='no'class='col-sm-2 col-form-label'>번호</label>");
        out.println("<div class='col-sm-10'>");
        out2.printf("<input class='form-control' readonly id='no' type='text' type='number' name='no' value='%d'>\n", board.getNo());
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-group row'>");
        out.println("<label for='title'class='col-sm-2 col-form-label'>제목</label>");
        out.println("<div class='col-sm-10'>");
        out2.printf("<input class='form-control' id='title' type='text' name='title' value='%s'>\n", board.getTitle());
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-group row'>");
        out.println("<label for='content'class='col-sm-2 col-form-label'>내용</label>");
        out.println("<div class='col-sm-10'>");
        out2.printf("<input class='form-control' id='content' type='text' name='contents' value='%s'>\n", board.getContent());
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-group row'>");
        out.println("<label for='regdate'class='col-sm-2 col-form-label'>등록일</label>");
        out.println("<div class='col-sm-10'>");
        out2.printf("<input class='form-control' readonly id='regdate' type='text' name='regdt' value='%s'>\n", board.getRegDate());
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-group row'>");
        out.println("<label for='viewcount'class='col-sm-2 col-form-label'>조회수</label>");
        out.println("<div class='col-sm-10'>");
        out2.printf("<input class='form-control' readonly id='viewcount' type='text' name='vwcnt' value='%s'>\n", board.getViewCount());
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-group row'>");
        out.println("<div class='col-sm-10'>");
        out.println("<button  class=\"btn btn-primary\">변경</button>");
        out2.printf("<a href='delete.jsp?no=%d' class=\"btn btn-danger\">삭제</a>\n", board.getNo());
        out.println("</div>");
        out.println("</div>");
        out.println("</form>");
        
    } else {
        out2.printf("'%s'번의 성적 정보가 없습니다.\n", no);
    }

} catch (Exception e ) {
    e.printStackTrace();
    out.println(e.getMessage());
}
%>

<%
out.flush();

rd = request.getRequestDispatcher("/footer");
rd.include(request, response);
%>

</div>
<script src='../node_modules/jquery/dist/jquery.slim.min.js' ></script>
<script src='../node_modules/popper.js/dist/umd/popper.min.js' ></script>
<script src='../node_modules/bootstrap/dist/js/bootstrap.min.js' ></script>
</body>
</html>
    
