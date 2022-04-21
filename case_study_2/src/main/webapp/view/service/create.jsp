<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/20/2022
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Service Management</h1>
    <h2>
        <a href="/service?action=list">List All Service</a>
    </h2>
    <c:if test="${messageCreate != null}">
        <div class="alert alert-success" role="alert">
                ${messageCreate}
        </div>
    </c:if>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Service</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Area:</th>
                <td>
                    <input type="number" name="area" id="area" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="number" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Capacity:</th>
                <td>
                    <input type="number" name="capacity" id="capacity" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Rent Type:</th>
                <td>
                    <select name="rentType" id="rentType">
                        <c:forEach items="${rentTypeList}" var="rentType">
                            <option value="${rentType.idRentType}">${rentType.nameRentType}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Service Type:</th>
                <td>
                    <select name="serviceType" id="serviceType">
                        <c:forEach items="${serviceTypeList}" var="serviceType">
                            <option value="${serviceType.idServiceType}">${serviceType.nameServiceType}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Standard Room:</th>
                <td>
                    <select name="standardRoom" id="standardRoom">
                        <option value="Vip">Vip</option>
                        <option value="Normal">Normal</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Convenient :</th>
                <td>
                    <input type="text" name="convenient" id="convenient" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Pool Area :</th>
                <td>
                    <input type="number" name="poolArea" id="poolArea" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Floors :</th>
                <td>
                    <input type="number" name="floors" id="floors" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
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
