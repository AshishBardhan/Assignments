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
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemVariantViewServlet extends HttpServlet {

    private IItemService itemService = new ItemService();

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        List<Item> itemList = itemService.getItemList();
        request.setAttribute("ItemList", itemList);
        RequestDispatcher view = request.getRequestDispatcher("/viewitemvariant.jsp");
        view.forward(request, response);
    }
}
