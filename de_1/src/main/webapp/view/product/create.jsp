<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/25/2022
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/employee?action=list">List All Product</a>
    </h2>
    <c:if test="${message != null}">
        <div class="alert alert-success" role="alert">
                ${message}
        </div>
    </c:if>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="${name}"/>
                    <p style="color: red">${validate.get("name")}</p>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="number" name="price" id="price" size="15" value="${price}"/>
                                        <p style="color: red">${validate.get("price")}</p>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="number" name="quantity" id="quantity" size="15" value="${quantity}"/>
                                        <p style="color: red">${validate.get("quantity")}</p>
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <select name="idColor" id="idColor">
                        <c:forEach items="${colorList}" var="color">
                            <option value="${color.idColor}">${color.nameColor}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select name="idCategory" id="idCategory">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.idCategory}">${category.nameCategory}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <button type="submit">
            Add new Product
        </button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
</body>
</html>

