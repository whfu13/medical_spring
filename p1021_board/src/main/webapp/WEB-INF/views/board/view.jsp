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
  <title>질문 게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  
  <link rel="stylesheet" href="/css/topbar.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.theme.default.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.min.js"></script>
  <script src="/js/topbar.js"></script>
<script>
	function deleteBtn("post_no"){
		if(confirm("게시글을 삭제하시겠습니까?")){
			location.href = "board/delete?post_no=" + post_no;
		}
	}
</script>
 <style >
    
   * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 16px;
            line-height: 1.6;
            color: #333;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background-color: white;
        }

        a {
            text-decoration: none;
            color: #333;
        }

        header {
            background-color: #f8f8f8;
            border-bottom: 1px solid #e7e7e7;
            padding: 10px 0;
        }

        section {
            flex: 1;
            max-width: 1200px; /* 넓이를 900px로 설정 */
            margin-left : 470px;
            padding-top: 20px;
             margin: 80px auto 0 auto;
            background-color: #fff; 
            width: 90%;
            padding-bottom: 40px;
        }

        h1 {
            margin-top: 40px;
    margin-bottom: 30px;
    font-size: 40px;
    background: #03C75A;
    color: #ffffff;
    padding: 30px;
    text-align: left;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #e7e7e7;
        }

        th {
            background-color: #f8f8f8;
            font-weight: bold;
        }

        .article {
            padding: 20px 15px;
            line-height: 1.8;
        }

        img {
            max-width: 100%;
            height: auto;
        }

        .separator {
            color: #ccc;
            margin: 0 10px;
        }

        .button-group {
            text-align: right;
            margin-top: 20px;
        }

        .list, .button-group a, .button-group div {
            display: inline-block;
            padding: 10px 20px;
            margin-left: 10px;
            background-color: #f8f8f8;
            border: 1px solid #ddd;
            border-radius: 4px;
            color: #333;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .list:hover, .button-group a:hover, .button-group div:hover {
            background-color: #e7e7e7;
        }
</style>
</head>
<body>
<section>
    <h1>게시판</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${map.boardDto.post_title}</strong></td>
      </tr>
      <tr>
        <td>${map.boardDto.id}</td>
        <td>조회수</td>
        <td>${map.boardDto.post_hit}</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${map.boardDto.post_content}</td>
      </tr>
      <tr>
          <td colspan="3"><strong>파일첨부</strong></td>
      </tr>
      <tr>
          <td colspan="3" class="article">
              <c:choose>
                  <c:when test="${not empty map.boardDto.post_file}">
                      <img style="width:50%;" src="/upload/${map.boardDto.post_file}" alt="첨부 이미지">
                  </c:when>
                  <c:otherwise>
                      첨부파일 없음
                  </c:otherwise>
              </c:choose>
          </td>
      </tr>
      <tr>
          <td colspan="3">
              <strong>다음글</strong> <span class="separator">|</span>
              <c:choose>
                  <c:when test="${not empty map.prevDto.post_no}">
                      <a href="/customer/customer2_view?post_no=${map.prevDto.post_no}&page=${page}">
                          [게시글] ${map.prevDto.post_title}
                      </a>
                  </c:when>
                  <c:otherwise>
                      다음글이 없습니다.
                  </c:otherwise>
              </c:choose>
          </td>
      </tr>
      <tr>
          <td colspan="3">
              <strong>이전글</strong> <span class="separator">|</span>
              <c:choose>
                  <c:when test="${not empty map.nextDto.post_no}">
                      <a href="/customer/customer2_view?post_no=${map.nextDto.post_no}&page=${page}">
                          [게시글] ${map.nextDto.post_title}
                      </a>
                  </c:when>
                  <c:otherwise>
                      이전글이 없습니다.
                  </c:otherwise>
              </c:choose>
          </td>
      </tr>
  </table>
<div class="button_group">
    <a href="/board/list?page=${page}&category=${category}&searchWord=${searchWord}"><div class="list">목록</div></a>
    <c:if test="${sessionId eq map.boardDto.id}">
	    <div class="list" onclick="deleteBtn(${map.boardDto.post_no})">삭제</div>
	    <a href="/board/update?post_no=${map.boardDto.post_no }" class="list">수정</a>
    </c:if>
    <a href=""><div class="list">답변달기</div></a>
</div>
  </section>
</body>
</html>