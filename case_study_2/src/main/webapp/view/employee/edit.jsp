<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/21/2022
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<center>
    <h1>
        <a href="/employee?action=list">List All Employee</a>
    </h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit Employee</h2>
            </caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value='${employee.idEmployee}'/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="${employee.name}"/>
                    <p style="color: red">${validate.get("name")}</p>
                </td>
            </tr>
            <tr>
                <th>Date Of Birth:</th>
                <td>
                    <input type="date" name="dateOfBirth" id="dateOfBirth" size="45" value="${employee.dateOfBirth}"/>
                </td>
            </tr>
            <tr>
                <th>Id Card:</th>
                <td>
                    <input type="number" name="idCard" id="idCard" size="15" value="${employee.idCard}"/>
                    <p style="color: red">${validate.get("idCard")}</p>
                </td>
            </tr>
            <tr>
                <th>Salary:</th>
                <td>
                    <input type="number" name="salary" id="salary" size="15" value="${employee.salary}"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="15" value="${employee.phone}"/>
                    <p style="color: red">${validate.get("phone")}</p>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="15" value="${employee.email}"/>
                    <p style="color: red">${validate.get("email")}</p>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="15" value="${employee.address}"/>
                </td>
            </tr>
            <tr>
                <th>Position:</th>
                <td>
                    <select name="employeePosition" id="employeePosition">
                        <c:forEach items="${employeePositionList}" var="employeePosition">
                            <c:if test="${employee.idPosition == employeePosition.idPosition}">
                                <option selected
                                        value="${employeePosition.idPosition}">${employeePosition.namePosition}</option>
                            </c:if>
                            <c:if test="${employee.idPosition != employeePosition.idPosition}">
                                <option value="${employeePosition.idPosition}">${employeePosition.namePosition}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Degree:</th>
                <td>
                    <select name="employeeDegree" id="employeeDegree">
                        <c:forEach items="${employeeDegreeList}" var="employeeDegree">
                            <c:if test="${employee.idDegree == employeeDegree.idDegree}">
                                <option selected
                                        value="${employeeDegree.idDegree}">${employeeDegree.nameDegree}</option>
                            </c:if>
                            <c:if test="${employee.idDegree != employeeDegree.idDegree}">
                                <option
                                        value="${employeeDegree.idDegree}">${employeeDegree.nameDegree}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Division:</th>
                <td>
                    <select name="employeeDivision" id="employeeDivision">
                        <c:forEach items="${employeeDivisionList}" var="employeeDivision">
                            <c:if test="${employee.idDivision == employeeDivision.idDivision}">
                                <option selected
                                        value="${employeeDivision.idDivision}">${employeeDivision.nameDivision}</option>
                            </c:if>
                            <c:if test="${employee.idDivision != employeeDivision.idDivision}">
                                <option
                                        value="${employeeDivision.idDivision}">${employeeDivision.nameDivision}</option>
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
