

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>班级列表显示</title>
</head>
<body>
<h3>班级管理</h3>
<ul style="display: flex;">
    <li style="margin-right: 10%"><a href="/mark/clz/show.do">班级显示</a></li>
    <li style="margin-right: 10%"><a href="/mark/clz/add.do">班级添加</a></li>
    <li><a href="/mark/main.do">返回首页</a></li>
</ul>



<hr>
<table border="1" width="80%">
    <c:forEach items="${clzs}" var="clz">
        <tr>
            <td>${clz.clzno}</td>
            <td>${clz.clzname}</td>
            <td><a href="/mark/clz/update.do?clzno=${clz.clzno}">更改班级名称</a></td>
            <td><a href="/mark/clz/del.do?clzno=${clz.clzno}">删除该班级</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>