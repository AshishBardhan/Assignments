package classes;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/20/13
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */

public class Item {
    String name;
    Double price;
    int qty;
    String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item(String name, Double price, int qty, String type) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.type = type;
    }

    public Item(){

    }

    @Override

    public String toString() {
        return "Name = " + name +
                ": Price = " + price +
                ": Qty = " + qty +
                ": Type = " + type ;
    }
}

