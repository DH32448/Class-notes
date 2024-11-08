

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
<hr>
${msg}
<hr>
<table border="1" width="80%">
    <c:forEach items="${cs}" var="c">
        <tr>
            <td>${c.cno}</td>
            <td>${c.cname}</td>
            <td>${c.tid}</td>
            <td><a href="/course/update.do?cno=${c.cno}">更改</a></td>
            <td><a href="/course/del.do?cno=${c.cno}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>