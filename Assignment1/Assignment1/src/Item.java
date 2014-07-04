/**
 * Created with IntelliJ IDEA.
 * User: Pradeep
 */
public class Item {

    private String name;
    private Double price;
    private int qty;
    private String type;

    public Double getSalesTaxPerItem(){
        Double salesTax=0.0;

        if(this.getType().equals(ItemTypeEnum.RAW.getType())){
            salesTax= this.getPrice()*0.125;
        }else if(this.getType().equals(ItemTypeEnum.MANUFACTURED.getType())){
            salesTax = this.getPrice()*0.125;
            salesTax = salesTax + 0.02*(salesTax+this.getPrice());
        }else if(this.getType().equals(ItemTypeEnum.IMPORTED.getType())){
            Double importDuty=this.getPrice()*0.10;
            Double surcharge=5.0;
            if((importDuty+this.getPrice())>100){
                surcharge = 10.0;
            }
            if((importDuty+this.getPrice())>200){
                surcharge = 0.05*(importDuty+this.getPrice());
            }
            salesTax = importDuty+surcharge;
        }
        return salesTax;
    }
    public Double getTotalSalesTax(){
        return qty*getSalesTaxPerItem();
    }

    public Double getFinalPrice(){
        return qty*price + getTotalSalesTax();
    }


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
}
