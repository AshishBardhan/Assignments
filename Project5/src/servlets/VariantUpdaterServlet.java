package servlets;

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

public class VariantUpdaterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();

        String img_src = request.getParameter("id");
        ProductVariantDAO pDAO = new ProductVariantDAO();
        pDAO.initializeDAO();
        Variant var = pDAO.getVariant(img_src);
        request.setAttribute("nid", var);
        RequestDispatcher view = request.getRequestDispatcher("/updatevariant.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();

        Variant new_var = new Variant();

        Variant old_var = new Variant();

        RequestDispatcher view = request.getRequestDispatcher("/updatevariant.jsp");
        //view.forward(request,response);

        String img_src = request.getParameter("id");
        ProductVariantDAO pDAO = new ProductVariantDAO();
        pDAO.initializeDAO();

        old_var = pDAO.getVariant(img_src);
        request.setAttribute("nid",old_var);

        if(! request.getParameter("ProdID").equals(""))
            new_var.setProductID(Integer.valueOf(request.getParameter("ProdID")));
        else
            new_var.setProductID(0);

        if( ! request.getParameter("VarID").equals(""))
            new_var.setVariantID(Integer.valueOf(request.getParameter("VarID")));
        else
            new_var.setVariantID(0);

        if(! request.getParameter("VarName").equals(""))
            new_var.setVariantName(request.getParameter("VarName"));
        else
            new_var.setVariantName("XYZ-XYZ");

        new_var.setVariantImgSrc("XYZ-XYZ");


        try{
            if(pDAO.updateVariant(new_var,old_var)){
                view = request.getRequestDispatcher("/updatevariantdone.jsp");
                view.forward(request,response);
            }
            else{
                view = request.getRequestDispatcher("/updatevariantfail.jsp");
                view.forward(request,response);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}