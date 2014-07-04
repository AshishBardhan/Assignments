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
<body>
<form  action = "addvariant" method = "post" name = "UploadImage" enctype = 'multipart/form-data'>
    Enter Product ID        : <input type="text" name="ProdID"><br>
    Enter Variant Name      : <input type="text" name="VarName"><br>
    Insert Variant Image    : <input type="file" name="VarImg"><br>
    <input type="submit" name = "Submit" value="Submit"><br>
</form>
</body>
</html>