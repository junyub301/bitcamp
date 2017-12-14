<%@page import="java.io.PrintWriter"%>
<%@page import="java100.app.domain.Member"%>
<%@page import="java100.app.listener.ContextLoaderListener"%>
<%@page import="java100.app.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<% MemberDao memberDao = ContextLoaderListener.iocContainer.getBean(MemberDao.class); %>
    
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
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

<h1>회원 상세 정보</h1>
<%
try {

    int no = Integer.parseInt(request.getParameter("no"));
    PrintWriter out2 = new PrintWriter(out);
    Member member = memberDao.selectOne(no);
    if (member != null) {

        out.println("<form action='update.jsp' method='post'>");
        
        out.println("<div class='form-group row'>");
        out.println("<label for='no'class='col-sm-2 col-form-label'>번호</label>");
        out.println("<div class='col-sm-10'>");
        out2.printf("<input class='form-control' readonly id='no' type='text' type='number' name='no' value='%d'>\n", member.getNo());
        out.println("</div>");
        out.println("</div>");

        out.println("<div class='form-group row'>");
        out.println("<label for='name'class='col-sm-2 col-form-label'>이름</label>");
        out.println("<div class='col-sm-10'>");
        out2.printf("<input class='form-control' id='name' type='text' name='name' value='%s'>\n", member.getName());
        out.println("</div>");
        out.println("</div>");

        out.println("<div class='form-group row'>");
        out.println("<label for='email'class='col-sm-2 col-form-label'>이메일</label>");
        out.println("<div class='col-sm-10'>");
        out2.printf("<input class='form-control' id='email' type='text' name='email' value='%s'>\n", member.getEmail());
        out.println("</div>");
        out.println("</div>");

        out.println("<div class='form-group row'>");
        out.println("<label for='creatdate'class='col-sm-2 col-form-label'>등록일</label>");
        out.println("<div class='col-sm-10'>");
        out2.printf("<input class='form-control' readonly id='creatdate' type='text' name='vwcnt' value='%s'>\n",member.getCreatedDate());
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-group row'>");
        out.println("<div class='col-sm-10'>");
        out.println("<button  class=\"btn btn-primary\">변경</button>");
        out2.printf("<a href='delete.jsp?no=%d' class=\"btn btn-danger\">삭제</a>\n", member.getNo());
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
    