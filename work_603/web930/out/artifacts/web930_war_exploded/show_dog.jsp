<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h2>Show.jsp</h2>
   <div style="border: 1px solid red">
       ${dogs}
   </div>
   <table border="1">
   <c:forEach items="${dogs}" var="x">
       <%-- for(Integer x : lst )--%>
        <tr> <td>${x.id}</td>
              <td>${x.price}</td>
        </tr>
   </c:forEach>
   </table>
</body>
</html>
