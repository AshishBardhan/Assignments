package servlet;

import classes.Item;
import dao.ItemDAO;

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
 * Date: 6/19/13
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemViewServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        ItemDAO iDAO = new ItemDAO();
        iDAO.initializeDAO();
        List<Item> iList = iDAO.getItemList();
        request.setAttribute("itemList", iList);
        RequestDispatcher view = request.getRequestDispatcher("/viewitem.jsp");
        view.forward(request, response);
    }
}