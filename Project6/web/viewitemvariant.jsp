<%--
  Created by IntelliJ IDEA.
  User: Ashish Bardhan
  Date: 6/19/13
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import = "java.util.List" %>
<%@ page import="dao.ItemDAO" %>
<%@ page import="domain.ItemVariant" %>
<%@ page import="domain.Item" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title> View Item List </title>
<head>
    <h1 align = "center"> Item - Variant Data List </h1>
</head>
<jsp:useBean id="link" scope="application" class = "dao.ItemDAO" />
<body>
    <%
        List<Item> iList = (List<Item>) request.getAttribute("ItemList");
        for (Item item: iList) {
     %>

        <br> Item ID        : <label> <%= item.getId()%> </label>
        <br> Item Name      : <label> <%= item.getName()%> </label>
        <br> Item Qty       : <label> <%= item.getQty()%> </label>
        <br> Item Type      : <label> <%= item.getTyp()%> </label>
        <br> Item Price     : <label> <%= item.getPrice()%> </label>
        <br> Total Variants : <label> <%= item.getItemVariantList().size()%> </label>
        <form action = "/delitem" method = "post">
            <input type = "hidden" name = "id" value = <%=item.getId()%>> </input>
            <input type = "submit" value = "Delete Item">
        </form>
        <form action = "/updateitem">
            <input type = "hidden" name = "id" value = <%=item.getId()%>> </input>
            <input type = "submit" value = "Update Item">
        </form>

            <%
            for (ItemVariant var: item.getItemVariantList()) {
        %>

            <br>
            <br> Variant ID     : <label> <%= var.getId()%> </label>
            <br> Variant Name   : <label> <%= var.getColor()%> </label>
            <br> Variant Image  : <label> <img src = "<%=request.getContextPath()%><%=var.getImg_src()%>" height = "250" width = "250" > </label>
            <form action = "/delvariant" method = "post">
              <input type = "hidden" name = "id" value = "<%=var.getImg_src()%>"> </input>
              <input type = "submit" value = "Delete Item Variant">
            </form>
            <form action = "/updatevariant">
                <input type = "hidden" name = "id" value = "<%=var.getImg_src()%>"> </input>
                <input type = "submit" value = "Update Item Variant">
            </form>
        <%
            }
        %>

    <br><br><br><br>

    <%
        }
    %>
    <a align = "center" href = "/logindone.jsp">Click Here To Return Back</a>
</body>
</html>