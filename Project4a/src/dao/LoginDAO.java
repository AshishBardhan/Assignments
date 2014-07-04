package dao;

import classes.Login;
import utils.ConnectionUtil;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/19/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginDAO {

    Statement st = null;
    ResultSet rs = null;
    Connection con = null;

    public void initializeDAO(){
        con = ConnectionUtil.getLogin_con();
    }

    public void addLoginDAO(Login lg){

        try{
            PreparedStatement pst = con.prepareStatement("insert into login values(?,?)");
            pst.setString(1, lg.getName());
            pst.setString(2, lg.getPswd());
            pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean searchLoginDAO(String Name, String Pswd) throws SQLException{


            PreparedStatement pst = con.prepareStatement("select * from login where name = ? and pswd = ?");
            pst.setString(1, Name);
            pst.setString(2, Pswd);

            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
            rs.next();
//            System.out.println(" " + rs.getString(1));
            if(rs.getRow() != 0 )
              return true;
            else
              return false;
    }

}

