package exceptions_handling.correction_commands;

import exceptions_handling.correction_logic.CorrectionResult;
import exceptions_handling.exceptions.ArgumentValueException;
import exceptions_handling.exceptions.CorrectableException;
import user_interface.ReadingMode;
import user_interface.Terminal;

public class ReEnterArgs implements CorrectionCommand {
    private final Terminal terminal;

    public ReEnterArgs(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public CorrectionResult execute(CorrectableException exception) {
        String[] newArgs;
        if (exception instanceof ArgumentValueException) {
            ArgumentValueException argumentValueException = (ArgumentValueException) exception;
            newArgs = terminal.readLine(argumentValueException.getReadingMode(), "Введите аргументы заново: ");
        } else
            newArgs = terminal.readLine(ReadingMode.SPLIT, "Введите аргументы заново: ");
        return new CorrectionResult(true, newArgs);
    }

    @Override
    public String getMan() {
        return "\033[1;93m" + "r" + "\033[0m" + ": " + "ввести все аргументы заново";
    }
}
