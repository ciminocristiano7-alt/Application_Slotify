package Commerce.slotify.exception;

public class MissingParamException extends RuntimeException {
    public MissingParamException(String message) {
        super(message);
    }

    public MissingParamException () {
        super("Error in params sent");
    }
}
