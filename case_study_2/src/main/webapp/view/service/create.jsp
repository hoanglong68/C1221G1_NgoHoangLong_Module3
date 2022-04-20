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
</head>
<body>
<center>
    <h1>Service Management</h1>
    <h2>
        <a href="/service?action=list">List All Service</a>
    </h2>
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
                    <input type="text" name="Convenient" id="Convenient" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Pool Area :</th>
                <td>
                    <input type="text" name="poolArea" id="poolArea" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Floors :</th>
                <td>
                    <input type="text" name="floors" id="floors" size="15"/>
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
</body>
</html>
