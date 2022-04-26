<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/18/2022
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="row">
    <div class="col-3">
        <h2>
            <a href="/employee?action=create">Add New Employee</a>
        </h2>
    </div>
    <div class="col-6 mx-auto">
        <h1 class="text-center"><a href="/">Furama Menu</a></h1>
        <c:if test="${message != null}">
            <div class="alert alert-success" role="alert">
                    ${message}
            </div>
        </c:if>
    </div>
    <div class="col-3">
        <form class="form-inline" method="get">
            <input type="hidden" name="action" value="search">
            <input class="form-control mr-sm-2" type="search" placeholder="Search by name" aria-label="Search"
                   name="searchByName">
            <select name="searchByEmployeePosition" id="searchByEmployeePosition">
                <option value="0"></option>
                <c:forEach items="${employeePositionList}" var="employeePosition">
                    <option value="${employeePosition.idPosition}">${employeePosition.namePosition}</option>
                </c:forEach>
            </select>
            <select name="searchByEmployeeDivision" id="searchByEmployeeDivision">
                <option value="0"></option>
                <c:forEach items="${employeeDivisionList}" var="employeeDivision">
                    <option value="${employeeDivision.idDivision}">${employeeDivision.nameDivision}</option>
                </c:forEach>
            </select>
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</div>
<table border="1" cellpadding="5" id="tableCustomer" class="table table-striped table-bordered mx-auto"
       style="width: 85%">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Id Card</th>
        <th>Salary</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Position</th>
        <th>Degree</th>
        <th>Division</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employeeList}" varStatus="status">
        <tr>
            <th>${status.count}</th>
            <td>${employee.name}</td>
            <td>${employee.dateOfBirth}</td>
            <td>${employee.idCard}</td>
            <td><fmt:formatNumber>${employee.salary}</fmt:formatNumber></td>
            <td>${employee.phone}</td>
            <td>${employee.email}</td>
            <td>${employee.address}</td>
            <td>
                <c:forEach items="${employeePositionList}" var="employeePosition">
                    <c:if test="${employee.idPosition eq employeePosition.idPosition}">
                        ${employeePosition.namePosition}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${employeeDegreeList}" var="employeeDegree">
                    <c:if test="${employee.idDegree eq employeeDegree.idDegree}">
                        ${employeeDegree.nameDegree}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${employeeDivisionList}" var="employeeDivision">
                    <c:if test="${employee.idDivision eq employeeDivision.idDivision}">
                        ${employeeDivision.nameDivision}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                    <button class="btn btn-info" type="button"><a href="/employee?action=edit&id=${employee.idEmployee}"
                                                              style="color: white">Edit</a></button>
            </td>
            <td>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                        onclick="getId(${employee.idEmployee}, '${employee.name}')">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Employee</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get">
                <div class="modal-body">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" id="get-id" name="id">
                    <h6>Name employee to delete : <h5 id="get-name"></h5></h6>
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

    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>