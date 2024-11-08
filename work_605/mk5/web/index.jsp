
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>学生成绩管理-登录版本</title>
  </head>
  <body>
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
    <div style="width: 90%; display: flex; justify-content: space-between">
      <div style="margin-left: 5px; width: 30%">
        <h3 align="center">登录</h3>
        <table width="90%" border="1" cellspacing="0" style="line-height: 36px">
        <form action='/mk5/login/doLogin.do' method='post'>
          <tr>
           <td>手机号:</td> <td><input type='text' name='phone'></td>
          </tr>
          <tr>
          <td>密码:</td><td><input type='text' name='pwd'></td>
          </tr>
          <tr>
          <td></td><td><input type='submit' value='登录'></td>
          </tr>
        </form>
        </table>
        <h4>${err}</h4>
      </div>
      <div style="border: antiquewhite 1px solid; width: 50%">
        <div>
           <h3>学生-成绩查询</h3>
          <c:if test="${logined.role == 1}">
            <ul style="list-style: square">
              <li><a href="/mk5/my/go2UpdateMe.do">修改密码</a></li>
              <li><a>课程查询</a></li>
              <li><a>成绩查询</a></li>
            </ul>
          </c:if>
        </div>
        <div>
          <h3>任课-教师登分</h3>
          <c:if test="${logined.role == 5}">
            <ul style="list-style: square">
              <li><a href="/mk5/my/go2UpdateMe.do">修改密码</a></li>
              <li><a>登分管理</a></li>
              <li><a>课程查询</a></li>
            </ul>
          </c:if>
        </div>
        <div>
          <h3>管理员-班级课程学生</h3>
          <c:if test="${logined.role == 9}">
             <ul style="list-style: square">
                <li><a href="/mk5/clz/show.do">班级管理</a></li>
                <li><a href="/mk5/course/show.do">课程管理</a></li>
                <li><a href="/mk5/stu/show.do">学生管理</a></li>
                <li><a>教师管理</a></li>
                <li><a>课程安排</a></li>
             </ul>
          </c:if>
        </div>
      </div>
    </div>
  </body>
</html>
