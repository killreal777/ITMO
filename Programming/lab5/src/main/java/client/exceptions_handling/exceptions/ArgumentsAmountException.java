package client.exceptions_handling.exceptions;


public class ArgumentsAmountException extends CorrectableException {
    private final int enteredAmount;
    private final int expectedAmount;

    public ArgumentsAmountException(String[] args, int expected) {
        super(args, String.format("(введено: %d, ожидалось: %d)", args.length, expected));
        this.enteredAmount = args.length;
        this.expectedAmount = expected;
    }

    public int getEnteredAmount() {
        return enteredAmount;
    }

    public int getExpectedAmount() {
        return expectedAmount;
    }
}
