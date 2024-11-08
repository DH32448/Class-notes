

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生</title>
</head>
<body>
<h3>学生管理</h3>
<ul style="display: flex;">
    <li style="margin-right: 10%"><a href="/mk5/stu/show.do">学生显示</a></li>
    <li style="margin-right: 10%"><a href="/mk5/stu/add.do">学生添加</a></li>
    <li><a href="/mk5/main.do">返回首页</a></li>
</ul>

<hr>
<table border="1" width="80%">
    <c:forEach items="${stus}" var="s">
        <tr>
            <td>${s.sno}</td>
            <td>${s.sname}</td>
            <td>${s.phone}</td>
            <td>${s.pwd}</td>
            <td>${s.clzno}</td>
            <td>${s.clzname}</td>
            <td><a href="/mk5/stu/update.do?sno=${s.sno}">更新</a></td>
            <td><a href="/mk5/stu/del.do?sno=${s.sno}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>