<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<title>강의실관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page = "/header.jsp"/>

<h1>강의실 상세 정보</h1>
<form action='add' method='post'>
<div class='form-group row'>
<label for='loc'class='col-sm-2 col-form-label'>지역</label>
<div class='col-sm-10'>
<input class='form-control' id='loc' type='text' name='location' >
</div>
</div>
<div class='form-group row'>
<label for='name'class='col-sm-2 col-form-label'>이름</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name' >
</div>
</div>
<div class='form-group row'>
<label for='capacity'class='col-sm-2 col-form-label'>수용인원</label>
<div class='col-sm-10'>
<input class='form-control' id='capacity' type='number' name='capacity'>
</div>
</div>
<div class='form-group row'>
<div class='col-sm-10'>
<button  class="btn btn-primary">추가</button>
</div>
</div>
</form>

<jsp:include page = "/footer.jsp"/>

</div>
<%@ include file="../jslib.txt" %>
</body>
</html>
