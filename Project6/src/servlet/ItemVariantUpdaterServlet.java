package servlet;

import domain.ItemVariant;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.IItemService;
import service.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class ItemVariantUpdaterServlet extends HttpServlet {

    private IItemService itemService = new ItemService();
    private static final String imagePath="C://Users//Ashish Bardhan//IdeaProjects//Assignments//Project6//web";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        String img_src = request.getParameter("id");
        ItemVariant itemVariant = itemService.getItemVariant(img_src);
        request.setAttribute("nid", itemVariant);
        RequestDispatcher view = request.getRequestDispatcher("/updatevariant.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();

        ItemVariant newVariant = new ItemVariant();

        ItemVariant oldVariant = new ItemVariant();

        RequestDispatcher view = request.getRequestDispatcher("/updatevariant.jsp");
        //view.forward(request,response);

        String img_src = request.getParameter("id");
        oldVariant = itemService.getItemVariant(img_src);

        if(! request.getParameter("ProdID").equals(""))
            newVariant.setItem(itemService.getItemById(Integer.parseInt(request.getParameter("ProdID"))));
        else
            newVariant.setItem(null);

        if(! request.getParameter("VarName").equals(""))
            newVariant.setColor(request.getParameter("VarName"));
        else
            newVariant.setColor("XYZ-XYZ");

        newVariant.setImg_src("XYZ-XYZ");

        if(itemService.updateItemVariant(newVariant,oldVariant)){
                view = request.getRequestDispatcher("/updatevariantdone.jsp");
                view.forward(request,response);
        }
        else{
                view = request.getRequestDispatcher("/updatevariantfail.jsp");
                view.forward(request,response);
        }
    }
}
