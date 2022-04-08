package exceptions_handling.correction_commands;

import exceptions_handling.correction_logic.CorrectionResult;
import exceptions_handling.exceptions.CorrectableException;
import user_interface.Terminal;

public class BreakExecution implements CorrectionCommand {
    private final Terminal terminal;

    public BreakExecution(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public CorrectionResult execute(CorrectableException exception) {
        terminal.print("Исполнение команды прервано\n");
        return new CorrectionResult(false);
    }

    @Override
    public String getMan() {
        return "\033[1;93m" + "b" + "\033[0m" + ": " + "прервать исполнение команды";
    }
}
