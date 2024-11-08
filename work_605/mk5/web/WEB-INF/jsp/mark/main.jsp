
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成绩</title>
</head>
<body>
<h3>成绩录入查询</h3>
<div>
    <ul style="list-style-type: square;width: 80%">
        <li><a href="/mark/main.do">返回首页</a></li>
        <li style="margin-right: 10%"><a href="/mark/mk/show.do">查询所有学生的成绩-先班级后课程排序</a></li>
        <li>
                <p>按班级课程录入学生成绩</p>
                <div style="display: flex;border: antiquewhite 2px solid;">
                    <form action="/mark/mk/doFind.do" style="width: 100%">
                        <div style="margin-left: 3%">
                            班级:
                            <select name="clzno">
                                <c:forEach items="${clzs}" var="c" >
                                    <option value="${c.clzno}">${c.clzname}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div style="margin-left: 3%">
                            课程:
                            <select name="cno">
                                <c:forEach items="${cs}" var="cc" >
                                    <option value="${cc.cno}">${cc.cname}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div style="margin-left: 3%">
                            <input type="submit" value="检索">
                        </div>
                    </form>
                </div>
        </li>
    </ul>
</div>
</body>
</html>
