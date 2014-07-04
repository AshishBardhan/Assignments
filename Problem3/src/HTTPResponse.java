import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/18/13
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */

public class HTTPResponse {

    private final int BUFFER_SIZE = 2048;

    public void serve(HTTPRequest htr, OutputStream outputStream) throws IOException
    {

        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HTTPApplication.WEB_ROOT, htr.getResourceURI());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    outputStream.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            }
            else {                                // file not found
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                outputStream.write(errorMessage.getBytes());
            }
        }
        catch (IOException ex) {                    // thrown if cannot instantiate a File object
            ex.printStackTrace();
        }
        finally {
            if (fis != null)
                fis.close();
        }

    }
}
