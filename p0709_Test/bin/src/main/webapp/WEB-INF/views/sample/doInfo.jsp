<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보</title>
	</head>
	<body>
		<h2>필수 정보 입력</h2>
		<table>
			<tr>
				<th>제목</th>
				<th>내용</th>
			</tr>
			<tr>
				<td>이름</td>
				<td>${sp.name}</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${sp.id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${sp.pw1}</td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td>${sp.pw2}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${sp.email}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${sp.address}</td>
			</tr>
			<tr>
				<td>휴대전화</td>
				<td>${sp.phone}</td>
			</tr>
		</table>
	</body>
</html>