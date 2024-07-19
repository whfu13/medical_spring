<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원가입</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet" />
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
    <script>
        const hypenTel = (target) => {
            target.value = target.value
                .replace(/[^0-9]/g, '')
                .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
        }
    </script>
    <style>
        body {
            font-family: 'Noto Sans KR', sans-serif;
            background-color: #f0f8ff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .wrap {
            background: white;
            padding: 20px 40px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            width: 400px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #4CAF50;
        }
        .login div {
            margin-bottom: 15px;
        }
        .login h4 {
            margin: 0 0 5px;
            font-size: 14px;
            color: #333;
        }
        .login input[type="text"],
        .login input[type="password"],
        .login input[type="email"],
        .login input[type="date"] {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .login_etc {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .login_etc .checkbox {
            display: flex;
            align-items: center;
        }
        .login_etc .forgot_pw a {
            font-size: 14px;
            color: #4CAF50;
            text-decoration: none;
        }
        .searchBox {
            margin-top: 15px;
        }
        .searchBox h4 {
            text-align: center;
            font-size: 16px;
            margin-bottom: 10px;
            color: #333;
        }
        .searchBox p {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 10px;
            font-size: 14px;
            margin: 0;
        }
        .searchBox input[type="checkbox"] {
            margin-right: 5px;
        }
        .submit {
            text-align: center;
            margin-top: 20px;
        }
        .submit input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="wrap">
        <div class="login">
            <h2>회원가입</h2>
            <div class="login_id">
                <h4>아이디</h4>
                <input type="email" name="id" placeholder="ID" />
            </div>
            <div class="login_pw">
                <h4>비밀번호</h4>
                <input type="password" name="pw" placeholder="PW" />
            </div>
            <div class="login_id">
                <h4>이메일</h4>
                <input type="email" name="email" placeholder="E-MAIL" />
            </div>
            <div class="login_id">
                <h4>이름</h4>
                <input type="text" name="name" placeholder="NAME" />
            </div>
            <div class="login_id">
                <h4>핸드폰번호</h4>
                <input type="text" oninput="hypenTel(this)" maxlength="13" placeholder="휴대 전화번호" />
            </div>
            <div class="login_id">
                <h4>생년월일</h4>
                <input type="date" class="info" placeholder="생년월일" />
            </div>
            <div class="login_etc">
                <div class="checkbox">
                    <input type="checkbox" name="remember" id="remember" />
                    <label for="remember">로그인 상태유지</label>
                </div>
                <div class="forgot_pw">
                    <a href="">비밀번호 잊으셨나요?</a>
                </div>
            </div>
            <div class="searchBox">
                <h4>질환여부</h4>
                <p>
                    <input type="checkbox" name="disease" value="뇌졸중" /> 뇌졸중
                    <input type="checkbox" name="disease" value="암" /> 암
                    <input type="checkbox" name="disease" value="뇌혈관질환" /> 뇌혈관질환
                    <input type="checkbox" name="disease" value="파킨슨병" /> 파킨슨병
                    <input type="checkbox" name="disease" value="중추신경계질환" /> 중추신경계질환
                    <input type="checkbox" name="disease" value="근골격계질환" /> 근골격계질환
                    <input type="checkbox" name="disease" value="심폐질환" /> 심폐질환
                    <input type="checkbox" name="disease" value="치매" /> 치매
                </p>
            </div>
            <div class="searchBox">
                <h4>특성별</h4>
                <p>
                    <input type="checkbox" name="feature" value="도심위치" /> 도심위치
                    <input type="checkbox" name="feature" value="최신시설" /> 최신시설
                    <input type="checkbox" name="feature" value="자연/전원환경" /> 자연/전원환경
                    <input type="checkbox" name="feature" value="대형병원인접" /> 대형병원인접
                    <input type="checkbox" name="feature" value="암특화치료" /> 암특화치료
                    <input type="checkbox" name="feature" value="여성전용" /> 여성전용
                    <input type="checkbox" name="feature" value="치매전문" /> 치매전문
                </p>
            </div>
            <div class="submit">
                <input type="submit" value="확인" />
            </div>
        </div>
    </div>
</body>
</html>