import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/18/13
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */

public class HTTPServer {

    private final int PORT = 8080;

    public void await()
    {

        ServerSocket servSock = null;
        try{
            servSock = new ServerSocket(PORT);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        boolean shutdown = false;

        while(!shutdown){
            try{
                OutputStream outputStream ;
                Socket sock = servSock.accept();
                outputStream=sock.getOutputStream();
                InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                HTTPRequest httpRequest = HTTPUtils.getHTTPRequest(bufferedReader);
                System.out.println(httpRequest.toString());
                HTTPResponse httpResponse = new HTTPResponse();
                httpResponse.serve(httpRequest,outputStream);
                sock.close();
            }

            catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
