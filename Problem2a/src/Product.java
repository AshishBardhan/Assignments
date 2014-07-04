import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/13/13
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */



public class Product {
    private int prodID;
    private String prodName;
    private int prodQty;
    private Double prodPrice;

    List<Variant> variantList = new ArrayList<Variant>();

    public Product(int prodID, String prodName, int prodQty, Double prodPrice) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodQty = prodQty;
        this.prodPrice = prodPrice;
    }

    public Product() {

    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdQty() {
        return prodQty;
    }

    public void setProdQty(int prodQty) {
        this.prodQty = prodQty;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodID=" + prodID +
                ", prodName='" + prodName + '\'' +
                ", prodQty=" + prodQty +
                ", prodPrice=" + prodPrice +
                '}';
    }
}
