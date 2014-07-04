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
<head>
    <h1 align = "center"> Enter A New Variant of a Product Into Database</h1>
</head>
<form  action = "/addvariant" method = "post">
    Enter Product ID        : <input type="text" name="ProdID"><br>
    Enter Variant ID        : <input type="text" name="VarID"><br>
    Enter Variant Name      : <input type="text" name="VarName"><br>
    <input type="submit" value="Submit"><br>
</form>
</html>