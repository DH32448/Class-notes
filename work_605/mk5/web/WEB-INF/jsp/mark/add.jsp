<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程</title>
</head>
<body>
<h3>成绩管理-成绩录入 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <a href="/mark/main.do">返回首页</a></h3>
   <div>
       当前班级： ${clz.clzname} &nbsp;&nbsp;&nbsp;&nbsp;
       当前课程： ${cour.cname}
   </div>

   <table width="90%" border="1" cellspacing="0">
       <tr>
           <th>id 分数表主键</th>
           <th>clzno 班级编号</th>
           <th>sno  学号</th>
           <th>sname  学生姓名</th>
           <th>cno  课程编号</th>
           <th>cname 课程名称</th>
           <th>分数</th>
           <th>操作</th>
       </tr>
       <c:forEach items="${mks}" var="m">
           <tr>
               <form action="/mark/mk/doAdd.do?clzno=${clz.clzno}" method="post">
                   <td><input type="text" name="id" value = "${m.id}" readonly  size="10" ></td>
                   <td><input type="text" name="clzno" value = "${clz.clzno}" readonly  size="10" ></td>
                   <td><input type="text" name="sno" value = "${m.sno}" readonly size="10" ></td>
                   <td> ${m.sname}</td>
                   <td><input type="text" name="cno" value = "${m.cno}" readonly  size="10" ></td>
                   <td> ${m.cname} </td>
                   <td><input type="text" name="score" value = "${m.score}"></td>
                   <td><input type="submit" value="保存"></td>
               </form>
           </tr>
       </c:forEach>
   </table>
</body>
</html>