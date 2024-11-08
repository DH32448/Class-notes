

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师</title>
</head>
<body>
<h3>教师管理</h3>
<ul style="display: flex;">
    <li style="margin-right: 10%"><a href="/mk5/tea/show.do">教师显示</a></li>
    <li style="margin-right: 10%"><a href="/mk5/tea/add.do">教师添加</a></li>
    <li><a href="/mk5/main.do">返回首页</a></li>
</ul>

<hr>
<table border="1" width="80%">
    <c:forEach items="${teas}" var="s">
        <tr>
            <td>${s.uid}</td>
            <td>${s.uname}</td>
            <td>${s.phone}</td>
            <td>${s.pwd}</td>
            <td><a href="/mk5/tea/update.do?uid=${s.uid}">更新</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>