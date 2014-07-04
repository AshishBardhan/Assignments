package com.hk.a1;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jyoti Narang
 * Date: 6/14/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        List<Product> products = ProductDao.getAllProducts();
        for (Product product: products) {
             List<ProductVariant> variants = product.getProductVariants();
            System.out.println("Product: " + product.getName() + " ");
            for (ProductVariant variant : variants) {
                System.out.println("Variant: " + variant.getColor());
            }
        }

    }
}
