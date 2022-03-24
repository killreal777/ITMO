package client.exceptions_handling.correction_commands;

import client.exceptions_handling.correction_logic.CorrectionResult;
import client.exceptions_handling.exceptions.CorrectableException;
import client.user_interface.Terminal;

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
        return "\"b\" - прервать исполнение команды";
    }

}
