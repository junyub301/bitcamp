
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

<h1>회원 변경</h1>
<%
try {
    PrintWriter out2 = new PrintWriter(out);
    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPwd(request.getParameter("password"));


    // executeUpdate()의 리턴값은 변경된 레코드들의 개수이다.
    // 만약 해당 번호와 일치하는 데이터를 찾지 못해 변경할게 없다면 0을 리턴한다.
    if (memberDao.update(member) > 0 ) { 
        out.println("<p>변경하였습니다..</p>");
    } else {
        out2.printf("<p>'%s'의 성적 정보가 없습니다.</p>\n", member.getNo());
    }

} catch (Exception e ) {
    e.printStackTrace();
    out.println(e.getMessage());
}
%>
<p><a href='list.jsp' class='btn btn-primary btn-sm'>목록</a></p>

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
    