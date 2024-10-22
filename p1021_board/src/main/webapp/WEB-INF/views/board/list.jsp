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
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="/css/list.css">
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
  <!-- <link rel="stylesheet" href="/css/customer/customer2_style.css"> -->
   <script>
  	function sBtn(){
  		if($("#searchWord").val().length<1){
	  		//alert("검색어를 입력하세요.");
	  		return false;
  		}
  		
  		search.submit();
  	}
  </script>
  <style >
  
  body{
  
  padding-top: 100px;
  background-color: white;
  }
  img {
    width: 20px;
    height: 20px;
    
}
  
 .footer{
	
		font-size: 10px;
		color : rgba(0, 0, 0, .5);
		position : relative;
 	 	transform : translateY(0%);
		bottom: 0; /* Stick to the bottom */
		width: 100%; /* Full width */
		padding: 10px 30px 10px; /* Adjust padding as needed */
		border-top: 1px solid #ff8f03;
		background-color: white;
		text-align: left; /* Center align the text */
    }
    .fa-search:before {
    content: "";
}
   .write {
    text-align: center; /* Center content within the .write div */
    margin-top: 20px; /* Add some spacing above */
}

.page-num {
    display: inline-flex; /* Use inline-flex to center horizontally */
    justify-content: center; /* Center items horizontally */
    list-style: none;
    padding: 0;
    margin: 0;
    padding-top: 100px;
}

.page-num li {
    
    padding: 8px;
    cursor: pointer;
    font-size: 14px;
    text-align: center;
}
.fa-chevron-right:before {
    content: "\f054";
}
.page-num .num {
    background-color: #f4f4f4;
    border-radius: 4px;
}

.page-num .myNum {
    background-color: #ff8f03;
    color: white;
    font-weight: bold;
    border-radius: 4px;
}

.page-num .disabled {
    color: rgba(0, 0, 0, 0.3);
    cursor: default;
}

.page-num a {
    text-decoration: none;
    color: inherit;
}

.page-num .first,
.page-num .prev,
.page-num .next,
.page-num .last {
    font-size: 18px;
}

