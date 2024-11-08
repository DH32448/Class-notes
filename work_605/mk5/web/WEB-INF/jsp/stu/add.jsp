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

<h4>添加学生</h4>
<hr>
<form action='/mk5/stu/doAdd.do' method='post'>
    <p>学生学号:<input type='text' name='sno'></p>
    <p>学生姓名:<input type='text' name='sname'></p>
    <p>学生手机:<input type='text' name='phone'></p>
    <p>学生密码:<input type='text' name='pwd' value="123456"></p>
    <p>所在班级:
        <select name = "clzno">
          <c:forEach items="${clzs}" var="c" >
              <option value="${c.clzno}">${c.clzname}</option>
          </c:forEach>
        </select>
    </p>
    <p><input type='submit' value='添加学生'></p>
</form>
</body>
</html>