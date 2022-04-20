<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/20/2022
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h2><a href="/service?action=create">Add New Service</a></h2>
<h1 class="text-center"><a href="/">Furama Menu</a></h1>
<table border="1" cellpadding="5" id="tableCustomer" class="table table-striped table-bordered mx-auto"
       style="width: 85%">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Area</th>
        <th>Price</th>
        <th>Capacity</th>
        <th>Rent Type</th>
        <th>Service Type</th>
        <th>Standard Room</th>
        <th>Convenient</th>
        <th>Pool Area</th>
        <th>floors</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="service" items="${serviceList}">
        <tr>
            <th scope="row">${service.idService}</th>
            <td>${service.name}</td>
            <td>${service.area}</td>
            <td>${service.price}</td>
            <td>${service.capacity}</td>
            <td>
                <c:forEach items="${rentTypeList}" var="rentType">
                    <c:if test="${service.idRentType eq rentType.idRentType}">
                        ${rentType.nameRentType}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${serviceTypeList}" var="serviceType">
                    <c:if test="${service.idServiceType eq serviceType.idServiceType}">
                        ${serviceType.nameServiceType}
                    </c:if>
                </c:forEach>
            </td>
            <td>${service.standardRoom}</td>
            <td>${service.convenient}</td>
            <td>${service.poolArea}</td>
            <td>${service.floors}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
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
