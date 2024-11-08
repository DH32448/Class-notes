<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级</title>
</head>
<body>
<h3>班级管理</h3>
<ul style="display: flex;">
    <li style="margin-right: 10%"><a href="/mk5/clz/show.do">班级显示</a></li>
    <li style="margin-right: 10%"><a href="/mk5/clz/add.do">班级添加</a></li>
    <li><a href="/mk5/main.do">返回首页</a></li>
</ul>


<h4>添加班级</h4>
<hr>
<form action='/mk5/clz/doAdd.do' method='post'>
    <p>班级编号:<input type='text' name='clzno'></p>
    <p>班级名称:<input type='text' name='clzname'></p>
    <p><input type='submit' value='添加班级'></p>
</form>
</body>
</html>