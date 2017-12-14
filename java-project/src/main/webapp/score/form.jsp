<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<title>성적관리</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>
<header>
<nav class='navbar navbar-expand-lg navbar-light bg-light'>
<a class='navbar-brand' href='../index.html'>
<img src='../images/bootstrap-solid.svg' width='30' height='30' class='d-inline-block align-top' alt=''>
   비트캠프
</a>
<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav'aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
<span class='navbar-toggler-icon'></span>
</button>
<div class='collapse navbar-collapse' id='navbarNav'>
<ul class='navbar-nav'>
<li class='nav-item'>
<a class='nav-link' href='../score/list.jsp'>성적</a>
</li>
<li class='nav-item'>
<a class='nav-link' href='../member/list.jsp'>회원</a>
</li>
<li class='nav-item'>
<a class='nav-link' href='../board/list.jsp'>게시판</a>
</li>
<li class='nav-item'>
<a class='nav-link' href='../room/list.jsp'>강의실</a>
</li>
</ul>
</div>
</nav>
</header>
<h1>성적 상세 정보</h1>
<form action='add.jsp' method='post'>
<div class='form-group row'>
<label for='name'class='col-sm-2 col-form-label'>이름</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name'> 
</div>
</div>
<div class='form-group row'>
<label for='kor' class='col-sm-2 col-form-label'>국어</label>
<div class='col-sm-10'>
<input class='form-control' id='kor' type='number' name='kor'>
</div>
</div>
<div class='form-group row'>
<label for='eng' class='col-sm-2 col-form-label'>영어</label>
<div class='col-sm-10'>
<input class='form-control' id='eng' type='number' name='eng'>
</div>
</div>
<div class='form-group row'>
<label for='math' class='col-sm-2 col-form-label'>수학</label>
<div class='col-sm-10'>
<input class='form-control' id='math' type='text' type='number' name='math' >
</div>
</div>
<div class='form-group row'>
<div class='col-sm-10'>
<button  class="btn btn-primary">추가</button>
</div>
</div>
</form>
<footer>
   비트캠프 자바100기!@2017
</footer>
</div>
<script src='../node_modules/jquery/dist/jquery.slim.min.js' ></script>
<script src='../node_modules/popper.js/dist/umd/popper.min.js' ></script>
<script src='../node_modules/bootstrap/dist/js/bootstrap.min.js' ></script>
</body>
</html>
