<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/13/2022
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>

  <form action="/calculate">
    <fieldset>
    <legend> <h1>Simple Calculator</h1></legend>
      <input type="number" placeholder="first operand" name="firstOperand">
      <br>
      <select name="operator" id="">
        <option value="+">addtion</option>
        <option value="-">subtraction</option>
        <option value="*">multiplication</option>
        <option value="/">division</option>
      </select>
      <br>
      <input type="number" placeholder="second operand" name="secondOperand">
      <br>
      <input type="submit" name="submit">
    </fieldset>
  </form>
  <c:if test="${!empty result}">
    <h1>Result: </h1>
    <c:choose>
      <c:when test="${!message.equals('')}">
        <h2>${message}</h2>
      </c:when>
      <c:otherwise>
        <h2>${firstOperand} ${operator} ${secondOperand} = ${result}</h2>
      </c:otherwise>
    </c:choose>
  </c:if>

  </body>
</html>
