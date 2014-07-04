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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductVariantViewServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        ProductVariantDAO pDAO = new ProductVariantDAO();
        pDAO.initializeDAO();
        List<Product> prodList = pDAO.getProductList();
        request.setAttribute("ProductList", prodList);
        RequestDispatcher view = request.getRequestDispatcher("/viewproductvariant.jsp");
        view.forward(request, response);
    }
}
