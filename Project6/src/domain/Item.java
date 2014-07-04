package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/27/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @Column(name = "type", nullable = false)
    private String typ;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<ItemVariant> itemVariantList = new ArrayList<ItemVariant>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String type) {
        this.typ = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ItemVariant> getItemVariantList() {
        return itemVariantList;
    }

    public void setItemVariantList(List<ItemVariant> itemVariantList) {
        this.itemVariantList = itemVariantList;
    }
}
