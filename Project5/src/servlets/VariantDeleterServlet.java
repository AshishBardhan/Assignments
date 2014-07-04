package servlets;

import dao.ProductVariantDAO;

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
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class VariantDeleterServlet extends HttpServlet{

    private static final String imagePath="C://Users//Ashish Bardhan//IdeaProjects//Assignments//Project5//web";

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{

        String img_src = request.getParameter("id");
        ProductVariantDAO pvDAO = new ProductVariantDAO();
        pvDAO.initializeDAO();
        try{
            if(pvDAO.delVariant(img_src)){
                File f = new File(imagePath + img_src);
                FileInputStream fstream = new FileInputStream(f);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                br.close();
                fstream.close();
                f.delete();
                RequestDispatcher view = request.getRequestDispatcher("/delvariantdone.jsp");
                view.forward(request,response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("/delvariantfail.jsp");
                view.forward(request,response);
            }
        }
        catch(SQLException ex){
            ex.getStackTrace();
        }

    }
}
