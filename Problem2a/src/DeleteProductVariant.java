import java.sql.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/13/13
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteProductVariant {

    public static void main(String[] args) {
        DeleteProductVariant dpv = new DeleteProductVariant();
        dpv.delete();
    }


    public void delete() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter Product Name to be deleted : ");
        String tempName= sc1.nextLine();
        ProductVariantDAO pDAO = new ProductVariantDAO();
        pDAO.initializeDAO();
        pDAO.delProductVariantDAO(tempName);
        System.out.println("The Product and its variant(s) have been deleted");
    }

}
