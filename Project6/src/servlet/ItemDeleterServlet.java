package servlet;

import service.IItemService;
import service.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemDeleterServlet extends HttpServlet{


    private IItemService itemService = new ItemService();

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{

            Integer item_id  = Integer.parseInt(request.getParameter("id"));

            if(itemService.delItem(item_id)){
                RequestDispatcher view = request.getRequestDispatcher("/delitemdone.jsp");
                view.forward(request,response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("/delitemfail.jsp");
                view.forward(request,response);
            }

    }
}
