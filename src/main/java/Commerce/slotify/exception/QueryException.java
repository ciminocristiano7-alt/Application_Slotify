package Commerce.slotify.exception;

public class QueryException extends RuntimeException {
    public QueryException(String message) {
        super(message);
    }
    public QueryException() {
        super("error during query");
    }

}
