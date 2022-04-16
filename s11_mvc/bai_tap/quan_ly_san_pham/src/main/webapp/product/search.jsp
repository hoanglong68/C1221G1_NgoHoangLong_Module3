<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/14/2022
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Information Searched</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-
Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>Product Information Searched</h1>
<button><a href="/products">Back to Product List</a></button>
<c:choose>
    <c:when test="${message!= null}">
        <h2 style="color: red">${message}</h2>
    </c:when>
    <c:otherwise>
        <table border="1" class="table table-view">
            <c:forEach items="${productFindList}" var="productFind">
                <tr>
                    <td>Id: </td>
                    <td>${productFind.getId()}</td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td>${productFind.getName()}</td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td>${productFind.getPrice()}</td>
                </tr>
                <tr>
                    <td>Detail: </td>
                    <td>${productFind.getDetail()}</td>
                </tr>
                <tr>
                    <td>Manufacturer: </td>
                    <td>${productFind.getManufacturer()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
