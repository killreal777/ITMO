package management;

public class CommandNotFoundException extends RuntimeException {
    private final String commandName;

    public CommandNotFoundException(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public String getMessage() {
        return String.format("Команда \"%s\" не найдена", commandName);
    }
}
