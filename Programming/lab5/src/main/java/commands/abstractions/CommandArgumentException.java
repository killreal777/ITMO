package commands.abstractions;

public class CommandArgumentException extends RuntimeException {
    private final String message;

    public CommandArgumentException(String message) {
        this.message = message + " Введите все заново.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
