<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级</title>
</head>
<body>
<h3>班级管理</h3>
<ul style="display: flex;">
    <li style="margin-right: 10%"><a href="/mark/clz/show.do">班级显示</a></li>
    <li style="margin-right: 10%"><a href="/mark/clz/add.do">班级添加</a></li>
    <li><a href="/mark/main.do">返回首页</a></li>
</ul>


<%--${c}--%>
<h4>班级名称修改</h4>
<hr>
<form action='/mark/clz/doUpdate.do' method='post'>
    <p>班级编号:<input type='text' name='clzno'  value="${c.clzno}"  readonly></p>
    <p>班级名称:<input type='text' name='clzname' value="${c.clzname}"></p>
    <p><input type='submit' value='更新班级'></p>
</form>
</body>
</html>