package com.hk.a1;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Jyoti Narang
 * Date: 6/14/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductVariant {

    private int Id;
    private String color;
    private int productId;

    public int getId() {
        return Id;
    }

    public String getColor() {
        return color;
    }

    public int getProductId() {
        return productId;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
