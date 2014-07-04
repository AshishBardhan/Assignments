package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/20/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionUtil {

    static Connection login_con = null;
    static Connection item_con = null;


    public static Connection getLogin_con(){
        if(login_con == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                login_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root", "root");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return login_con;
    }


    public static Connection getItem_con(){
        if(item_con == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                item_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "root");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return item_con;
    }

}