package servlet;

import dao.ItemDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/19/13
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemDeleterServlet extends HttpServlet {

    private static final String imagePath="C://Users//Ashish Bardhan//IdeaProjects//Assignments//Project4a//web";

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        RequestDispatcher view = request.getRequestDispatcher("/delitem.jsp");
        view.forward(request, response);
        //System.out.println("Get Done");
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        String name = request.getParameter("iName");
        ItemDAO iDAO = new ItemDAO();
        iDAO.initializeDAO();
        try{
            String img_src = iDAO.searchItemDAO(name);
            if(img_src != null){
                iDAO.delItemDAO(name);
                File f = new File(imagePath + img_src);
                FileInputStream fstream = new FileInputStream(f);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                br.close();
                fstream.close();
                f.delete();
                RequestDispatcher view = request.getRequestDispatcher("/deldone.jsp");
                view.forward(request,response);
                System.out.println("Post Post Done");
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("/delitem.jsp");
                view.forward(request,response);
                System.out.println("Post Post Done");
            }
        }
        catch (SQLException ex){
           ex.getStackTrace();
        }
    }
}