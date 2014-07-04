package dao;

import classes.Product;
import classes.Variant;
import utils.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**                                                                          i
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/24/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductVariantDAO {
    Statement prod_st = null;
    ResultSet prod_rs = null;
    Connection prod_con = null;


    public void initializeDAO(){
        prod_con = ConnectionUtil.getCon();
    }
     //       /*

    public Variant getVariant(String img_src){

        Variant var = new Variant();
        try{
            Statement st = prod_con.createStatement();
            ResultSet rs = st.executeQuery("select * from variant where var_img_src = '" + img_src + "'");
            rs.next();
            var.setProductID(rs.getInt(1));
            var.setVariantID(rs.getInt(2));
            var.setVariantName(rs.getString(3));
            var.setVariantImgSrc(rs.getString(4));
        }
        catch (SQLException ex){
            ex.getStackTrace();
        }
        return var;

    }

    public Product getProduct(Integer ID){

        Product prod = new Product();
        try{
            Statement st = prod_con.createStatement();
            ResultSet rs = st.executeQuery("select * from product where prod_id = " + ID);
            rs.next();
            prod.setProductID(rs.getInt(1));
            prod.setProductName(rs.getString(2));
            prod.setProductQty(rs.getInt(3));
            prod.setProductType(rs.getString(4));
            prod.setProductPrice(rs.getDouble(5));
        }
        catch (SQLException ex){
            ex.getStackTrace();
        }
        return prod;

    }


    public List<Variant> getVariantList(Integer pID){
        List<Variant> varList = new ArrayList<Variant>();
        try{
            Statement st = prod_con.createStatement();
            ResultSet rs = st.executeQuery("select * from variant where prod_ID = " +pID);
            while(rs.next()){
                Variant var = new Variant();
                var.setProductID(rs.getInt(1));
                var.setVariantID(rs.getInt(2));
                var.setVariantName(rs.getString(3));
                var.setVariantImgSrc(rs.getString(4));
                varList.add(var);
            }
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
        return varList;
    }

    public List<Product> getProductList(){
        List<Product> prodList = new ArrayList<Product>();
        try{
            Statement st = prod_con.createStatement();
            ResultSet rs = st.executeQuery("select * from product");
            while(rs.next()){
                Product prod = new Product();
                prod.setProductID(rs.getInt(1));
                prod.setProductName(rs.getString(2));
                prod.setProductQty(rs.getInt(3));
                prod.setProductType(rs.getString(4));
                prod.setProductPrice(rs.getDouble(5));
                List <Variant> varList = getVariantList(prod.getProductID());
                prod.setVariantList(varList);
                prodList.add(prod);
            }
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
        return prodList;
    } //    */

    public boolean searchProductByName(String Name)throws SQLException {

        PreparedStatement pst = prod_con.prepareStatement("select * from product where prod_name = ?");
        pst.setString(1, Name);
        prod_rs = pst.executeQuery();
        ResultSetMetaData rsmd = prod_rs.getMetaData();
        int numColumns = rsmd.getColumnCount();
        prod_rs.next();

        if(prod_rs.getRow() != 0 )
            return true;
        else
            return false;
    }

    public boolean searchProductByID(Integer ID)throws SQLException {

        PreparedStatement pst = prod_con.prepareStatement("select * from product where prod_id = ?");
        pst.setInt(1, ID);
        prod_rs = pst.executeQuery();
        ResultSetMetaData rsmd = prod_rs.getMetaData();
        int numColumns = rsmd.getColumnCount();
        prod_rs.next();

        if(prod_rs.getRow() != 0 )
            return true;
        else
            return false;
    }

    public boolean addProduct(Product prod) throws SQLException{

       if( (! searchProductByName(prod.getProductName())) && (! searchProductByID(prod.getProductID())) ){
            PreparedStatement pst = prod_con.prepareStatement("insert into product values(?,?,?,?,?)");
            pst.setInt(1, prod.getProductID());
            pst.setString(2, prod.getProductName());
            pst.setInt(3, prod.getProductQty());
            pst.setString(4, prod.getProductType());
            pst.setDouble(5, prod.getProductPrice());
            pst.executeUpdate();
            return true;
        }
        else
            return false;
    }


    public boolean searchVariantByID(Integer pID, Integer vID)throws SQLException {

        PreparedStatement pst = prod_con.prepareStatement("select * from variant where prod_id = ? and var_id = ?");
        pst.setInt(1, pID);
        pst.setInt(2, vID);
        prod_rs = pst.executeQuery();
        ResultSetMetaData rsmd = prod_rs.getMetaData();
        int numColumns = rsmd.getColumnCount();
        prod_rs.next();

        if(prod_rs.getRow() != 0 )
            return true;
        else
            return false;
    }


    public boolean searchVariantByName(String Name)throws SQLException {

        PreparedStatement pst = prod_con.prepareStatement("select * from variant where var_name = ?");
        pst.setString(1, Name);
        prod_rs = pst.executeQuery();
        ResultSetMetaData rsmd = prod_rs.getMetaData();
        int numColumns = rsmd.getColumnCount();
        prod_rs.next();

        if(prod_rs.getRow() != 0 )
            return true;
        else
            return false;
    }

    public boolean addVariant(Variant var) throws SQLException{

        if( (! searchVariantByID(var.getProductID(),var.getVariantID()))){
            PreparedStatement pst = prod_con.prepareStatement("insert into variant values(?,?,?,?)");
            pst.setInt(1, var.getProductID());
            pst.setInt(2, var.getVariantID());
            pst.setString(3, var.getVariantName());
            pst.setString(4, var.getVariantImgSrc());
            pst.executeUpdate();
            return true;
        }
        else
            return false;
    }

    public boolean searchVariantByImgSrc(String Name)throws SQLException{

        PreparedStatement pst = prod_con.prepareStatement("select * from variant where var_img_src = ?");
        pst.setString(1, Name);
        prod_rs = pst.executeQuery();
        ResultSetMetaData rsmd = prod_rs.getMetaData();
        int numColumns = rsmd.getColumnCount();
        prod_rs.next();

        if(prod_rs.getRow() != 0 )
            return true;
        else
            return false;

    }

    public boolean updateVariantImage(String Img_Src) throws SQLException{

        if(! searchVariantByImgSrc(Img_Src)){
            PreparedStatement pst = prod_con.prepareStatement("update variant set var_img_src = ? where var_img_src = ?");
            pst.setString(1, Img_Src);
            pst.setString(2, "default");
            pst.executeUpdate();
            return true;
        }
        else
            return false;

    }

    public boolean delProduct(String Name) throws SQLException,ServletException,IOException{

        if(searchProductByName(Name)){
            final String imagePath = "C://Users//Ashish Bardhan//IdeaProjects//Assignments//Project5//web";

            prod_st = prod_con.createStatement();
            prod_rs = prod_st.executeQuery("select var_img_src from variant where prod_id in (select prod_id from product where prod_name = '" + Name + "')");

            while(prod_rs.next()){
                File f = new File(imagePath + prod_rs.getString(1));
                FileInputStream fstream = new FileInputStream(f);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                br.close();
                fstream.close();
                f.delete();
            }

            PreparedStatement pst = prod_con.prepareStatement("delete from variant where prod_id in (select prod_id from product where prod_name = '" + Name + "')");
            pst.executeUpdate();
            pst = prod_con.prepareStatement("delete from product where prod_name = '" + Name + "'");
            pst.executeUpdate();
            return true;
        }
        else
            return false;
    }

    public boolean delVariant(String Name) throws SQLException,ServletException{

         if(searchVariantByImgSrc(Name)){
            PreparedStatement pst = prod_con.prepareStatement("delete from variant where var_img_src = '" + Name + "'");
            pst.executeUpdate();
            return true;
         }
        else
            return false;
    }

    public boolean checkChangeVariant(Variant var){
      if(var.getProductID() == 0 && var.getVariantID() == 0 && var.getVariantName().equals("XYZ-XYZ") && var.getVariantImgSrc().equals("XYZ-XYZ"))
        return false;
      else
         return true;
    }

    public boolean checkChangeProduct(Product prod){
        if(prod.getProductID().equals(0) && prod.getProductQty().equals(0) && prod.getProductPrice().equals(0.0) && prod.getProductName().equals("XYZ-XYZ") && prod.getProductType().equals("XYZ-XYZ"))
            return false;
        else
            return true;
    }


    public boolean updateVariant(Variant new_variant, Variant old_variant) throws SQLException{

     if(checkChangeVariant(new_variant)){
         if(! new_variant.getVariantName().equals("XYZ-XYZ")){
             PreparedStatement pst = prod_con.prepareStatement("update variant set var_name = ? where var_id = ? and prod_id = ?");
             pst.setString(1, new_variant.getVariantName());
             pst.setInt(2, old_variant.getVariantID());
             pst.setInt(3, old_variant.getProductID());
             pst.executeUpdate();
         }
         if(new_variant.getProductID() != 0){
             PreparedStatement pst = prod_con.prepareStatement("update variant set prod_id = ? where var_id = ? and prod_id = ?");
             pst.setInt(1, new_variant.getProductID());
             pst.setInt(2, old_variant.getVariantID());
             pst.setInt(3, old_variant.getProductID());
             pst.executeUpdate();
         }
         if(new_variant.getVariantID() != 0){
             PreparedStatement pst = prod_con.prepareStatement("update variant set var_id = ? where var_id = ? and prod_id = ?");
             pst.setInt(1, new_variant.getVariantID());
             pst.setInt(2, old_variant.getVariantID());
             pst.setInt(3, old_variant.getProductID());
             pst.executeUpdate();
         }
       return true;
     }
     else
       return false;
    }


    public boolean updateProduct(Product new_product, Product old_product) throws SQLException{

        if(checkChangeProduct(new_product)){
            if(! new_product.getProductName().equals("XYZ-XYZ")){
                PreparedStatement pst = prod_con.prepareStatement("update product set prod_name = ? where prod_id = ?");
                pst.setString(1, new_product.getProductName());
                pst.setInt(2, old_product.getProductID());
                pst.executeUpdate();
            }
            if(! new_product.getProductType().equals("XYZ-XYZ")){
                PreparedStatement pst = prod_con.prepareStatement("update product set prod_type = ? where prod_id = ?");
                pst.setString(1, new_product.getProductType());
                pst.setInt(2, old_product.getProductID());
                pst.executeUpdate();
            }
            if(! new_product.getProductQty().equals(0)){
                PreparedStatement pst = prod_con.prepareStatement("update product set prod_qty = ? where prod_id = ?");
                pst.setInt(1, new_product.getProductQty());
                pst.setInt(2, old_product.getProductID());
                pst.executeUpdate();
            }
            if(! new_product.getProductPrice().equals(0.0)){
                PreparedStatement pst = prod_con.prepareStatement("update product set prod_price = ? where prod_id = ?");
                pst.setDouble(1, new_product.getProductPrice());
                pst.setInt(2, old_product.getProductID());
                pst.executeUpdate();
            }
            if(! new_product.getProductID().equals(0)){
                PreparedStatement pst = prod_con.prepareStatement("update product set prod_id = ? where prod_id = ?");
                pst.setInt(1, new_product.getProductID());
                pst.setInt(2, old_product.getProductID());
                pst.executeUpdate();
                pst = prod_con.prepareStatement("update variant set prod_id = ? where prod_id = ?");
                pst.setInt(1, new_product.getProductID());
                pst.setInt(2, old_product.getProductID());
                pst.executeUpdate();
            }
            return true;
        }
        else
            return false;
    }



}

