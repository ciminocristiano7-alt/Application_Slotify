package Commerce.slotify.exception;

public class NoUserForBookingException extends RuntimeException {
    public NoUserForBookingException(String message) {
        super(message);
    }

    public NoUserForBookingException(){
        super("no one has reserved this prenotation");
    }
}
