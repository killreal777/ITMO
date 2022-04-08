package exceptions_handling.exceptions;

public class CorrectableException extends UserInputException {
    private final String[] args;
    private final String message;

    public CorrectableException(String[] args, String message) {
        this.args = args;
        this.message = message;
    }

    public String[] getArgs() {
        return args;
    }

    public String getMessage() {
        return message;
    }
}
