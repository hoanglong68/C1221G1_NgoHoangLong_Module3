<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/14/2022
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<button><a href="/products"></a>Back to Product List</button>
<form action="post">
<fieldset>
    <legend>Create Product</legend>
<table>
<tr>
    <td>Name: </td>
    <td><input type="text" name="name" placeholder="enter name product"></td>
</tr>
<tr>
    <td>Price: </td>
    <td><input type="number" name="price" placeholder="enter price"></td>
</tr>
    <tr>
        <td>Detail: </td>
        <td><input type="text" name="detail" placeholder="enter detail"></td>
    </tr>
    <tr>
        <td>Manufacturer: </td>
        <td><input type="text" name="manufacturer" placeholder="enter manufacturer"></td>
    </tr>
</table>
    <br>
    <button type="submit" value="create product">Create Product</button>
</fieldset>
</form>
</body>
</html>
