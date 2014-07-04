/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/13/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class Variant {
    private int varID;
    private int prodID;
    private String color;

    public Variant(int varID, int prodID, String color) {
        this.varID = varID;
        this.prodID = prodID;
        this.color = color;
    }

    public Variant() {

    }

    public int getVarID() {
        return varID;
    }

    public void setVarID(int varID) {
        this.varID = varID;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Variant{" +
                "varID=" + varID +
                ", prodID=" + prodID +
                ", color='" + color + '\'' +
                '}';
    }
}
