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
    <h1 align = "center"> You have Logged In</h1>
    <h1 align = "center"> Enter Item Into Database</h1>
</head>
<form action= "/additem" method="post">
    Enter Name  : <input type="text" name="iName"><br>
    Enter Type  : <input type="text" name="iType"><br>
    Enter Qty   : <input type="text" name="iQty"><br>
    Enter Price : <input type="text" name="iPrice"><br>
    <input type="submit" value="Submit">
</form>
</html>