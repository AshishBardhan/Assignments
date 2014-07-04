import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/18/13
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */

public class HTTPUtils {

    public static HTTPRequest getHTTPRequest(BufferedReader br){
        HTTPRequest htr = new HTTPRequest();
            try{
                String str = br.readLine();
                String str2 = str;
                String[] parts = str.split(" ");

                if(parts[0].matches("POST"))
                {
                    while(str2.length() > 0){
                        System.out.println(str2);
                        str2 = br.readLine();
                    }
 //                   System.out.println("OUT");
                    str2 = br.readLine();
                    //System.out.println("Reading Another Time");
                    System.out.println(str2);
                    if(str2 != null)
                    {
                    String[] parts2 =  str2.split("&");
                    Item ii = new Item();
                    for(int i=0;i<4;i++)
                    {
                      String[] parts3 = parts2[i].split("=");
                      if(i == 0)
                       ii.setiName(parts3[1]);
                      else if(i == 1)
                       ii.setiType(parts3[1]);
                      else if(i == 2)
                          ii.setiQty(Integer.parseInt(parts3[1]));
                      else
                          ii.setiPrice(Double.parseDouble(parts3[1]));
                    }
                    ItemDAO iDAO = new ItemDAO();
                    iDAO.initializeDAO();
                    iDAO.addItemDAO(ii);
                    }
                    //System.out.println(str2);
                }

            //String[] parts = str.split(" ");
            htr.setHTTPmethod(parts[0]);
            htr.setResourceURI(parts[1]);
            htr.setHTTPversion(parts[2]);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return htr;
    }

}