<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글수정</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
</head>
<body>
<section>
    <h1>게시글수정</h1>
    <hr>

    <form action="board/doUpdate" name="modify" method="post" enctype="multipart/form-data">
      <table>
      <input type="hidden" name="post_no" value="${boardDto.post_no}">
      <input type="hidden" name="post_file" value="${boardDto.post_file}">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="id" value="${boardDto.id}" readonly>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="post_title" value="${boardDto.post_title}">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="post_content" cols="50" rows="10">${boardDto.post_content}</textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="files" id="file">
          </td>
        </tr>
        <tr>
        	<th>파일이름</th>
        	<c:if test="${boardDto.post_file != null}">
        		<td>${boardDto.post_file}</td>
       		</c:if>
        	<c:if test="${boardDto.post_file = null}">
        		<td>첨부파일없음</td>
       		</c:if>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">수정완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='/board/view?post_no=${boardDto.post_no}'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>