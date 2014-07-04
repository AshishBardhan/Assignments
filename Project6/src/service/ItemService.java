package service;

import dao.IItemDAO;
import dao.ItemDAO;
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

public class ItemService implements IItemService {
    private IItemDAO itemDAO = new ItemDAO();

    public List<Item> getItemList(){
        return itemDAO.getItemList();
    }

    public boolean addItem(Item item){
        return itemDAO.addItem(item);
    }

    public boolean addItemVariant(ItemVariant itemVariant, Integer item_id) {
        return itemDAO.addItemVariant(itemVariant, item_id);
    }

    public boolean updateItemVariant(ItemVariant newVariant,ItemVariant oldVariant) {
        return itemDAO.updateItemVariant(newVariant, oldVariant);
    }

    public boolean updateItem(Item newItem, Item oldItem) {
        return itemDAO.updateItem(newItem, oldItem);
    }

    public boolean delItemVariant(String Img_src){
        return itemDAO.delItemVariant(Img_src);
    }

    public boolean delItem(Integer item_id) {
        return itemDAO.delItem(item_id);
    }

    public ItemVariant getItemVariant(String Img_src) {
        return itemDAO.getItemVariant(Img_src);
    }

    public Item getItemById(Integer Item_id) {
        return itemDAO.getItemById(Item_id);
    }
}