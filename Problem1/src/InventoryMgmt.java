import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/11/13
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryMgmt {

    List<InventoryStore> iList = new ArrayList<InventoryStore>();

    public void add_Inv(String iName, Double iPrice, Integer iQty, String iType) {
      InventoryStore IS = new InventoryStore(iName, iPrice, iQty, iType);
      iList.add(IS);
      System.out.println(" SUCCESS : Item has been added into the List");

    }

    public void display(String iName, Double iPrice, String iType){
      if(iList.size() == 0)
          System.out.println(" ERROR : Empty List !! Please Add Some Items into the List");
      else
      {
         int i = 0;
         int flag = 0;
         Double iTax = 0.00;

         //System.out.println(" Parameters  : " + iName + iPrice + iType);

         while(i<iList.size() && flag == 0)
         {
           String str1 = iList.get(i).getiName();
           String str2 = iList.get(i).getiType();
           Double dble = iList.get(i).getiPrice();
                                                                /*
             System.out.println(" Item Name   : " + str1);
             System.out.println(" Price       : " + iPrice);
             System.out.println(" Type        : " + str2);    */
             //System.out.println(" Final Price : " + iFPrice);

           if(str1.matches(iName) && str2.matches(iType) && dble.doubleValue() == iPrice.doubleValue())
           {
             if(str2.matches("Raw"))
              iTax = 0.125*iList.get(i).getiPrice();
             else if(str2.matches("Manufactured"))
              iTax = 0.125*iList.get(i).getiPrice() + 0.02*(1.125*iList.get(i).getiPrice());
             else
             {
              iTax = 0.1*iList.get(i).getiPrice();
              if(iTax <= 100.00)
                iTax += 5.00;
              else if(iTax > 100.00 && iTax <= 200.00)
                iTax += 10.00;
              else
                iTax += (0.05*(iTax+iList.get(i).getiPrice()));
             }
               flag = 1;
           }
            else
              i++;
         }

          if(flag == 0)
              System.out.println(" ERROR : Record Not Found !! Please Add Some Items into the List");
          else
          {
              Double iFPrice = iList.get(i).getiPrice() + iTax;
              System.out.println(" SUCCESS : Record Found !!");
              System.out.println(" Item Name   : " + iList.get(i).getiName());
              System.out.println(" Price       : " + iList.get(i).getiPrice());
              System.out.println(" Sales Tax   : " + iTax);
              System.out.println(" Final Price : " + iFPrice);
          }

      }

    }

    public static void main(String[] args) {
        InventoryMgmt IM = new InventoryMgmt();
        IM.add_Inv("Glycodin",170.50,100,"Manufactured");
        IM.add_Inv("Protein Gainer Plus",1750.25,10,"Imported");
        IM.add_Inv("Bottle Packs",70.20,1000,"Raw");
        IM.display("Glycodin",170.50,"Manufactured");
        IM.display("Protein Gainer Plus",1750.25,"Imported");
        IM.display("Bottle",70.20,"Raw");

    }
}