package Exception;

public class BotLevelIsNull extends RuntimeException {
    public BotLevelIsNull() {
    }

    public BotLevelIsNull(String message) {
        super(message);
    }

    public BotLevelIsNull(String message, Throwable cause) {
        super(message, cause);
    }

    public BotLevelIsNull(Throwable cause) {
        super(cause);
    }

    public BotLevelIsNull(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
