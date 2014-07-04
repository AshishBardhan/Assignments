package service;

import domain.Item;
import domain.ItemVariant;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/27/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IItemService {
    public List<Item> getItemList();
    public boolean addItem(Item item);
    public boolean addItemVariant(ItemVariant itemVariant, Integer item_id);
    public boolean delItemVariant(String Img_src);
    public boolean delItem(Integer item_id);
    public ItemVariant getItemVariant(String Img_src);
    public Item getItemById(Integer Item_id);
    public boolean updateItemVariant(ItemVariant newVariant, ItemVariant oldVariant);
    public boolean updateItem(Item newItem, Item oldItem);

}
