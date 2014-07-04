package dao;

import classes.Item;
import utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/19/13
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */

public class ItemDAO {

    Statement st = null;
    ResultSet rs = null;
    Connection con = null;

    public void initializeDAO(){
        con = ConnectionUtil.getItem_con();
    }

    public List<Item> getItemList(){
      List<Item> itemList = new ArrayList<Item>();
      try{
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select * from item");
          while(rs.next()){
            Item it = new Item();
              it.setName(rs.getString(1));
              it.setPrice(rs.getDouble(2));
              it.setQty(rs.getInt(3));
              it.setType(rs.getString(4));
              it.setImg(rs.getString(5));
              itemList.add(it);
          }
      }
      catch (Exception ex){
        ex.getStackTrace();
      }
      return itemList;
    }

    public void addItemDAO(String Name, Double Price, Integer Qty, String Type){

        try{
            PreparedStatement pst = con.prepareStatement("insert into item values(?,?,?,?,?)");
            pst.setString(1, Name);
            pst.setDouble(2, Price);
            pst.setInt(3, Qty);
            pst.setString(4, Type);
            pst.setString(5, "default");
            pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateItemDAO(String Img){

        try{
            PreparedStatement pst = con.prepareStatement("update item set img_src = ? where img_src = ?");
            pst.setString(1, Img);
            pst.setString(2, "default");

            pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delItemDAO(String Name){

        try{
            PreparedStatement pst = con.prepareStatement("delete from item where name = ?");
            pst.setString(1, Name);
            pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String searchItemDAO(String Name) throws SQLException{
        PreparedStatement pst = con.prepareStatement("select img_src from item where name = ?");
        pst.setString(1, Name);
        rs = pst.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int numColumns = rsmd.getColumnCount();
        rs.next();

        if(rs.getRow() != 0 ){
            String str = rs.getString(1);
            return str;
        }
        else
            return null;
    }

}
