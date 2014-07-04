package servlets;

import classes.Product;
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
public class ProductAdderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        RequestDispatcher view = request.getRequestDispatcher("/addproduct.jsp");
        view.forward(request, response);
        //System.out.println("Get Done");
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        Product prod = new Product();
        prod.setProductID(Integer.valueOf(request.getParameter("ProdID")));
        prod.setProductName(request.getParameter("ProdName"));
        prod.setProductQty(Integer.valueOf(request.getParameter("ProdQty")));
        prod.setProductType(request.getParameter("ProdType"));
        prod.setProductPrice(Double.valueOf(request.getParameter("ProdPrice")));
        ProductVariantDAO pDAO = new ProductVariantDAO();
        pDAO.initializeDAO();
        try{
            if(pDAO.addProduct(prod)){
                RequestDispatcher view = request.getRequestDispatcher("/addproductdone.jsp");
                view.forward(request,response);
                //System.out.println("Post Post Done");
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("/addproductfail.jsp");
                view.forward(request,response);
            }
        }
        catch(SQLException ex){
            ex.getStackTrace();
        }

    }
}