package client.exceptions_handling.exceptions;

public class NoSuchCommandException extends UserInputException {
    private final String enteredName;

    public NoSuchCommandException(String enteredName) {
        this.enteredName = enteredName;
    }

    @Override
    public String getMessage() {
        return String.format("Не найдено команды \"%s\"\n" +
                "Для вывода справки по доступным командам введите \"help\"", enteredName);
    }
}
