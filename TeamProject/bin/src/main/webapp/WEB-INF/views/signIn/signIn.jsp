<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
nav {
	font-size: 12pt;
	font-family: 'PT Sans', Arial, Sans-serif;
	position: relative;
	float: right;
	right: 10%;
}

nav ul {
	padding: 0;
	margin: 0 auto;
	width: auto;
}

nav li {
	
}

nav a {
	line-height: 50px;
	height: 50px;
}

nav li a {
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
}

nav li:last-child a {
	border-right: 0;
}

nav a:hover, nav a:active {
	
}

nav a#pull {
	display: none;
}

html {
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
}

ul {
	/*list-style-type: none;*/
	margin: 0;
	padding: 0;
	background-color: #333;
	text-align: center;
}

li {
	/*position: relative;*/
	display: inline-block;
}

li a {
	color: #FFFFFF;
	text-align: center;
	padding: 14.5px 16px;
	text-decoration: none;
}

li a:hover {
	/*color: #597812;*/
	color: #FFD400;
	font-weight: normal;
}

.menu {
	width: 5000px;
	height: 50px;
	text-align: center;
	max-width: 100%;
	background-position: center;
	background-size: cover;
	background-color: #333333;
	color: white;
	position: absolute;
	z-index: 1;
}
</style>
<link rel="stylesheet" href="/css/signIn.css">
<script src="/js/Login.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body topmargin="0" bottommargin="0" leftmargin="0" rightmargin="0"
	style="background-color: #F6F6F6">
	<div class="menu">
		<nav class="clearfix">
			<ul class="clearfix">
				<li><a href="Intro">소개</a></li>
				<!--""<-여기 부분에 URL 작성하면 됨-->
				<li><a href="Search">시설검색</a></li>
				<li><a href="Info">정보</a></li>
				<li><a href="Custom">고객지원</a></li>
				<li><a href="Login">로그인</a></li>
				<li><a href="SignUp">회원가입</a></li>
			</ul>
			<a id="pull" href="#"></a>
		</nav>
	</div>
	<div class="wrapper">
		<div class="container">
			<div class="sign-up-container">
				<form>
					<h1>Create Account</h1>
					<div class="social-links">
						<div>
							<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
						</div>
						<div>
							<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
						</div>
						<div>
							<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
						</div>
					</div>
					<input type="text" placeholder="Name"> <input type="email"
						placeholder="Email"> <input type="password"
						placeholder="Password">
					<button class="form_btn">Sign Up</button>
				</form>
			</div>

			<script>
    	$(function(){
    		$("#sbtn").click(function(){
    			alert("로그인 진행");
    			if($("#id").val()==""){
    				alert("아이디를 입력하세요");
    				$("#id").focus();
    				return false;
    			}
    			if($("#pw").val()==""){
    				alert("비밀번호를 입력하세요");
    				$("#pw").focus();
    				return false;
    			}
    			loginFrm.submit();
    		})
    	});//제이쿼리
    </script>

			<div class="sign-in-container">
				<form action="/signIn/signIn" name="loginFrm" method="post">
					<h1>Sign In</h1>
					<div class="social-links">
						<div>
							<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
						</div>
						<div>
							<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
						</div>
						<div>
							<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
						</div>
					</div>

					<input type="Id" name="id" id="id" placeholder="아이디"> <input
						type="Pw" name="pw" id="pw" placeholder="비밀번호">
					<button class="form_btn" id="sbtn">Sign In</button>
				</form>
			</div>


		</div>
	</div>
	</div>
</body>
</html>