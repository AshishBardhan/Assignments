package classes;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */

public class Variant {
    private Integer productid;
    private Integer variantid;
    private String variantname;
    private String variantimgsrc;

    public Integer getProductID() {
        return productid;
    }

    public void setProductID(Integer productid) {
        this.productid = productid;
    }

    public Integer getVariantID() {
        return variantid;
    }

    public void setVariantID(Integer variantid) {
        this.variantid = variantid;
    }

    public String getVariantName() {
        return variantname;
    }

    public void setVariantName(String variantname) {
        this.variantname = variantname;
    }

    public String getVariantImgSrc() {
        return variantimgsrc;
    }

    public void setVariantImgSrc(String variantimgsrc) {
        this.variantimgsrc = variantimgsrc;
    }

    public Variant(Integer productid, Integer variantid, String variantname, String variantimgsrc) {
        this.productid = productid;
        this.variantid = variantid;
        this.variantname = variantname;
        this.variantimgsrc = variantimgsrc;
    }

    public Variant() {
    }
}
