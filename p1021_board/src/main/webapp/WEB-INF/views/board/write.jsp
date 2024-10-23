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
  <title>글쓰기</title>
   <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
 
  
  <!-- 폰트어썸 불러오기 -->
     <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!-- css 불러오기 -->
    <link rel="stylesheet" href="/css/topbar.css">

    <!-- 제이쿼리 불러오기 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- js 불러오기 -->
    <script src="/js/topbar.js"></script>

    <!-- 아울 캐러셀 불러오기 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.theme.default.min.css">
  
  <style>
  body {
    padding-bottom: 100px; /* Prevent content from being hidden behind the footer */
}
    body, html {
        height: 100%;
        margin: 0;
        padding: 0;
        font-family: 'Noto Sans KR', sans-serif;
        background-color: #fff;
        display: flex;
        flex-direction: column;
    }

    .content {
        flex: 1;
        background-color: #f9f9f9;
        padding-bottom: 20px;
    }

    .write-container {
        max-width: 800px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    section {
        text-align: center;
        padding: 20px;
    }

    section h1 {
        font-size: 28px;
        color: #333;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    th, td {
        padding: 12px;
        border: 1px solid #ddd;
        text-align: left;
    }

    th {
        background-color: #f1f1f1;
        font-weight: bold;
    }

    input[type="text"], textarea {
        width: calc(100% - 20px);
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }

    .button-wrapper {
        text-align: center;
        margin-top: 20px;
    }

    .button-wrapper button {
        padding: 10px 20px;
        margin: 0 10px;
        cursor: pointer;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        color: #fff;
    }

    .write {
        background-color: #ff8f03;
    }

    .cancel {
        background-color: #ccc;
    }

    .footer {
    position: fixed; /* Fix the footer to the bottom of the screen */
    bottom: 0; /* Align to the bottom */
    left: 0;
    width: 100%; /* Ensure it spans the entire width of the viewport */
    font-size: 12px;
    color: rgba(0, 0, 0, 0.5);
    padding: 15px;
    border-top: 1px solid #ff8f03;
    background-color: #fff;
    text-align: left;
    box-shadow: 0 -2px 10px rgba(0, 0, 0, 0.1); /* Optional: Add some shadow for depth */
    z-index: 1000; /* Ensure it stays on top of other elements */
}

.footer p {
    margin: 0;
}
</style>
</head>
<body>
<section>
    <h1>게시판 글쓰기</h1>
<div class="write-container">
    <form action="/board/write" name="write" method="post" enctype="multipart/form-data">
      <table>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="id" value="${sessionId}">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="post_title">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="post_content" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="files" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='/board/list'">취소</button>
      </div>
    </form>
</div>
  </section>

</body>
</html>