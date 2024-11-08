

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程</title>
</head>
<body>
<h3>课程管理</h3>
<ul style="display: flex;">
    <li style="margin-right: 10%"><a href="/mk5/course/show.do">课程显示</a></li>
    <li style="margin-right: 10%"><a href="/mk5/course/add.do">课程添加</a></li>
    <li><a href="/mk5/main.do">返回首页</a></li>
</ul>

<hr>
<table border="1" width="80%">
    <c:forEach items="${cs}" var="c">
        <tr>
            <td>${c.cno}</td>
            <td>${c.cname}</td>
            <td><a href="/mk5/course/update.do?cno=${c.cno}">更改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>