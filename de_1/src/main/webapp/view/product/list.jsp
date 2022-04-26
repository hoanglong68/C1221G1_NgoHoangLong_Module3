<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/24/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h1 style="text-align: center">
    <a href="/">Product Management</a>
    <c:if test="${message != null}">
        <div id="message" class="alert alert-success" role="alert">
                ${message}
        </div>
    </c:if>
</h1>
<h2>
    <form>
        <button type="submit">
            <input type="hidden" name="action" value="create">
            Add New Product
        </button>
    </form>
</h2>
<hr>
<h3>Search Product</h3>
<div class="row">
    <form method="get" class="form-inline">
        <input type="hidden" name="action" value="search">
        <div class="col-4 mx-2">
            <input class="form-control mr-sm-2" type="search" placeholder="Search by name" aria-label="Search"
                   name="searchByName" value="">
        </div>
        <div class="col-4 mx-2">
            <input class="form-control mr-sm-2" type="number" placeholder="Search by price" aria-label="Search"
                   name="searchByPrice" value="">
        </div>
        <div class="col-4 mx-2">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </div>
    </form>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <tr>
            <th>${status.count}</th>
            <td>${product.name}</td>
            <td><fmt:formatNumber>${product.price}</fmt:formatNumber></td>
            <td>${product.quantity}</td>
            <td>
                <c:forEach items="${colorList}" var="color">
                    <c:if test="${product.idColor eq color.idColor}">
                        ${color.nameColor}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${categoryList}" var="category">
                    <c:if test="${product.idCategory eq category.idCategory}">
                        ${category.nameCategory}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <button class="btn btn-info" type="button"><a href="/customer?action=edit&id=${product.id}"
                                                              style="color: white">Edit</a></button>
            </td>
            <td>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal"
                        onclick="getId(${product.id}, '${product.name}')">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Delete Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post" action="/product">
                <div class="modal-body">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" id="get-id" name="id">
                    <h6>Name product to delete : <h5 id="get-name"></h5></h6>
                    <h4 class="text-warning">Are you sure ?</h4>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete it !</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script>
    function getId(id, name) {
        document.getElementById("get-id").value = id;
        document.getElementById("get-name").innerText = name;
    }
</script>
<script>
    const timeout = document.getElementById('message');
    setTimeout(hideElement, 2000) //milliseconds until timeout//
    function hideElement() {
        timeout.style.display = 'none'
    }
</script>
</body>
</html>
