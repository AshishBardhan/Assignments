import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/13/13
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddProductVariant {
    Product pd = new Product();
    int varSize;

    public static void main(String[] args) {
        AddProductVariant apd = new AddProductVariant();
        apd.input();
        apd.connectDAO();
    }

    public void input() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter Product ID : ");
        pd.setProdID(sc1.nextInt());
        System.out.println("Enter Product Qty : ");
        pd.setProdQty(sc1.nextInt());
        System.out.println("Enter Product Price : ");
        pd.setProdPrice(sc1.nextDouble());
        System.out.println("Enter Product Variant Size : ");
        varSize = (sc1.nextInt());
        String buffer = sc1.nextLine();
        System.out.println("Enter Product Name : ");
        pd.setProdName(sc1.nextLine());
        for(int i = 1; i <= varSize; i++)
        {
          Variant vr = new Variant();
          vr.setVarID(i);
          vr.setProdID(pd.getProdID());
          System.out.println("Enter the color of Variant " + i + " : ");
          vr.setColor(sc1.nextLine());
          pd.variantList.add(vr);
        }
        System.out.println("All the variants have been added");
    }


    public void connectDAO() {
        ProductVariantDAO pDAO = new ProductVariantDAO();
        pDAO.initializeDAO();
        pDAO.addProductVariantDAO(pd);
    }
}
