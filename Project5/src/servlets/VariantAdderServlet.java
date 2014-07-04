package servlets;

import classes.Product;
import classes.Variant;
import dao.ProductVariantDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */

public class VariantAdderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        RequestDispatcher view = request.getRequestDispatcher("/addvariant.jsp");
        view.forward(request, response);
        //System.out.println("Get Done");
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();

        Variant var = new Variant();
        var.setProductID(Integer.valueOf((String)request.getParameter("ProdID")));
        var.setVariantID(Integer.valueOf((String)request.getParameter("VarID")));
        var.setVariantName((String)request.getParameter("VarName"));
        var.setVariantImgSrc("default");
        ProductVariantDAO pDAO = new ProductVariantDAO();
        pDAO.initializeDAO();
        try{
            if(pDAO.addVariant(var)){
                RequestDispatcher view = request.getRequestDispatcher("/addvariantimage.jsp");
                view.forward(request,response);
                                //System.out.println("Post Post Done");
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("/addvariantfail.jsp");
                view.forward(request,response);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}