.page-num .first i,
.page-num .prev i,
.page-num .next i,
.page-num .last i {
    font-size: 20px;
}
    .search{
    
    top: +60px !important;
    right : 8px !important;
    }
     .header-inner {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .top-menu-bar {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
    }

    .left-menu, .right-menu {
        display: flex;
        align-items: center;
    }

    .logo-container {
        margin: 0 20px;  /* 로고 좌우 여백 조정 */
    }

    .logo img {
        width: 100px !important;
        height: 70px !important;
        margin-left: 150px;
        margin-right: 150px;
    }

    /* 반응형 디자인을 위한 미디어 쿼리 */
    @media (max-width: 768px) {
        .top-menu-bar {
            flex-direction: column;
        }

        .logo-container {
            order: -1;  /* 로고를 최상단에 배치 */
            margin: 10px 0;
        }
    }
    .search a {
        font-weight: bold;
    }
    
  </style>
</head>
<body>
<section>
    <h1>질문 게시판</h1>
    <div id="wrapper">
      <form action="/board/list" name="search" method="post" class="search-form">
        <select name="category" id="category">
          <option value="all">전체</option>
          <option value="post_title">제목</option>
          <option value="id">작성자</option>
        </select>
	
          <input type="text" name="searchWord" id="searchWord" placeholder="검색어를 입력하세요">
  
        <button type="button" onclick="sBtn()"><img src="/images/magnifying-glass-solid.svg"><i class="fas fa-search"></i></button>
      </form>
    </div>
    <table>
      <colgroup>
        <col width="18%">
        <col width="34%">
        <col width="18%">
        <col width="20%">
        <col width="10%">
      </colgroup>
      <tr>
      	<td colspan="5">전체 ${map.countAll}건</td>
      </tr>
      <!-- 제목부분 -->
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
      </tr>
      <!-- 게시판 내용부분 시작 -->
      <c:forEach items="${map.list}" var="bdto">
	<tr>
		<td>
		<c:if test="${bdto.post_indent == 0}"> <!-- 답변 부분 번호표시 x -->
			<span class="table-notice">${bdto.post_no}</span>
		</c:if>
		</td>
		<td class="table-title">
		<c:choose>
		<c:when test="${bdto.id == null || bdto.id == '탈퇴한 유저'}">
		<span class="deleted-user-post">${bdto.post_title}</span>
		</c:when>
		<c:otherwise>
		<a href="/board/view?post_no=${bdto.post_no}&page=${map.page}&category=${map.category}&searchWord=${map.searchWord}">
		<c:forEach var="i" begin="1" end="${bdto.post_indent}" step="1">↪Re:</c:forEach>
		${bdto.post_title}
		</a>
		</c:otherwise>
		</c:choose>
		</td>
		<td>
		<c:choose>
		<c:when test="${bdto.id == null || bdto.id == '탈퇴한 유저'}">
		<span class="deleted-user">탈퇴한 유저</span>
		</c:when>
		<c:otherwise>
		${bdto.id}
		</c:otherwise>
		</c:choose>
		</td>
		<td>
		<c:choose>
		<c:when test="${bdto.id == null || bdto.id == '탈퇴한 유저'}">
		<span class="deleted-user"><fmt:formatDate value="${bdto.post_reg_date}" pattern="YYYY-MM-dd"/></span>
		</c:when>
		<c:otherwise>
		<fmt:formatDate value="${bdto.post_reg_date}" pattern="YYYY-MM-dd"/>
		</c:otherwise>
		</c:choose>
		</td>
		<td>
		<c:choose>
		<c:when test="${bdto.id == null || bdto.id == '탈퇴한 유저'}">
		<span class="deleted-user">${bdto.post_hit}</span>
		</c:when>
		<c:otherwise>
		${bdto.post_hit}
		</c:otherwise>
		</c:choose>
		</td>
	</tr>
	</c:forEach>
      
      <!-- 게시판 내용부분 끝 -->
      
    </table>
	<div class="write">
    <button type="button" onclick="writeBtn()">글쓰기</button>
    
    <ul class="page-num">
        <!-- first 부분 -->
        <c:if test="${map.page <= 1}">
            <li class="first disabled"><i class="fas fa-chevron-left"></i></li>
        </c:if>
        <c:if test="${map.page > 1}">
            <a href="list?page=1"><li class="first"><i class="fas fa-chevron-left"></i></li></a>
        </c:if>
        <!-- prev 부분 -->
        <c:if test="${map.page <= 1}">
            <li class="prev disabled"><i class="fas fa-chevron-left"></i></li>
        </c:if>
        <c:if test="${map.page > 1}">
            <a href="list?page=${map.page - 1}"><li class="prev"><i class="fas fa-chevron-left"></i></li></a>
        </c:if>
        <!-- 페이지 번호 -->
        <c:forEach var="i" begin="${map.startPage}" end="${map.endPage}" step="1">
            <c:if test="${map.page == i}">
                <li class="myNum num"><div>${i}</div></li>
            </c:if>
            <c:if test="${map.page != i}">
                <a href="list?page=${i}"><li class="num"><div>${i}</div></li></a>
            </c:if>
        </c:forEach>
        <!-- next 부분 -->
        <c:if test="${map.page >= map.maxPage}">
            <li class="next disabled"><i class="fas fa-chevron-right"></i></li>
        </c:if>
        <c:if test="${map.page < map.maxPage}">
            <a href="list?page=${map.page + 1}"><li class="next"><i class="fas fa-chevron-right"></i></li></a>
        </c:if>
        <!-- last 부분 -->
        <c:if test="${map.page >= map.maxPage}">
            <li class="last disabled"><i class="fas fa-chevron-right"></i></li>
        </c:if>
        <c:if test="${map.page < map.maxPage}">
            <a href="list?page=${map.maxPage}"><li class="last"><i class="fas fa-chevron-right"></i></li></a>
        </c:if>
    </ul>
</div>
	<!-- 로그인한 회원은 글쓰기창으로 이동 -->
	<c:if test="${sessionId != null}">
	    <script>
	        function writeBtn(){
	            location.href="/board/write"; 
	        }
	    </script>
	</c:if>
	
  </section>
</body>
</html>