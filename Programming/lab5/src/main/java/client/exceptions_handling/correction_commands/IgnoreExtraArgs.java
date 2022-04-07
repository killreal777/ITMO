package client.exceptions_handling.correction_commands;

import client.exceptions_handling.correction_logic.CorrectionResult;
import client.exceptions_handling.exceptions.ArgumentsAmountException;
import client.exceptions_handling.exceptions.CorrectableException;
import client.user_interface.Terminal;

import java.util.Arrays;

public class IgnoreExtraArgs implements CorrectionCommand {
    private final Terminal terminal;

    public IgnoreExtraArgs(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public CorrectionResult execute(CorrectableException exception) {
        ArgumentsAmountException argumentsAmountException = (ArgumentsAmountException) exception;
        String[] newArgs = Arrays.copyOfRange(exception.getArgs(), 0, argumentsAmountException.getExpectedAmount());
        terminal.print("Лишние аргументы были проигнорированы");
        return new CorrectionResult(true, newArgs);
    }

    @Override
    public String getMan() {
        return "\033[1;93m" + "i" + "\033[0m" + ": " + "игнорировать лишние аргументы";
    }
}
