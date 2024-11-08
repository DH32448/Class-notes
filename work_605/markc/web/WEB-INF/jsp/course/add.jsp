<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程</title>
</head>
<body>
<div>

</div>

<h4>课程管理</h4>
<ul style="display: flex;">
    <li style="margin-right: 10%"><a href="/course/show.do">课程显示</a></li>
    <li style="margin-right: 10%"><a href="/course/add.do">课程添加</a></li>
</ul>

<h4>添加课程</h4>
<hr>
<form action='/course/doAdd.do' method='post'>
    <p>课程编号:<input type='text' name='cno'></p>
    <p>课程名称:<input type='text' name='cname'></p>
    <p>课程学分:<input type='text' name='tid'></p>
    <p><input type='submit' value='添加课程'></p>
</form>
</body>
</html>