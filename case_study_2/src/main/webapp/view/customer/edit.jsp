<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/20/2022
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
<center>
    <h1>
        <a href="/customer?action=list">List All Customer</a>
    </h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit Customer</h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value='${customer.idCustomer}'/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="${customer.name}"/>
                </td>
            </tr>
            <tr>
                <th>Date Of Birth:</th>
                <td>
                    <input type="date" name="dateOfBirth" id="dateOfBirth" size="45" value="${customer.dateOfBirth}"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <c:if test="${customer.gender == 1}">
                        <select name="gender" id="gender">
                            <option selected value="1">Male</option>
                            <option value="0">Female</option>
                        </select>
                    </c:if>
                    <c:if test="${customer.gender == 0}">
                        <select name="gender" id="gender">
                            <option value="1">Male</option>
                            <option selected value="0">Female</option>
                        </select>
                    </c:if>

                </td>
            </tr>
            <tr>
                <th>Id Card:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="15" value="${customer.idCard}"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="15" value="${customer.phone}"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="15" value="${customer.email}"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="15" value="${customer.address}"/>
                </td>
            </tr>
            <tr>
                <th>Type:</th>
                <td>
                    <select name="type" id="type">
                        <c:forEach items="${customerTypeList}" var="type">
                            <c:if test="${customer.type == type.idCustomerType}">
                                <option selected value="${type.idCustomerType}">${type.nameCustomerType}</option>
                            </c:if>
                            <c:if test="${customer.type != type.idCustomerType}">
                                <option value="${type.idCustomerType}">${type.nameCustomerType}</option>
                            </c:if>
                        </c:forEach>
                    </select>
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

