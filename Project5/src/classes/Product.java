package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */

public class Product {

    private Integer productid;
    private String productname;
    private Integer productqty;
    private String producttype;
    private Double productprice;

    List<Variant> variantList = new ArrayList<Variant>();

    public Integer getProductID() {
        return productid;
    }

    public void setProductID(Integer productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productname;
    }

    public void setProductName(String productname) {
        this.productname = productname;
    }

    public Integer getProductQty() {
        return productqty;
    }

    public void setProductQty(Integer productqty) {
        this.productqty = productqty;
    }

    public String getProductType() {
        return producttype;
    }

    public void setProductType(String producttype) {
        this.producttype = producttype;
    }

    public Double getProductPrice() {
        return productprice;
    }

    public void setProductPrice(Double productprice) {
        this.productprice = productprice;
    }

    public List<Variant> getVariantList() {
        return variantList;
    }

    public void setVariantList(List<Variant> variantList) {
        this.variantList = variantList;
    }

    public Product(Integer productid, String productname, Integer productqty, String producttype, Double productprice) {
        this.productid = productid;
        this.productname = productname;
        this.productqty = productqty;
        this.producttype = producttype;
        this.productprice = productprice;
    }

    public Product(){

    }
}
