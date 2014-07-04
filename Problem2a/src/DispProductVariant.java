import java.sql.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/13/13
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class DispProductVariant {


    public static void main(String[] args) {
        DispProductVariant dpv = new DispProductVariant();
        dpv.display();
    }

 public void display() {

     ProductVariantDAO pDAO = new ProductVariantDAO();

     Scanner sc1 = new Scanner(System.in);
     System.out.println("Enter Product Name to be checked : ");
     String tempName= sc1.nextLine();

     pDAO.initializeDAO();
     Product prod = new Product();
     prod = pDAO.dispProductVariantDAO(tempName);
     if(prod.getProdName() != null)
     {
         System.out.println(" RECORD FOUND ");
         System.out.println(" Name : " + prod.getProdName() + "\n pID : " + prod.getProdID() + "\n Price : " + prod.getProdPrice() + "\n Qty : " + prod.getProdQty());
         System.out.println(" Total Variants : " + prod.variantList.size());
         int i = 0;
         while(i < prod.variantList.size())
         {
             System.out.println(" vID : " + prod.variantList.get(i).getVarID()  + " Color : " + prod.variantList.get(i).getColor());
             ++i;
         }
     }
     else
         System.out.println(" RECORD NOT FOUND ");
 }
}
