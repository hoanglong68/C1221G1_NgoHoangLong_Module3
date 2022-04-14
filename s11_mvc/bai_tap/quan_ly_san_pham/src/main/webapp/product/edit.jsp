<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/14/2022
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-
Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<c:if test="${message != null}">
    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading">Edit successful !</h4>
    </div>
</c:if>
<button><a href="/products">Back to Product List</a></button>
<form method="post">
    <fieldset>
<legend>Product Information</legend>
<table border="1" class="table table-view">
    <tr>
        <td>Name:</td>
        <td><input type="text" name="name" value="${product.getName()}"></td>
    </tr>
    <tr>
        <td>Price:</td>
        <td><input type="number" name="price" value="${product.getPrice()}"></td>
    </tr>
    <tr>
        <td>Detail:</td>
        <td><input type="text" name="detail" value="${product.getDetail()}"></td>
    </tr>
    <tr>
        <td>Manufacturer:</td>
        <td><input type="text" name="manufacturer" value="${product.getManufacturer()}"></td>
    </tr>
</table>
        <br>
        <button type="submit" value="edit product">Edit Product</button>
    </fieldset>
</form>
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
