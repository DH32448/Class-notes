<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程</title>
</head>
<body>

<h4>课程管理</h4>
<ul style="display: flex;">
    <li style="margin-right: 10%"><a href="/course/show.do">课程显示</a></li>
    <li style="margin-right: 10%"><a href="/course/add.do">课程添加</a></li>
</ul>

<h4>课程修改</h4>
<hr>
<form action='/course/doUpdate.do' method='post'>
    <p>课程编号:<input type='text' name='cno' value="${c.cno}"  readonly></p>
    <p>课程名称:<input type='text' name='cname' value = "${c.cname}"></p>
    <p>课程学分:<input type='text' name='tid' value = "${c.tid}"></p>
    <p><input type='submit' value='更新'></p>
</form>
</body>
</html>