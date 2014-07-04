import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/12/13
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddItem {

    Item it = new Item();

    public static void main(String[] args) {
        AddItem ai = new AddItem();
        ai.initialize();
        ai.input();
    }

    public void initialize() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter Item Name : ");
        it.name = sc1.nextLine();
        System.out.println("Enter Item Type : ");
        it.type = sc1.nextLine();
        System.out.println("Enter Item Price : ");
        it.price = sc1.nextDouble();
        System.out.println("Enter Item Qty : ");
        it.qty = sc1.nextInt();
    }

    public void input() {
        ItemDAO iDAO = new ItemDAO();
        iDAO.initializeDAO();
        iDAO.addItemDAO(it);
        System.out.println("The Product Has Been Added");
    }
}
