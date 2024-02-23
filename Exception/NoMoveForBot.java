package Exception;

public class NoMoveForBot extends RuntimeException {
    public NoMoveForBot() {
    }

    public NoMoveForBot(String message) {
        super(message);
    }

    public NoMoveForBot(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMoveForBot(Throwable cause) {
        super(cause);
    }

    public NoMoveForBot(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
