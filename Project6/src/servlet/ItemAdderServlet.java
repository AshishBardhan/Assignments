package servlet;

import domain.Item;
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
public class ItemAdderServlet extends HttpServlet {

    private IItemService itemService = new ItemService();

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        RequestDispatcher view = request.getRequestDispatcher("/additem.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        Item item = new Item();
        item.setId(itemService.getItemList().size() + 1);
        item.setName(request.getParameter("ItemName"));
        item.setQty(Integer.valueOf(request.getParameter("ItemQty")));
        item.setTyp(request.getParameter("ItemType"));
        item.setPrice(Double.valueOf(request.getParameter("ItemPrice")));
        if(itemService.addItem(item)){
                RequestDispatcher view = request.getRequestDispatcher("/additemdone.jsp");
                view.forward(request,response);
        }
        else{
                RequestDispatcher view = request.getRequestDispatcher("/additemfail.jsp");
                view.forward(request,response);
        }
    }
}