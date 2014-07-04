import java.sql.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/14/13
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProductVariantDAO {

    Statement st = null;
    ResultSet rs = null;
    Connection con = null;

    public void initializeDAO(){


        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "root");
           }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProductVariantDAO(Product prod){

        try{
            PreparedStatement pst = con.prepareStatement("insert into product values(?,?,?,?)");
            pst.setInt(1, prod.getProdID());
            pst.setString(2, prod.getProdName());
            pst.setInt(3, prod.getProdQty());
            pst.setDouble(4,prod.getProdPrice());
            pst.executeUpdate();

            for(int i = 0; i < prod.variantList.size(); i++)
            {
                pst = con.prepareStatement("insert into variant values(?,?,?)");
                pst.setInt(1, prod.variantList.get(i).getVarID());
                pst.setInt(2, prod.variantList.get(i).getProdID());
                pst.setString(3, prod.variantList.get(i).getColor());
                pst.executeUpdate();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product dispProductVariantDAO(String Name){

        Product pd = new Product();
        try{
            st = con.createStatement();



            rs = st.executeQuery("select * from product natural join variant where pName = '" + Name + "'");
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();


            while(rs.next())
            {
                pd.setProdID(rs.getInt(1));
                pd.setProdName(rs.getString(2));
                pd.setProdQty(rs.getInt(3));
                pd.setProdPrice(rs.getDouble(4));
                Variant vr = new Variant(rs.getInt(5),rs.getInt(1),rs.getString(6));
                pd.variantList.add(vr);
            }
         return pd;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pd;
    }

    public void delProductVariantDAO(String Name){
        try {
            st = con.createStatement();
            PreparedStatement pst = con.prepareStatement("delete from variant where pID in (select pID from product where pName = '" + Name + "')");
            pst.executeUpdate();
            pst = con.prepareStatement("delete from product where pName = '" + Name + "'");
            pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
