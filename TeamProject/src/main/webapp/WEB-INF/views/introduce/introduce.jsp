<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="/js/chart.js"></script>
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
      
      nav li {}
      
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
      
      nav a:hover,
      nav a:active {}
      
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
      
</head>
<body>
    <div class="menu" >
        <nav class="clearfix">
          <ul class="clearfix">
		      <li><a href="introduce">소개</a></li> <!--""<-여기 부분에 URL 작성하면 됨-->
	          <li><a href="search">시설검색</a></li>
	          <li><a href="info">정보</a></li>
	          <li><a href="help">고객지원</a></li>
	          <li><a href="signin">로그인</a></li>
	          <li><a href="signup">회원가입</a></li>
        </ul>
        <a id="pull" href="#"></a>
      </nav>
      </div>
      <br><br><br><br><br>
    <h2>Intro blabla
        과거에는 대한민국에서 노인을 요양원으로 보내는 것을 현대판 고려장으로 생각하며 노인을 버리는 것처럼 인식되고 있다.<br>
        [2] 사실 현재도 별반 다르지 않아 2020년대 사례에서도 요양원에 입소할 때부터 가족에게 버려졌다는 감상을 가진 노인들의 사례가 있다.<br>
        [3] 하지만 실제 치매 노인을 집에서 모시는 데는 극심한 스트레스가 따른다.<br>
        [4] 덧붙여 집에 모실 경우 가족 중 한 사람이 생업을 포기하고 병수발에 전력해야 해<br>
        [5] 가정의 경제 상황 및 가족 간 인간 관계를 더욱 악화시키는 악순환에 빠지게 만든다. <br>
        거기에 전문적인 간호기술이 부족한 사람이 대부분이라 오히려 환자를 더 위험하게 만들 수도 있다. <br>
        효도라는 자기만족을 명목으로 환자를 더 위험하게 만드는 행동인 것이다. 거기다 노인 봉양문제에 따른 <br>
        자식과의 갈등 or 부부 간의 갈등으로 가족의 해체가 생기기도 하며 심하면 자살이나 살인으로 이어지는 등 사회문제로 발전되고 있는 현실이다.<br>

오히려 요양원이 삼시세끼 다양한 반찬으로 식사를 제공하고, 여러 유형의 치매 노인들을 전문적으로 보살펴준다.<br>
[6] 그러나 대한민국의 요양원은 보건복지부, 지방자치단체 등에서 검열/감사/감시/인건비의 기준이 해마다 강화되는 반면 <br>
지원금은 그대로이거나 인상폭에 비해 터무니 없이 적게 인상되어 자금난이 심해지는 곳들이 늘어나고 있다.
    </h2>
       <div>
       <canvas id="myChart"></canvas>
     </div>
</body>
</html>