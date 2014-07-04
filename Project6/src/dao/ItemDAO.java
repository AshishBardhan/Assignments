package dao;

import domain.Item;
import domain.ItemVariant;
import domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.io.*;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/27/13
 * Time: 12:36 PM
 * To change this template use File | Settings | File Templates.
 */

public class ItemDAO implements IItemDAO {

    public List<Item> getItemList()
    {
        Session session= HibernateUtils.getSessionFactory().openSession();

        Query query=session.createQuery("select item from Item item");
        List<Item> itemList=(List<Item>) query.list();
        return itemList;
    }

    public Item getItemById(Integer item_id)
    {
        Session session= HibernateUtils.getSessionFactory().openSession();

        Query query=session.createQuery("select item from Item item where id = :id");
        query.setParameter("id",item_id);		
        List<Item> itemList=(List<Item>) query.list();
        session.close();
		return itemList.get(0);
    }

    public boolean searchItem(String name){
        Session session= HibernateUtils.getSessionFactory().openSession();

        Query query=session.createQuery("select item from Item item where name = :name");
        query.setParameter("name",name);
        List<Item> itemList=(List<Item>) query.list();
        if(itemList.size() > 0 && itemList.get(0).getName().equals(name))
            return true;
        else
            return false;
    }

    public boolean addItem(Item item) {

        Session session= HibernateUtils.getSessionFactory().openSession();
        if(! searchItem(item.getName())){

            Transaction tx = session.beginTransaction();
            session.save(item);
            tx.commit();

            /*
                  createQuery("insert into Item(name, qty, typ, price) " +
                  "select item.name, item.qty, item.typ, item.price from Item item");
          /*query.setParameter("id",item.getId());
          query.setParameter("name",item.getName());
          query.setParameter("qty",item.getQty());
          query.setParameter("type",item.getType());                                               query.setParameter("price",item.getPrice());
          */
          /*int result = query.executeUpdate();
          System.out.println("Rows affected: " + result);
          */return true;
      }
      else
          return false;
    }

    public boolean checkItem(Integer item_id){
        Session session= HibernateUtils.getSessionFactory().openSession();
        Query query=session.createQuery("select item from Item item where id = :id");
        query.setParameter("id",item_id);
        List<Item> itemList=(List<Item>) query.list();
        if(itemList.size() > 0 && itemList.get(0).getId().equals(item_id))
            return true;
        else
            return false;
    }

    public boolean addItemVariant(ItemVariant itemVariant, Integer item_id) {

        Session session= HibernateUtils.getSessionFactory().openSession();
        if(checkItem(item_id)){
            itemVariant.setItem(getItemById(item_id));
            Transaction tx = session.beginTransaction();
            session.save(itemVariant);
            tx.commit();
            return true;
        }
        else{
            return false;
        }
    }


    public boolean checkChangeItemVariant(ItemVariant var){
        if(var.getItem() == null && var.getColor().equals("XYZ-XYZ") && var.getImg_src().equals("XYZ-XYZ"))
            return false;
        else
            return true;
    }

    public boolean checkChangeItem(Item item){
        if(item.getQty().equals(-1) && item.getPrice().equals(0.0) && item.getName().equals("XYZ-XYZ") && item.getTyp().equals("XYZ-XYZ"))
            return false;
        else
            return true;
    }

    public boolean updateItemVariant(ItemVariant newVariant, ItemVariant oldVariant) {

        Session session= HibernateUtils.getSessionFactory().openSession();
        if(checkChangeItemVariant(newVariant)){
            if(! newVariant.getColor().equals("XYZ-XYZ")){

                Transaction tx = session.beginTransaction();
                Query query = session.createQuery("update ItemVariant set color = :new_color where color = :old_color and id = :id");
                query.setParameter("new_color", newVariant.getColor());
                query.setParameter("old_color", oldVariant.getColor());
                query.setParameter("id", oldVariant.getId());
                int res = query.executeUpdate();
                tx.commit();
                System.out.println("Rows affected: " + res);
            }
            if(newVariant.getItem() != null){
                Transaction tx = session.beginTransaction();
                Query query = session.createQuery("update ItemVariant set item = :new_item where item = :old_item and id = :id");
                query.setParameter("new_item", newVariant.getItem());
                query.setParameter("old_item", oldVariant.getItem());
                query.setParameter("id", oldVariant.getId());
                int res = query.executeUpdate();
                tx.commit();
                System.out.println("Rows affected: " + res);
            }
            return true;
        }
        else
            return false;
    }

