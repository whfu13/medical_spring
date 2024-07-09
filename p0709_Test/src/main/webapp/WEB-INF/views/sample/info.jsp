<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<style>
			#sub_top h2{font-size:40px; font-weight:700; color:#333;
			 text-align:center; margin-bottom:15px;}
			#sub_top h3{width:1000px; height:127px; box-sizing:border-box;
			padding:40px 0px 20px; margin:0 auto; }
			
			.point div{display: inline-block; width:10px; height:10px;
			bacground: url(../images/join/pont_rs.png) no-repeat 45% 88%;
			position: relative; left:20px; vertical-align:middle;}
			
		</style>
	</head>
	<body>
		<div id="sub_top">
			<h2>회원가입</h2>
		</div>
		<h3>필수 정보 입력
		<span>(* 항목은 필수 항목입니다.)</span>
		</h3>
		<fieldset class="point">
		<form action="doInfo" name="ifrm" method="post">
			<div></div>
			<label>이름</label>
			<input type="text" name="name"><br>
			<div></div>
			<label>아이디</label>
			<input type="text" name="id">
			<input type="button" value="중복확인"><br>
			<span>4~16자리의 영문, 숫자, 특수기호(_)만 사용하실 수 있습니다.</span><br>
			<span>첫 글자는 영문으로 입력해 주세요.</span>
			<br>
			<div></div>
			<label>비밀번호</label>
			<input type="password" name="pw1"><br>
			<span>영문, 숫자, 특수문자 중 2종류 조합 시 10자리 이상 입력</span><br>
			<span>영문, 숫자, 특수문자 모두 조합 시 8자리 이상 입력</span><br>
			<div></div>
			<label>비밀번호 확인</label>
			<input type="password" name="pw2">
			<span>비밀번호를 다시 한번 입력해 주세요.</span><br>
			<div></div>
			<label>이메일</label>
			<input type="text" name="email">
			<span>@</span>
			<input type="text" name="main_tail">
			<select>
				<option selected>직접입력</option>
				<option>지메일</option>
				<option>네이버</option>
				<option>네이트</option>
				<option>핫메일</option>
				<option>파란</option>
				<option>엠팔</option>
				<option>야후</option>
				<option>드림위즈</option>
				<option>한메일(다음)</option>
			</select><br>
			<div></div>
			<label>주소</label>
			<input type="text" name="address">
			<span>-</span>
			<input type="text" name="address">
			<input type="button" value="우편번호"><br>
			<input type="text" name="address1"><br>
			<input type="text" name="address2"><br>
			<div></div>
			<label>휴대전화</label>
			<input type="text" name="phone">
			<span>-</span>
			<input type="text" name="phone1">
			<span>-</span>
			<input type="text" name="phone2">
			<br>
			
			<input type="reset" value="취소하기">
			<input type="submit" value="가입하기">
		</fieldset>
	</body>
</html>