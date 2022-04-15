package commands.server_creation_commands.creators;

public class CreationException extends RuntimeException {
    private final String message;

    public CreationException(String message) {
        this.message = message + " Повторите ввод аргумента.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
