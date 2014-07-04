import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/14/13
 * Time: 12:08 PM
 * To change this template use File | Settings | File Templates.
 */

public class ItemDAO {



    Statement st = null;
    ResultSet rs = null;
    Connection con = null;

    public void initializeDAO(){


        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "root");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItemDAO(Item it){

        try{
            PreparedStatement pst = con.prepareStatement("insert into item values(?,?,?,?)");
            pst.setString(1, it.getName());
            pst.setDouble(2, it.getPrice());
            pst.setInt(3, it.getQty());
            pst.setString(4, it.getType());
            pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Item> dispItemDAO(){

        List<Item> itemList = new ArrayList<Item>();
        try{
            st = con.createStatement();
            rs = st.executeQuery("select * from item");
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();

            while(rs.next())
            {
                Item it = new Item();
                it.setName(rs.getString(1));
                it.setPrice(rs.getDouble(2));
                it.setQty(rs.getInt(3));
                it.setType(rs.getString(4));
                itemList.add(it);
            }
            return itemList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public void delItemDAO(String Name){

        try {
            st = con.createStatement();
            PreparedStatement pst = con.prepareStatement("delete from item where item_name = '" + Name + "'");
            pst.executeUpdate();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

