<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page = "../header.jsp"/>

<h1>로그인</h1>
<form action='login' method='post'>

<div class='form-group row'>
<label for='email'class='col-sm-2 col-form-label'>이메일</label>
<div class='col-sm-10'>
<input class='form-control' id='email' type='text' 
        name='email' value='${cookie.email.value}' >
</div>
</div>

<div class='form-group row'>
<label for='password'class='col-sm-2 col-form-label'>암호</label>
<div class='col-sm-10'>
<input class='form-control' id='password' type='password' name='password' >
</div>
</div>

<div class='form-group row'>
<div class="col-sm-2" ></div>
<div class="col-sm-10" >
<div class="form-check" >

    <input type="checkbox" class="form-check-input" id="saveEmail" name="saveEmail">
    <label class="form-check-label" for="saveEmail">이메일 저장</label>
</div>
</div> 
</div>
 
<div class='form-group row'>
    <div class='col-sm-10'>
        <button  class='btn btn-primary btn-sm' >로그인</button>
        <fb:login-button scope="public_profile,email" 
                         onlogin="checkLoginState();">
        </fb:login-button>
    </div>
</div>


</form>

<jsp:include page = "../footer.jsp"/>

</div>
<jsp:include page = "../jslib.jsp"/>
<script type="text/javascript" >
// 로그인 성공한 후 서버에 자동으로 로그인 하기
// -> 페이스북으롭터 사용자 정보 가져오기
function autoServerLogin(accessToken) {
    location.href = "facebookLogin?accessToken=" + accessToken;
}

 function statusChangeCallback(response) {
    console.log(response);
     if (response.status === 'connected') { // 로그인이 정상적으로 되었을 때, 
        autoServerLogin(response.authResponse.accessToken);
    } else { // 로그인이 되지 않았을 때,
        console.log("로그인 되지 않았음");
    } 
  }



// 페이스북에 로그인 버튼을 클릭한 후,
// 로그인 여부를 조사한다
function checkLoginState() {
 // 로그인 상태를 가져올 것을 요청한다.
 // =>로그인 정보를 가져왔을 때 호출될 함수를 등록한다.
    FB.getLoginStatus(function(response) {
        // 로그인 상태 정보를 가져왔으면 이 함수가 호출된다.
        statusChangeCallback(response);
      });

}

// 페이스북 자바스크립트 SDK 파일을 가져온 후에 호출될 함수를 등록한다.
// 즉 sdk.js 파일을 실행할 때 이 함수를 찾아 호출한다.
// 이 함수는 페이스북 API를 사용하기 전에 준비하는 작업을 수행한다.
window.fbAsyncInit = function() {
    FB.init({
      appId      : '566512227043440',
      cookie     : true,  
      xfbml      : true,  
      version    : 'v2.12' 
    });
  };

// 페이스북 SDK 라이브러리파일 로드
// - 동적으로 script 태그를 만든다.
// - 웹브라우저는 당연히 동적으로 생성된 script 태그를 실행할 것이다.
(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));




</script>



</body>
</html>
