package servlets;

import dao.ProductVariantDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */

public class VariantImageAdderServlet extends HttpServlet {

    private static final String imagePath="C://Users//Ashish Bardhan//IdeaProjects//Assignments//Project5//web";

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        RequestDispatcher view = request.getRequestDispatcher("/addvariantimage.jsp");
        view.forward(request, response);
        //System.out.println("Get Done");
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();


        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

        try{
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);

            Iterator<FileItem> iterator = fileItems.iterator();
            while (iterator.hasNext()) {
                FileItem fileItem = iterator.next();
                boolean formFied = fileItem.isFormField();
                if (formFied) {
                    out.println("regular form field"
                            + fileItem.getFieldName());
                } else {
                    String fileName = imagePath +"/img/"+fileItem.getName();
                    String img = "/img/"+ fileItem.getName();
                    OutputStream outputStream = new FileOutputStream(fileName);
                    InputStream inputStream = fileItem.getInputStream();

                    int readBytes = 0;
                    byte[] buffer = new byte[10000];
                    while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                        outputStream.write(buffer, 0, readBytes);
                    }
                    outputStream.close();
                    inputStream.close();
                    if(fileItem.getName()!= null){
                        ProductVariantDAO pDAO = new ProductVariantDAO();
                        pDAO.initializeDAO();
                        if(pDAO.updateVariantImage(img)){
                            RequestDispatcher view = request.getRequestDispatcher("/addvariantdone.jsp");
                            view.forward(request,response);
                            //System.out.println("Post Post Done");
                        }
                        else{
                            RequestDispatcher view = request.getRequestDispatcher("/addvariantfail.jsp");
                            view.forward(request,response);
                        }
                    }

                    outputStream.close();
                    inputStream.close();
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}