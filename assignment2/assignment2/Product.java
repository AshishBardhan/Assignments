package com.hk.a1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jyoti Narang
 * Date: 6/14/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Product {

    private int id;
    private String name;
    private String type;
    private int quantity;
    private int price;

    private List<ProductVariant> productVariants = new ArrayList<ProductVariant>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<ProductVariant> getProductVariants() {
        return productVariants;
    }

   public void addVariant(ProductVariant variant) {
        productVariants.add(variant);
   }

    public static class main {

        public static void main(String[] args)   throws SQLException
        {
            List<Product> products = ProductDao.getAllProducts();
            for (Product product: products) {
                System.out.println(product.getName());
            }
        }
    }
}
