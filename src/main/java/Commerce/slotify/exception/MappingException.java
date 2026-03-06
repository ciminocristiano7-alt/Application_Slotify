package Commerce.slotify.exception;

public class MappingException extends RuntimeException {
    public MappingException(String message) {
        super(message);
    }

    public MappingException() {
        super ("error during mapping");
    }
}
