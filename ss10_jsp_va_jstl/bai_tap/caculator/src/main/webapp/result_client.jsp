<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/13/2022
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result: </h1>
<c:choose>
    <c:when test="${!message.equals('')}">
        <h2>${message}</h2>
    </c:when>
    <c:otherwise>
    <h2>${firstOperand} ${operator} ${secondOperand} = ${result}</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
