package dao;

import classes.Login;
import utils.ConnectionUtil;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */


public class LoginDAO {

    Statement login_st = null;
    ResultSet login_rs = null;
    Connection login_con = null;

    public void initializeDAO(){
        login_con = ConnectionUtil.getCon();
    }

    public void addLogin(Login lg){

        try{
            PreparedStatement pst = login_con.prepareStatement("insert into login values(?,?)");
            pst.setString(1, lg.getName());
            pst.setString(2, lg.getPswd());
            pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean searchLogin(String Name, String Pswd) throws SQLException {


        PreparedStatement pst = login_con.prepareStatement("select * from login where name = ? and pswd = ?");
        pst.setString(1, Name);
        pst.setString(2, Pswd);

        login_rs = pst.executeQuery();
        ResultSetMetaData rsmd = login_rs.getMetaData();
        int numColumns = rsmd.getColumnCount();
        login_rs.next();
//            System.out.println(" " + login_rs.getString(1));
        if(login_rs.getRow() != 0 )
            return true;
        else
            return false;
    }

}

