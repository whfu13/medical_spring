<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doMember</title>
</head>
<body>
	<h2>Member에서 넘어온 데이터</h2>
	<form action="memUpdate" method="post">
	<table>
		<tr>
			<th>제목</th>
			<th>내용</th>
		</tr>
		<tr>
			<td>아이디(id)</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>패스워드(pw)</td>
			<td>${pw}</td>
		</tr>
		<tr>
			<td>이름(name)</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>전화번호(phone)</td>
			<td>${phone}</td>
		</tr>
		<tr>
			<td>성별(gender)</td>
			<td>${gender}</td>
		</tr>
		<tr>
			<td>취미(hobby)</td>
			<td>${hobby}</td>
		</tr>
	</table>
	<input type="submit" name="수정">
	</form>
</body>
</html>