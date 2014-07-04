package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionUtil {

static Connection con = null;

    public static Connection getCon(){
        if(con == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root", "root");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
