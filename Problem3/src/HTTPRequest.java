/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/18/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class HTTPRequest {
    private String resourceURI;
    private String HTTPmethod;
    private String HTTPversion;

    public HTTPRequest(String resourceURI, String HTTPmethod, String HTTPversion) {
        this.resourceURI = resourceURI;
        this.HTTPmethod = HTTPmethod;
        this.HTTPversion = HTTPversion;
    }

    public HTTPRequest() {

    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getHTTPmethod() {
        return HTTPmethod;
    }

    public void setHTTPmethod(String HTTPmethod) {
        this.HTTPmethod = HTTPmethod;
    }

    public String getHTTPversion() {
        return HTTPversion;
    }

    public void setHTTPversion(String HTTPversion) {
        this.HTTPversion = HTTPversion;
    }

    @Override
    public String toString() {
        return "HTTP Request has been found" + '\n' +
                "HTTPmethod = " + HTTPmethod + '\n' +
                "HTTPversion = " + HTTPversion + '\n' +
                "resourceURI = " + resourceURI;
    }
}
