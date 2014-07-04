/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/14/13
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */

public enum ItemType{
    RAW ("Raw"),
    MANUFACTURED("Manufactured"),
    IMPORTED("Imported");

    private final String name;

    private ItemType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String returnType(){
        return name;
    }
}