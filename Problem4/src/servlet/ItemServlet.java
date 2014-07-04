package servlet;

import dao.ItemDAO;

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
 * Date: 6/19/13
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        String name = request.getParameter("iName");
        String type = request.getParameter("iType");
        Double price = Double.valueOf(request.getParameter("iPrice"));
        Integer qty = Integer.valueOf(request.getParameter("iQty"));
        ItemDAO iDAO = new ItemDAO();
        iDAO.initializeDAO();
        iDAO.addItemDAO(name,price,qty,type);
        RequestDispatcher view = request.getRequestDispatcher("/done.jsp");

        view.forward(request, response);
        System.out.println("Post Post Done");
    }
}