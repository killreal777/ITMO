package exceptions_handling.correction_commands;

import exceptions_handling.correction_logic.CorrectionResult;
import exceptions_handling.exceptions.CorrectableException;

public interface CorrectionCommand {
    public CorrectionResult execute(CorrectableException exception);
    public String getMan();
}
