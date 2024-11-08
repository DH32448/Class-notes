<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h2>Show.jsp</h2>
   <div style="border: 1px solid red">
       ${lst}
   </div>
   <table border="1">
   <c:forEach items="${lst}" var="x">
       <%-- for(Integer x : lst )--%>
        <tr> <td>整数</td>
              <td>${x}</td>
        </tr>
   </c:forEach>
   </table>
</body>
</html>
