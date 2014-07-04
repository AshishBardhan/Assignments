import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/14/13
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteItem {
    public static void main(String[] args) {
        DeleteItem dli = new DeleteItem();
        dli.delete();
    }


    public void delete() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter Item Name to be deleted : ");
        String tempName= sc1.nextLine();
        ItemDAO iDAO = new ItemDAO();
        iDAO.initializeDAO();
        iDAO.delItemDAO(tempName);
        System.out.println("The Item has been deleted");
    }

}
