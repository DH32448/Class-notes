<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生</title>
</head>
<body>
<%--把导航栏拷贝到每个 JSP --%>
<div>
    <h2  align="center">学生成绩管理-登录版本(Mark5)</h2>
    <div style="display: flex; justify-content: space-between">
        <h3>学生成绩管理-登录版本(Mark5)</h3>
        <div  style="width: 30%;display: flex; justify-content: space-between; margin-top: 10px">
            <c:if test="${empty logined}">
                <p style="color: brown">未登录</p>
            </c:if>
            <c:if test="${not empty logined}">
                <p style="color: blue">${logined.uname}</p>
            </c:if>
            <c:if test="${logined.role == 1}">
                <p style="color: blueviolet">学生</p>
            </c:if>
            <c:if test="${logined.role == 5}">
                <p style="color: #d79eff">任课教师</p>
            </c:if>
            <c:if test="${logined.role == 9}">
                <p style="color: #ff6af8">管理员</p>
            </c:if>
            <c:if test="${not empty logined}">
                <p style="color: blue"><a href="/mk5/login/logout.do">退出</a></p>
            </c:if>
            <p><a href="/mk5/main.do">首页</a></p>
        </div>
    </div>
</div>
<hr>
<blockquote><h4>更新-我的学生信息</h4></blockquote>
<hr>
<form action='/mk5/login/doUpdateMe.do' method='post'>
    <p>姓名:<input type='text' name='sname' value="${u.uname}"></p>
    <p>密码:<input type='text' name='pwd' value="${u.pwd}"></p>
    <p>手机:${u.phone}</p>
    <p>所在班级: ${u.clzno} &nbsp;&nbsp; ${clz.clzname}
    </p>
    <p><input type='submit' value='更新'></p>
</form>
</body>
</html>