<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程</title>
</head>
<body>
<h3>成绩管理-成绩查询 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <a href="/mark/main.do">返回首页</a></h3>

   <table width="90%" border="1" cellspacing="0">
       <tr>
           <th>id 主键</th>
           <th>班级编号</th>
           <th>班级名称号</th>
           <th>学号</th>
           <th>学生姓名</th>
           <th>课程编号</th>
           <th>课程名称</th>
           <th>分数</th>
           <th>录入时间</th>
       </tr>
       <c:forEach items="${mks}" var="m">
           <tr>
                   <td>${m.id}</td>
                   <td>${m.clzno}</td>
                   <td>${m.clzname}</td>
                   <td>${m.sno}</td>
                   <td> ${m.sname}</td>
                   <td>${m.cno}</td>
                   <td> ${m.cname} </td>
                   <td>${m.score}</td>
                   <td>${m.tpost}</td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>