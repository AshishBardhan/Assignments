<%--
  Created by IntelliJ IDEA.
  User: Ashish Bardhan
  Date: 6/19/13
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title> Welcome</title>
<head>
    <h1 align = "center"> Enter A New Product Into Database</h1>
</head>
<form  action = "/addproduct" method = "post">
    Enter Product ID        : <input type="text" name="ProdID"><br>
    Enter Product Name      : <input type="text" name="ProdName"><br>
    Enter Product Qty       : <input type="text" name="ProdQty"><br>
    Enter Product Type      : <input type="text" name="ProdType"><br>
    Enter Product Price     : <input type="text" name="ProdPrice"><br>
    <input type="submit" value="Submit"><br>
</form>
</html>