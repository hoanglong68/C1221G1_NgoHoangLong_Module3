<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/14/2022
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<button><a href="/products?action=create"></a>Create new product</button>
<br>
<table border="1">
<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Detail</th>
    <th>Manufacturer</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>
<c:forEach items="${productList}" var="product">
<tr>
<td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
    <td>${product.getPrice()}</td>
    <td>${product.getDetail()}</td>
    <td>${product.getManufacturer()}</td>
    <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
    <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
