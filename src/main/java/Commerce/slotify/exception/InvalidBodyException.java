package Commerce.slotify.exception;

public class InvalidBodyException extends RuntimeException {
    public InvalidBodyException(String message) {
        super(message);
    }

    public InvalidBodyException() {
        super("error in body sent");
    }

}
