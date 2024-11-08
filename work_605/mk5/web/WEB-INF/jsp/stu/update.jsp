<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程</title>
</head>
<body>
<h3>学生管理</h3>
<ul style="display: flex;">
    <li style="margin-right: 10%"><a href="/mk5/stu/show.do">学生显示</a></li>
    <li style="margin-right: 10%"><a href="/mk5/stu/add.do">学生添加</a></li>
    <li><a href="/mk5/main.do">返回首页</a></li>
</ul>

<h4>更新学生</h4>
<hr>
<form action='/mk5/stu/doUpdate.do' method='post'>
    <p>学生学号:<input type='text' name='sno' value="${stu.sno}"  readonly></p>
    <p>学生姓名:<input type='text' name='sname' value="${stu.sname}"></p>
    <p>学生手机:<input type='text' name='phone' value="${stu.phone}"></p>
    <p>学生密码:<input type='text' name='pwd' value="${stu.pwd}"></p>
    <p>所在班级:
        <select name = "clzno">
          <c:forEach items="${clzs}" var="c" >
              <c:if test="${c.clzno!=stu.clzno}" >
                 <option value="${c.clzno}">${c.clzname}</option>
              </c:if>
              <c:if test="${c.clzno==stu.clzno}" >
                  <option value="${c.clzno}"  selected>${c.clzname}</option>
              </c:if>
          </c:forEach>
        </select>
    </p>
    <p><input type='submit' value='更新学生'></p>
</form>
</body>
</html>