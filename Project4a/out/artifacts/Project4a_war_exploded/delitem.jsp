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
<form  action = "/delitem" method = "post">
    Enter Item Name to be deleted  : <input type="text" name="iName"><br>
    <input type="submit" value="Delete"><br>
</form>
</html>