    public boolean updateItem(Item newItem, Item oldItem) {

        Session session= HibernateUtils.getSessionFactory().openSession();
        if(checkChangeItem(newItem)){
            if(! newItem.getName().equals("XYZ-XYZ")){
                Transaction tx = session.beginTransaction();
                Query query = session.createQuery("update Item set name = :new_name where name = :old_name and id = :id");
                query.setParameter("new_name", newItem.getName());
                query.setParameter("old_name", oldItem.getName());
                query.setParameter("id", oldItem.getId());
                int res = query.executeUpdate();
                tx.commit();
                System.out.println("Rows affected: " + res);
            }
            if(! newItem.getTyp().equals("XYZ-XYZ")){
                Transaction tx = session.beginTransaction();
                Query query = session.createQuery("update Item set typ = :new_type where typ = :old_type and id = :id");
                query.setParameter("new_type", newItem.getTyp());
                query.setParameter("old_type", oldItem.getTyp());
                query.setParameter("id", oldItem.getId());
                int res = query.executeUpdate();
                tx.commit();
                System.out.println("Rows affected: " + res);
            }
            if(! newItem.getQty().equals(-1)){
                Transaction tx = session.beginTransaction();
                Query query = session.createQuery("update Item set qty = :new_qty where qty = :old_qty and id = :id");
                query.setParameter("new_qty", newItem.getQty());
                query.setParameter("old_qty", oldItem.getQty());
                query.setParameter("id", oldItem.getId());
                int res = query.executeUpdate();
                tx.commit();
                System.out.println("Rows affected: " + res);
            }
            if(! newItem.getPrice().equals(0.0)){
                Transaction tx = session.beginTransaction();
                Query query = session.createQuery("update Item set price = :new_price where price = :old_price and id = :id");
                query.setParameter("new_price", newItem.getPrice());
                query.setParameter("old_price", oldItem.getPrice());
                query.setParameter("id", oldItem.getId());
                int res = query.executeUpdate();
                tx.commit();
                System.out.println("Rows affected: " + res);
            }
           return true;
        }
        else
            return false;
    }



    public boolean searchItemVariant(String Img_src){
        Session session= HibernateUtils.getSessionFactory().openSession();
        Query query=session.createQuery("select item_variant from ItemVariant item_variant where img_src = :id");
        query.setParameter("id",Img_src);
        List<ItemVariant> itemVariantList = (List<ItemVariant>) query.list();
        if(itemVariantList.size() > 0 && itemVariantList.get(0).getImg_src().equals(Img_src))
            return true;
        else
            return false;
    }

    public ItemVariant getItemVariantByImgSrc(String Img_src){
        Session session= HibernateUtils.getSessionFactory().openSession();
        Query query=session.createQuery("select item_variant from ItemVariant item_variant where img_src = :id");
        query.setParameter("id",Img_src);
        List<ItemVariant> itemVariantList = (List<ItemVariant>) query.list();
        return itemVariantList.get(0);
    }

    public boolean delItemVariant(String Img_src){
        if(searchItemVariant(Img_src)){
            Session session= HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            ItemVariant itemVariant = getItemVariantByImgSrc(Img_src);
            session.delete(itemVariant);
            tx.commit();
            return true;
        }
        else
            return false;
    }

    public void delItemVariantImg(Item item) throws IOException {
      int i = 0;
      String imagePath="C://Users//Ashish Bardhan//IdeaProjects//Assignments//Project6//web";
        for(;i<item.getItemVariantList().size();i++){
            String img = imagePath + item.getItemVariantList().get(i).getImg_src();
            File f = new File(img);
            f.delete();
      }
    }

    public boolean delItem(Integer item_id) {
            Item item = getItemById(item_id);
			Session session= HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
			session.delete(item);
            tx.commit();
            if(item.getItemVariantList().size() > 0){
                try{
                    delItemVariantImg(item);
                }
                catch(IOException ex){
                    ex.getStackTrace();
                }
            }
            return true;
    }

    public ItemVariant getItemVariant(String Img_src) {
        Session session= HibernateUtils.getSessionFactory().openSession();
        Query query=session.createQuery("select itemVariant from ItemVariant itemVariant where img_src = :id");
        query.setParameter("id",Img_src);
        List<ItemVariant> itemVariantList=(List<ItemVariant>) query.list();
        session.close();
        return itemVariantList.get(0);
    }
}

