package exceptions;

public class InvalidBotCount extends RuntimeException{
    public InvalidBotCount() {
    }

    public InvalidBotCount(String message) {
        super(message);
    }

    public InvalidBotCount(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBotCount(Throwable cause) {
        super(cause);
    }

    public InvalidBotCount(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
