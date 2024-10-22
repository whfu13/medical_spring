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
  <title>ê¸ìì </title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
</head>
<body>
<section>
    <h1>ê²ìê¸ìì </h1>
    <hr>

    <form action="reply.do" name="reply" method="post">
      <table>
      <input type="hidden" name="bId" value="test">
      <input type="hidden" name="bGroup" value="test">
      <input type="hidden" name="bStep" value="test">
      <input type="hidden" name="bIndent" value="test">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>ìì±ì</th>
          <td>
            <input type="text" name="bName">
          </td>
        </tr>
        <tr>
          <th>ì ëª©</th>
          <td>
            <input type="text" name="bTitle" value="<ëµë³> test">
          </td>
        </tr>
        <tr>
          <th>ë´ì©</th>
          <td>
<textarea name="bContent" cols="50" rows="10">

---------------------------
[ëµê¸]
test
</textarea>
          </td>
        </tr>
        <tr>
          <th>ì´ë¯¸ì§ íì</th>
          <td>
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">ëµë³ìë£</button>
        <button type="button" class="cancel" onclick="javascript:location.href='list.do'">ì·¨ì</button>
      </div>
    </form>

  </section>

</body>
</html>