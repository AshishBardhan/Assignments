package dao;

import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/20/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemDAO {

    Statement st = null;
    ResultSet rs = null;
    Connection con = null;

    public void initializeDAO(){
        con = ConnectionUtil.getItem_con();
    }

    public void addItemDAO(String Name, Double Price, Integer Qty, String Type){

        try{
            PreparedStatement pst = con.prepareStatement("insert into item values(?,?,?,?)");
            pst.setString(1, Name);
            pst.setDouble(2, Price);
            pst.setInt(3, Qty);
            pst.setString(4, Type);
            pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

