<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/12/2022
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/display-discount" method="post">
    <h2>name product</h2>
    <input type="text" name="ProductDescription"placeholder="name product">
    <h2>price</h2>
    <input type="number" name="ListPrice" placeholder="price">
    <h2>rate</h2>
    <input type="number" name="DiscountPercent" placeholder="rate">
    <br><br>
    <button type="submit">Calculate Discount</button>
  </form>
  </body>
</html>
