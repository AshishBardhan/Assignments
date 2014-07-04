package com.hk.a1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jyoti Narang
 * Date: 6/14/13
 * Time: 12:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductDao {

    public static List<Product> getAllProducts() throws SQLException {

        List<Product> products = new ArrayList<Product>();

        Connection connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select a.id, name, type, quantity, price, color from product a left join product_variant b on a.id = b.id; ";

        ResultSet resultset = statement.executeQuery(sql);
        HashMap<Integer, Product> productMap = new HashMap<Integer, Product>();
        while(resultset.next())
        {
            int id = resultset.getInt(1);
            String name = resultset.getString(2);
            String type = resultset.getString(3);
            int qty = resultset.getInt(4);
            int price = resultset.getInt(5);
            String color = resultset.getString(6);

            Product product = productMap.get(id);
            if(product == null) {
                product = new Product();
                product.setId(id);
                product.setName(name);
                product.setType(type);
                product.setPrice(price);
                product.setQuantity(qty);
                products.add(product);
                productMap.put(id, product);
            }

            ProductVariant variant = new ProductVariant();
            variant.setColor(color);
            product.addVariant(variant);
        }

        return products;
    }

}
