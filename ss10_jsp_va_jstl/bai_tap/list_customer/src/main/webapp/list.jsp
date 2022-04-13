<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/13/2022
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Customer</title>
</head>
<body>
<table border="1">
    <h1>danh sách khách hàng</h1>
    <tr>
        <th>tên</th>
        <th>ngày sinh</th>
        <th>địa chỉ</th>
        <th>ảnh</th>
    </tr>
    <c:forEach items="${customer}" var="cus">
        <tr>
            <td>${cus.getName()}</td>
            <td>${cus.getDateOfBirth()}</td>
            <td>${cus.getAddress()}</td>
            <td><img src="${cus.getImage()}" alt="cc" style="width: 45px;"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

