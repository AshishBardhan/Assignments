/**
 * Created with IntelliJ IDEA.
 * User: Pradeep
 */
public class ValidationUtils {

    public static boolean validateInput(String input){
        String[] values= input.split(",");
        if(values.length!=4){
            throw new ValidationException("Wrong input format - Excpected format : name, price, qty, type ");
        }

        validatePrice(values[1]);
        validateQty(values[2]);
        validateItemType(values[3]);

        return true;
    }

    public static boolean validateItemType(String type){
        for (ItemTypeEnum itemType : ItemTypeEnum.values()) {
            if (itemType.getType().equals(type)) {
                return true;
            }
        }
        throw new ValidationException("Start again: only one of - 'row', 'manufactured', 'imported' is accepted as item type");
    }

    public static boolean validatePrice(String value){
        if(!isValidDouble(value))
             throw new ValidationException("Start again: only values like 20.15 are allowed for price of the item");
        return true;
    }

    public static boolean validateQty(String value){
        if(!isInteger(value))
            throw new ValidationException("Start again: only integer values are allowed for qty");
        return true;
    }

    public static boolean isInteger(String value){
        try {
            Integer.parseInt(value);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidDouble(String value){
        try
        {
            Double.parseDouble(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

}
