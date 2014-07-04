/**
 * Created with IntelliJ IDEA.
 * User: Pradeep
 */
public class ValidationException extends RuntimeException {

    public ValidationException(Throwable e) {
        super(e);
    }

    public ValidationException(String message) {
        super(message);
    }

}
