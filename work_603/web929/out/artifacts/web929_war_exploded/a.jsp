<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head><body>
 <h2>A.jsp</h2>
  <h2> <%= new Date()%></h2>
 <h2>action: 请求动作 </h2>
 <%-- 相当于从 map 取出来--%>
 <h2><%=request.getAttribute("act")%></h2>
 <h2>生日:<%=request.getAttribute("birth")%></h2>
 <h2><%=request.getAttribute("lst")%></h2>
 <h2><%=request.getAttribute("lstxxx")%></h2>
 <br>
 <h2> el 表达式</h2>
 <h2>action: 请求动作 </h2>
 <%-- 相当于从 map 取出来--%>
 <h2>${act}</h2>
 <h2>生日:${birth}</h2>
 <h2>${lst}</h2>
 <h2>空指针不显示: ${lstxxx}</h2>

 <a href='/next.do'> <button>nextPage </button></a>
 <a href='/prev.do'> <button>prev </button></a>
 <a href='/first.do'> <button>first </button></a>
<form method="get" action="/move.do">
    行数:<input type="text" name="pageline">
    页数:<input type="text" name="pagenum">
    <input  type="submit" value="到指定页">
</form>
</body>
</html>
