package servlet;

import dao.LoginDAO;

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
 * Date: 6/19/13
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */

public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
            PrintWriter out = response.getWriter();
            RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
            view.forward(request, response);
            System.out.println("Get Done");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
        //view.forward(request, response);
        String name = request.getParameter("name");
        String pswd = request.getParameter("pswd");
        System.out.println("Post Results : " + name + ' ' + pswd);
        LoginDAO lgDAO = new LoginDAO();
        lgDAO.initializeDAO();
        try{
          if(lgDAO.searchLoginDAO(name,pswd)){
             view = request.getRequestDispatcher("/welcome.jsp");
             view.forward(request, response);
          }
          else{
             view = request.getRequestDispatcher("/loginfailure.jsp");
             view.forward(request, response);
          }
         }
         catch(SQLException ex){
          ex.printStackTrace();
         }


    }

 }

