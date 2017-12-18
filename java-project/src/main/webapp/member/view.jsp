<%@page import="java100.app.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page = "/header.jsp"/>

<h1>회원 상세 정보</h1>

<c:if test="${not empty member}">

         <form action='update' method='post'> 
        
         <div class='form-group row'> 
         <label for='no'class='col-sm-2 col-form-label'>번호</label> 
         <div class='col-sm-10'> 
         <input class='form-control' readonly id='no' type='text' type='number' name='no' value='${member.no}'>
         </div> 
         </div> 

         <div class='form-group row'> 
         <label for='name'class='col-sm-2 col-form-label'>이름</label> 
         <div class='col-sm-10'> 
         <input class='form-control' id='name' type='text' name='name' value='${member.name}'>
         </div> 
         </div> 

         <div class='form-group row'> 
         <label for='email'class='col-sm-2 col-form-label'>이메일</label> 
         <div class='col-sm-10'> 
         <input class='form-control' id='email' type='text' name='email' value='${member.email}'> 
         </div> 
         </div> 

         <div class='form-group row'> 
         <label for='creatdate'class='col-sm-2 col-form-label'>등록일</label> 
         <div class='col-sm-10'> 
         <input class='form-control' readonly id='creatdate' type='text' name='vwcnt' value='${member.createdDate}'>
         </div> 
         </div> 
        
         <div class='form-group row'> 
         <div class='col-sm-10'> 
         <button  class="btn btn-primary">변경</button> 
         <a href='delete?no=${member.no}' class="btn btn-danger">삭제</a>
         </div> 
         </div> 
         </form> 
 </c:if>
 <c:if test="${empty member }">
         '${param.no}'번의 성적 정보가 없습니다.
 </c:if>

<jsp:include page = "/footer.jsp"/>

</div>
<%@ include file="../jslib.txt" %>
</body>
</html>
    