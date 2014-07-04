package classes;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/19/13
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */

public class Login {
    private String name;
    private String pswd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Login(String name, String pswd) {
        this.name = name;
        this.pswd = pswd;
    }
}
