package Commerce.slotify.exception;

public class EntityNotPresentException extends RuntimeException {

    public EntityNotPresentException(String message) {
        super(message);
    }

    public EntityNotPresentException(){
        super("entity not present for this id");
    }
}
