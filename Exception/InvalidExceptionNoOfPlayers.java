package Exception;

public class InvalidExceptionNoOfPlayers extends RuntimeException{
    public InvalidExceptionNoOfPlayers() {
    }

    public InvalidExceptionNoOfPlayers(String message) {
        super(message);
    }

    public InvalidExceptionNoOfPlayers(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidExceptionNoOfPlayers(Throwable cause) {
        super(cause);
    }

    public InvalidExceptionNoOfPlayers(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
