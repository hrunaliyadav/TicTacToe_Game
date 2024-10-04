package exceptions;

public class InvalidRowAndColumn extends RuntimeException{
    public InvalidRowAndColumn() {
    }

    public InvalidRowAndColumn(String message) {
        super(message);
    }

    public InvalidRowAndColumn(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRowAndColumn(Throwable cause) {
        super(cause);
    }

    public InvalidRowAndColumn(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
