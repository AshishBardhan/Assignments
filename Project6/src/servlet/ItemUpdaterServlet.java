package servlet;

import domain.Item;
import domain.ItemVariant;
import service.IItemService;
import service.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemUpdaterServlet extends HttpServlet {

    private IItemService itemService = new ItemService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Item item = itemService.getItemById(id);
        request.setAttribute("nid", item);
        RequestDispatcher view = request.getRequestDispatcher("/updateitem.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();

        Item newItem = new Item();

        Item oldItem = new Item();

        RequestDispatcher view = request.getRequestDispatcher("/updatevariant.jsp");
        //view.forward(request,response);

        Integer id = Integer.parseInt(request.getParameter("id"));
        oldItem = itemService.getItemById(id);

        if(! request.getParameter("ProdQty").equals(""))
            newItem.setQty(Integer.parseInt(request.getParameter("ProdQty")));
        else
            newItem.setQty(-1);

        if(! request.getParameter("ProdName").equals(""))
            newItem.setName(request.getParameter("ProdName"));
        else
            newItem.setName("XYZ-XYZ");

        if(! request.getParameter("ProdType").equals(""))
            newItem.setTyp(request.getParameter("ProdType"));
        else
            newItem.setTyp("XYZ-XYZ");

        if(! request.getParameter("ProdPrice").equals(""))
            newItem.setPrice(Double.parseDouble(request.getParameter("ProdPrice")));
        else
            newItem.setPrice(0.0);


        if(itemService.updateItem(newItem,oldItem)){
                view = request.getRequestDispatcher("/updateitemdone.jsp");
                view.forward(request,response);
        }
        else{
                view = request.getRequestDispatcher("/updateitemfail.jsp");
                view.forward(request,response);
        }
    }
}
