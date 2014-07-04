package servlets;

import classes.Product;
import classes.Variant;
import dao.ProductVariantDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */

public class ProductUpdaterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();

        Integer ID = Integer.valueOf(request.getParameter("id"));
        ProductVariantDAO pDAO = new ProductVariantDAO();
        pDAO.initializeDAO();
        Product prod = pDAO.getProduct(ID);
        request.setAttribute("nid", prod);
        RequestDispatcher view = request.getRequestDispatcher("/updateproduct.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();

        Product new_prod = new Product();

        Product old_prod = new Product();

        RequestDispatcher view = request.getRequestDispatcher("/updateproduct.jsp");
        //view.forward(request,response);

        Integer ID = Integer.valueOf(request.getParameter("id"));
        ProductVariantDAO pDAO = new ProductVariantDAO();
        pDAO.initializeDAO();

        old_prod = pDAO.getProduct(ID);
        request.setAttribute("nid",old_prod);

        if(! request.getParameter("ProdID").equals(""))
            new_prod.setProductID(Integer.valueOf(request.getParameter("ProdID")));
        else
            new_prod.setProductID(0);

        if( ! request.getParameter("ProdQty").equals(""))
            new_prod.setProductQty(Integer.valueOf(request.getParameter("ProdQty")));
        else
            new_prod.setProductQty(0);

        if(! request.getParameter("ProdName").equals(""))
            new_prod.setProductName(request.getParameter("ProdName"));
        else
            new_prod.setProductName("XYZ-XYZ");

        if(! request.getParameter("ProdType").equals(""))
            new_prod.setProductType(request.getParameter("ProdType"));
        else
            new_prod.setProductType("XYZ-XYZ");

        if( ! request.getParameter("ProdPrice").equals(""))
            new_prod.setProductPrice(Double.valueOf(request.getParameter("ProdPrice")));
        else
            new_prod.setProductPrice(0.0);

        try{
            if(pDAO.updateProduct(new_prod,old_prod)){
                view = request.getRequestDispatcher("/updateproductdone.jsp");
                view.forward(request,response);
            }
            else{
                view = request.getRequestDispatcher("/updateproductfail.jsp");
                view.forward(request,response);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}