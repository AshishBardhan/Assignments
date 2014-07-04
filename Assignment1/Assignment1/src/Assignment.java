
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Pradeep
 */
public class Assignment {

    private static List<Item> items= new ArrayList<Item>();
    private static final String EXIT_CODE="exit";

    public static void main(String[] args) {

        //starting point of the application
        startApplication();

    }

    private static void startApplication() {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("to create a new item, please enter the input in - name,price,qty,type - format(separated by commas");
            try{
                String input=br.readLine();

                if(input.equals(EXIT_CODE)){
                    break;
                }
                ValidationUtils.validateInput(input);
                Item item=buildItem(input);
                items.add(item);
                System.out.println("A new item is created with the follwing values:");
                printItemInfo(item);
            }catch (ValidationException ve){
                System.out.println(ve.getMessage());
            } catch (IOException ex){
                System.out.println("error in reading input: "+ex.getMessage());
            }
        }

        //we should also close the readers here
        System.out.println("exiting application!!");
        printAllItemsInfo();
    }

    private static Item buildItem(String input) {
        String[] values=input.split(",");

        Item item = new Item();
        item.setName(values[0]);
        item.setPrice(Double.parseDouble(values[1]));
        item.setQty(Integer.parseInt(values[2]));
        item.setType(values[3]);

        return item ;

    }

    private static void printItemInfo(Item item){
        System.out.println("Name: " + item.getName());
        System.out.println("Price: " + item.getPrice());
        System.out.println("Qty: " + item.getQty());
        System.out.println("Type: " + item.getType());

        System.out.println("sales tax per item: "+ item.getSalesTaxPerItem() );
        System.out.println("total sales tax: "+ item.getTotalSalesTax());
        System.out.println("Total price: "+ item.getFinalPrice());
        System.out.println();
    }

    private static void printAllItemsInfo(){
        for(Item item:items){
            printItemInfo(item);
        }
    }

}
