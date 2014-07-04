package servlet;

import domain.User;
import service.IUserService;
import service.UserService;

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
 * Date: 6/27/13
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {

    private IUserService userService = new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
      PrintWriter out = response.getWriter();
      RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
      view.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String pswd = request.getParameter("pswd");
        List<User> userList = userService.getUserList(name, pswd);
        if(userList.size() > 0){
            RequestDispatcher view = request.getRequestDispatcher("/logindone.jsp");
            view.forward(request, response);
        }
        else{
            RequestDispatcher view = request.getRequestDispatcher("/loginfail.jsp");
            view.forward(request, response);
        }


    }

}