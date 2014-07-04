import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/18/13
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */

public class HTTPApplication {
    public static final String WEB_ROOT = System.getProperty("user.dir")+ File.separator+"webroot" ;
    public static void main(String[] args){
        HTTPServer httpServer = new HTTPServer();
        httpServer.await();
    }
}