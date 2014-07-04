/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/11/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryStore {


    private String iName;
    private Double iPrice;
    private Integer iQty;
    private String iType;

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public Double getiPrice() {
        return iPrice;
    }

    public void setiPrice(Double iPrice) {
        this.iPrice = iPrice;
    }

    public Integer getiQty() {
        return iQty;
    }

    public void setiQty(Integer iQty) {
        this.iQty = iQty;
    }

    public String getiType() {
        return iType;
    }

    public void setiType(String iType) {
        this.iType = iType;
    }

    public InventoryStore(String iName, Double iPrice, Integer iQty, String iType) {
        this.iName = iName;
        this.iPrice = iPrice;
        this.iQty = iQty;
        this.iType = iType;
    }

    @Override
    public String toString() {
        return "InventoryStore{" +
                "iName='" + iName + '\'' +
                ", iPrice=" + iPrice +
                ", iQty=" + iQty +
                ", iType='" + iType + '\'' +
                '}';
    }

               /*
    public static void main(String[] args) {
    InventoryStore IS = new InventoryStore("Cough Syrup",17.50,100,"Manufactured");
        System.out.println("Item 1: " + IS.toString());

    }        */
}