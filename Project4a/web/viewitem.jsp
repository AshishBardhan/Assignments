<%--
  Created by IntelliJ IDEA.
  User: Ashish Bardhan
  Date: 6/19/13
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import = "java.util.List" %>
<%@ page import="dao.ItemDAO" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="classes.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title> View Item List </title>
<head>
    <h1 align = "center"> Item Data List </h1>
</head>
<jsp:useBean id="link" scope="application" class = "dao.ItemDAO" />
<body>
    <%
        List<Item> list = (List<Item>) request.getAttribute("itemList");
        for (Item item : list) {
     %>
        <br> Item Name  : <label> <%= item.getName()%> </label>
        <br> Item Type  : <label> <%= item.getType()%> </label>
        <br> Item Qty   : <label> <%= item.getQty()%> </label>
        <br> Item Price : <label> <%= item.getPrice()%> </label>
        <br> Item Image : <label> <img src = "<%=request.getContextPath()%><%=item.getImg()%>"> </label>

    <br><br>

    <%
        }
    %>
    <a align = "center" href = "userloginsuccess.jsp">Click Here To Return Back</a>
</body>
</html>