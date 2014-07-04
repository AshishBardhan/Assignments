package com.hk.a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created with IntelliJ IDEA.
 * User: Jyoti Narang
 * Date: 6/14/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdatabase", "root", "jyoti");
        return connection;
    }
}
