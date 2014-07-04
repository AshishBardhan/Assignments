/**
 * Created with IntelliJ IDEA.
 * User: Pradeep
 */
public enum ItemTypeEnum {
    RAW("raw"),
    MANUFACTURED("manufactured"),
    IMPORTED("imported");

    private String type;

    ItemTypeEnum(String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }
}

