<%--
  Created by IntelliJ IDEA.
  User: Ashish Bardhan
  Date: 6/19/13
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import = "java.util.List" %>
<%@ page import="dao.ProductVariantDAO" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="classes.Product" %>
<%@ page import="classes.Variant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title> View Item List </title>
<head>
    <h1 align = "center"> Product - Variant Data List </h1>
</head>
<jsp:useBean id="link" scope="application" class = "dao.ProductVariantDAO" />
<body>
    <%
        List<Product> pList = (List<Product>) request.getAttribute("ProductList");
        for (Product prod: pList) {
     %>

        <br> Product ID     : <label> <%= prod.getProductID()%> </label>
        <br> Product Name   : <label> <%= prod.getProductName()%> </label>
        <br> Product Qty    : <label> <%= prod.getProductQty()%> </label>
        <br> Product Type   : <label> <%= prod.getProductType()%> </label>
        <br> Product Price  : <label> <%= prod.getProductPrice()%> </label>
        <br> Total Variants : <label> <%= prod.getVariantList().size()%> </label>
        <form action = "/delproduct" method = "post">
            <input type = "hidden" name = "id" value = <%=prod.getProductName()%>> </input>
            <input type = "submit" value = "Delete Product">
        </form>
        <form action = "/updateproduct">
            <input type = "hidden" name = "id" value = <%=prod.getProductID()%>> </input>
            <input type = "submit" value = "Update Product">
        </form>

            <%
            for (Variant var: prod.getVariantList()) {
        %>

            <br>
            <br> Variant ID     : <label> <%= var.getVariantID()%> </label>
            <br> Variant Name   : <label> <%= var.getVariantName()%> </label>
            <br> Variant Image  : <label> <img src = "<%=request.getContextPath()%><%=var.getVariantImgSrc()%>" height = "250" width = "250" > </label>
            <form action = "/delvariant" method = "post">
              <input type = "hidden" name = "id" value = "<%=var.getVariantImgSrc()%>"> </input>
              <input type = "submit" value = "Delete Variant">
            </form>
            <form action = "/updatevariant">
                <input type = "hidden" name = "id" value = "<%=var.getVariantImgSrc()%>"> </input>
                <input type = "submit" value = "Update Variant">
            </form>
        <%
            }
        %>

    <br><br><br><br>

    <%
        }
    %>
    <a align = "center" href = "userlogindone.jsp">Click Here To Return Back</a>
</body>
</html>