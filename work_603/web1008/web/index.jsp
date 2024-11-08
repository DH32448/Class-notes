
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
   <h2>index.jsp 1008</h2>
   <a href="/course/del.do?cid=2">删除</a>
   
   <form method="post" action="/course/del.do">
     <%--cid=100&score=101&cname=课程--%>
     cid: <input type="text" name="cid"  value="10"/> <br>
     cname: <input type="text" name="cname"  value="请输入课程"/> <br>
     score: <input type="text" name = "score" /> <br>
     <input type="submit">
   </form>
  </body>
</html>
