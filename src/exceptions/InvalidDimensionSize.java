package exceptions;

public class InvalidDimensionSize extends RuntimeException{
    public InvalidDimensionSize() {
    }

    public InvalidDimensionSize(String message) {
        super(message);
    }

    public InvalidDimensionSize(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDimensionSize(Throwable cause) {
        super(cause);
    }

    public InvalidDimensionSize(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
