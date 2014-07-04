import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/12/13
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayItem {


    public static void main(String[] args) {
        DisplayItem di = new DisplayItem();
        di.display();
    }

    public void display() {

        ItemDAO iDAO = new ItemDAO();
        List<Item> itemList = new ArrayList<Item>();

        iDAO.initializeDAO();
        itemList = iDAO.dispItemDAO();

        if(itemList.size() > 0)
        {
          System.out.println("RECORDS FOUND : ITEM LIST");
          int i = 0;

          for(;i<itemList.size();i++)
              System.out.println((i+1) + ": " + itemList.get(i).toString());
        }
        else
          System.out.println("WARNING : EMPTY RECORD !! ADD SOME ENTRIES ");

    }
}